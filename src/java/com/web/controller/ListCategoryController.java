package com.web.controller;

import com.web.dao.CategoryDAO;
import com.web.entity.Category;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListCategory", urlPatterns="/listcategory")
public class ListCategoryController extends HttpServlet
{
    
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try 
        {
            CategoryDAO dao = new CategoryDAO();
            List<Category> category = dao.getAllCategory();
            request.setAttribute("ListCategory", category);
            request.getRequestDispatcher("backend/categories/list.jsp").forward(request, response);
        } 
        catch (ServletException ex) 
        {
            Logger.getLogger(ListCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ListCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        proccessRequest(req, resp);
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        proccessRequest(req, resp);
    }
}
