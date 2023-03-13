package com.example.exercise1_tinh_chiet_khau;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TinhChietKhauServlet", value = "/display-discount")
public class TinhChietKhauServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("productDescription");
        int price = Integer.parseInt(request.getParameter("price"));
        int percent = Integer.parseInt(request.getParameter("discount"));
        int discountAmount = (int) (price * percent * 0.01);
        int discountPrice = price - discountAmount;
        String productDescription = request.getParameter("productDescription");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<p>Product description : " + productDescription+ "</p>");
        writer.println("<h3>Discount Amount: " + discountAmount + "</h3>");
        writer.println("<h3>Discount Price: " + discountPrice + "</h3>");
        writer.println("</html>");


    }
}
