package com.web.controller;

import com.web.dao.ProductDAO;
import com.web.entity.Product;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="DeleteProduct", urlPatterns = "/deleteproduct")
public class DeleteProductController extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            ProductDAO dao = new ProductDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            Product productDelete = dao.getProductById(id);
            dao.deleteProduct(productDelete);
            request.getRequestDispatcher("listproduct").forward(request, response);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        proccessRequest(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        proccessRequest(req,resp);
    }    
}
