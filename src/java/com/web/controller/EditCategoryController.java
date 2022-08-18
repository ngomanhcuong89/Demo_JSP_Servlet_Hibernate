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

@WebServlet(name="EditCategory", urlPatterns="/editcategory")
public class EditCategoryController extends HttpServlet
{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        try {
            CategoryDAO dao = new CategoryDAO();
            int id = Integer.parseInt(req.getParameter("id"));
            Category category = dao.getCategoryById(id);
            req.setAttribute("AddOrEdit", category);
            req.getRequestDispatcher("backend/categories/addOrEdit.jsp").forward(req, resp);
        } catch (ServletException ex) {
            Logger.getLogger(EditCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EditCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        try
        {
            CategoryDAO dao = new CategoryDAO();
            int id = Integer.parseInt(req.getParameter("categoryId"));
            String name = req.getParameter("name");
            Category categoryUpdate = new Category(id,name);
            dao.updateCategory(categoryUpdate);
            req.getRequestDispatcher("listcategory").forward(req, resp);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
