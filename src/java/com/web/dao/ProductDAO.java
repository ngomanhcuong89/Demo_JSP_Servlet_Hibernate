package com.web.dao;

import com.web.entity.Category;
import com.web.entity.Product;
import com.web.helper.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProductDAO 
{
    public boolean addProduct(Product product)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.getTransaction().begin();
            session.persist(product);
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
    public boolean updateProduct(Product product)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.getTransaction().begin();
            session.saveOrUpdate(product);
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
    public boolean deleteProduct(Product product)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.getTransaction().begin();
            session.delete(product);
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
    public List<Product> getAllProduct()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            String hql = "FROM Product";
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
    public Product getProductById(int id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            return (Product)session.get(Product.class, id);
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
    public List<Product> getProductByName(String name)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            String hql = "FROM Product AS P WHERE P.productName LIKE :productName";
            Query query = session.createQuery(hql);
            query.setString("productName", name);
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
    
    public static void main(String[] args) {
      
    }
}
