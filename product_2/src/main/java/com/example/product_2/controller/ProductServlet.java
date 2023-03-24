package com.example.product_2.controller;

import com.example.product_2.bean.Product;
import com.example.product_2.service.ProductService;
import com.example.product_2.service.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                showList(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showUpdate(request,response);
                break;
            default:
                showError(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showError(request, response);
            return;
        }

        switch (action) {
            case "create":
                doCreate(request, response);
                break;
            case "update":
                doUpdate(request, response);
                break;
            case "delete":
                Delete(request,response);
                break;
            default:
                showError(request, response);
        }
    }

    // TODO: 23-Mar-23 Show Function:
    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/update.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/create.jsp").forward(request, response);
    }


    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("products", productService.findById(id));
        request.getRequestDispatcher("/user/delete.jsp").forward(request, response);

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productService.findAll());
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);

    }

    private void showError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }

    // TODO: 23-Mar-23 CRUD function:
    private void Delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        productService.delete(id);
        response.sendRedirect("/ProductServlet?action=list");
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String status = request.getParameter("status");
        Product product = new Product(id, name, price,status);
        productService.update(product);
        response.sendRedirect("/ProductServlet?action=list");
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String status = request.getParameter("status");
        Product product = new Product(id, name, price,status);
        productService.create(product);
        response.sendRedirect("/ProductServlet?action=list");
    }
}
