package com.web.controller;

import com.web.dao.CategoryDAO;
import com.web.dao.ProductDAO;
import com.web.entity.Category;
import com.web.entity.Product;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name="EditProduct", urlPatterns="/editproduct")
public class EditProductController extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        try
        {
            Product productedit = new ProductDAO().getProductById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("AddOrEdit", productedit);

            List<Category> categories = new CategoryDAO().getAllCategory();
            req.setAttribute("Category", categories);

            req.getRequestDispatcher("backend/products/addOrEdit.jsp").forward(req, resp);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        try 
        {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);            
            // Parse the request
            List<FileItem> items = upload.parseRequest(req);
            HashMap<String, String> fields = new HashMap();
            String imageName = null;
            // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) 
            {
                FileItem item = iter.next();

                if (item.isFormField()) 
                {
                    fields.put(item.getFieldName(), item.getString());
                } 
                else 
                {
                    String filename = item.getName();
                    if(filename != null && !filename.equals(""))
                    {
                        Path path = Paths.get(filename);
                        String storedPath = servletContext.getRealPath("/uploads");
                        File uploadedFile = new File(storedPath + "/" + path.getFileName());
                        item.write(uploadedFile);
                        imageName = path.getFileName().toString();
                        System.out.println(storedPath + "/" + path.getFileName());        
                    }    
                }
            }

            Product proupdate = new Product();
            proupdate.setProductId(Integer.parseInt(fields.get("productId")));
            Category cate = new CategoryDAO().getCategoryById(Integer.parseInt(fields.get("Category")));
            proupdate.setCategories(cate);
            proupdate.setProductName(fields.get("name"));

            proupdate.setQuantity(Integer.parseInt(fields.get("quantity")));
            proupdate.setPrice(Double.parseDouble(fields.get("price")));
            proupdate.setStatus(fields.get("status"));
            proupdate.setManufacturedDate(new Date());
            proupdate.setDescription(fields.get("description"));
            
            ProductDAO dao = new ProductDAO();
            if(imageName != null)
            {
                proupdate.setImage(imageName);
            }
            else
            {
                String oldImage = dao.getProductById(Integer.parseInt(fields.get("productId"))).getImage();
                proupdate.setImage(oldImage);
            }            
            dao.updateProduct(proupdate);
            
            req.getRequestDispatcher("listproduct").forward(req, resp);
            
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
}
