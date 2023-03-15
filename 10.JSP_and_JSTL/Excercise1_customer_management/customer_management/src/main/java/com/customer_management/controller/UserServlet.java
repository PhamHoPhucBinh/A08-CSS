package com.customer_management.controller;

import com.customer_management.bean.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    public static List<Customer> customers;

    public void init() throws ServletException {
        super.init();
        customers = new ArrayList<>();
        customers.add(new Customer("01", "Tai", "23/10/96", "Da Nang", "link"));
        customers.add(new Customer("02", "Nam", "10/10/96", "Quang Nam", "link"));
        customers.add(new Customer("03", "Luan", "05/10/95", "Da Nang", "link"));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ListCustomer" , customers);
        request.getRequestDispatcher("/user/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
