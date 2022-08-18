package com.web.dao;

import com.web.entity.Category;
import com.web.helper.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class CategoryDAO 
{
    public boolean addCategory(Category category)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.getTransaction().begin();
            session.persist(category);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally
        {
            session.close();
        }
    }
    
    public boolean updateCategory(Category category)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.getTransaction().begin();
            session.saveOrUpdate(category);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally
        {
            session.close();
        }
    }
    
    public void deleteCategory(Category category)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.getTransaction().begin();
            session.delete(category);
            session.getTransaction().commit();
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        finally
        {
            session.close();
        }
    }
    
    public List<Category> getAllCategory()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            String hql = "FROM Category";
            Query query = session.createQuery(hql);
            return query.list();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        finally
        {
            session.close();
        }
    }
    
    public Category getCategoryById(int id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            Category category = (Category)session.get(Category.class, id);
            return category;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        finally
        {
            session.close();
        }
    }
    
    public List<Category> getCategoryByName(String name)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            String hql = "FROM Category c WHERE c.categoryName LIKE :categoryName";
            Query query = session.createQuery(hql);
            query.setString("categoryName", "%"+name+"%");
            return query.list();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        finally
        {
            session.close();
        }
    }
    
    
    public static void main(String[] args) 
    {
        CategoryDAO dao = new CategoryDAO();
        
        Category cates = new Category();
        cates.setCategoryName("eee");
        dao.addCategory(cates);
        
        List<Category> cate = dao.getAllCategory();
        for(int i=0; i<cate.size(); i++)
        {
            System.out.println("Id: "+cate.get(i).getCategoryId()+" Name: "+cate.get(i).getCategoryName());
        }        
        /*
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.getTransaction().begin();
            Category category = new Category();
            category.setCategoryId(0);
            category.setCategoryName("ccc");
            session.save(category);
            session.getTransaction().commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        */
        /*
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Category";
        Query query = session.createQuery(hql);
        List<Category> cate = query.list();
        for(int i=0; i<cate.size(); i++)
        {
            System.out.println(cate.get(i).getCategoryId()+" "+cate.get(i).getCategoryName());
        }
        */
        /*
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.getTransaction().begin();
            Category cate = new Category();

            cate.setCategoryName("eee");
            session.saveOrUpdate(cate);
            session.getTransaction().commit();
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        */
    }
}
