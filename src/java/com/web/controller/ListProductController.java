package com.web.controller;

import com.web.dao.ProductDAO;
import com.web.entity.Category;
import com.web.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ListProduct", urlPatterns="/listproduct")
public class ListProductController extends HttpServlet
{
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            List<Product> products = new ProductDAO().getAllProduct();
            request.setAttribute("ListProduct", products);
            request.getRequestDispatcher("backend/products/list.jsp").forward(request, response);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        processRequest(req, resp);
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        processRequest(req, resp);
    }
}
