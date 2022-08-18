package com.web.controller;

import com.web.dao.CategoryDAO;
import com.web.entity.Category;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AddCategory", urlPatterns="/addcategory")
public class AddCategoryController extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        try 
        {
            req.removeAttribute("AddOrEdit");
            req.getRequestDispatcher("backend/categories/addOrEdit.jsp").forward(req, resp);
        } 
        catch (ServletException ex) 
        {
            Logger.getLogger(AddCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(AddCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        try
        {
            CategoryDAO dao = new CategoryDAO();
            String name = req.getParameter("name");
            Category categoryNew = new Category();
            categoryNew.setCategoryName(name);
            dao.addCategory(categoryNew);
            req.getRequestDispatcher("listcategory").forward(req, resp);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
