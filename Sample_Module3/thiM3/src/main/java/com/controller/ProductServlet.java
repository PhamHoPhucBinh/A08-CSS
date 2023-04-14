package com.controller;

import com.model.Category;
import com.model.Product;
import com.service.CategoryService;
import com.service.CategoryServiceImpl;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {

    private ProductService productService;
    private CategoryService categoryService;

    public void init() {
        categoryService = new CategoryServiceImpl();
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "update":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                case "search":
                    searchData(request, response);
                    break;
                default:
                    listData(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listData(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categoryList", categoryService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product existingProduct = productService.findById(productId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/update.jsp");
        request.setAttribute("product", existingProduct);
        request.setAttribute("categoryList", categoryService.findAll());
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = this.productService.findById(productId);
        RequestDispatcher dispatcher;
        request.setAttribute("product", product);
        dispatcher = request.getRequestDispatcher("user/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void searchData(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String productName = request.getParameter("productName");
        List<Product> productList = productService.findByProductName(productName);
        request.setAttribute("result",productList);
        request.getRequestDispatcher("user/search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    addData(request, response);
                    break;
                case "update":
                    updateData(request, response);
                    break;
                case "delete":
                    deleteData(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void addData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        Double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = categoryService.findById(categoryId);
        Product product = new Product(productName, productPrice, quantity, color, category, false);
        productService.add(product);
        response.sendRedirect("/ProductServlet?isCreate=1");
    }

    private void updateData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        Double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = categoryService.findById(categoryId);
        Product book = new Product(productName, productPrice, quantity, color, category);
        productService.update(book);
        response.sendRedirect("/ProductServlet");
    }
    private void deleteData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        productService.soft_remove(productId);
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }
}
