package com.web.controller;

import com.web.dao.CategoryDAO;
import com.web.entity.Category;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="DeleteCategory", urlPatterns="/deletecategory")
public class DeleteCategoryController extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            CategoryDAO dao = new CategoryDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            Category categoryDelete = dao.getCategoryById(id);
            dao.deleteCategory(categoryDelete);
            request.getRequestDispatcher("listcategory").forward(request, response);
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
