package com.controller;

import com.model.Order;
import com.model.Product;
import com.service.OrderService;
import com.service.OrderServiceImpl;
import com.service.ProductService;
import com.service.ProductServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {

    private OrderService orderService;
    private ProductService productService;

    public void init() {
        productService = new ProductServiceImpl();
        orderService = new OrderServiceImpl();
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
//                    searchData(request, response);
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
        List<Order> orderList = orderService.findAll();
        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("orderList", orderService.findAll());
        request.setAttribute("productList",productService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order existingOrder = orderService.findById(orderId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/update.jsp");
        request.setAttribute("order", existingOrder);
        request.setAttribute("productList", productService.findAll());
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = this.orderService.findById(orderId);
        RequestDispatcher dispatcher;
        request.setAttribute("order", order);
        dispatcher = request.getRequestDispatcher("user/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
//        String customerName = request.getParameter("orderDate");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date orderDate = null;
        try {
            orderDate = dateFormat.parse(request.getParameter("orderDate"));

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = productService.findById(productId);
        Order order = new Order(orderDate, product, quantity, false);
        orderService.add(order);
        response.sendRedirect("/OrderServlet?isCreate=1");
    }
    private void updateData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date orderDate = null;
        try {
            orderDate = dateFormat.parse(request.getParameter("orderDate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int productId = Integer.parseInt(request.getParameter("productId"));

        Product product = productService.findById(productId);
        Order book = new Order(orderId, orderDate, product, quantity,false);
        orderService.update(book);
        response.sendRedirect("/OrderServlet");
    }
    private void deleteData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        //customerService.remove(customerId); //this is hard-delete
        orderService.softDelete(orderId);
        List<Order> orderList = orderService.findAll();
        request.setAttribute("orderId", orderId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }
}
