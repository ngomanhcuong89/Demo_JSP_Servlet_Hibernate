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
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name="addproduct", urlPatterns="/addproduct")
public class AddProductController extends HttpServlet
{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        try
        {
            
            List<Category> categories = new CategoryDAO().getAllCategory();
            req.setAttribute("Category", categories);
            req.getRequestDispatcher("/backend/products/addOrEdit.jsp").forward(req, resp);
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
            
            // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            HashMap<String, String> fields = new HashMap<>();
            String imageName = null;
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
                    Path path = Paths.get(filename);
                    String storedPath = servletContext.getRealPath("/uploads");
                    File uploadedFile = new File(storedPath + "/" + path.getFileName());
                    item.write(uploadedFile);
                    imageName = path.getFileName().toString();
                    System.out.println(storedPath + "/" + path.getFileName());
                }
            }
            
            Product pronew = new Product();
            Category cate = new CategoryDAO().getCategoryById(Integer.parseInt(fields.get("Category")));
            pronew.setCategories(cate);
            pronew.setProductName(fields.get("name"));
            pronew.setImage(imageName);
            pronew.setQuantity(Integer.parseInt(fields.get("quantity")));
            pronew.setPrice(Double.parseDouble(fields.get("price")));
            pronew.setStatus(fields.get("status"));
            pronew.setManufacturedDate(new Date());
            pronew.setDescription(fields.get("description"));
            
            ProductDAO dao = new ProductDAO();
            dao.addProduct(pronew);
            
            req.getRequestDispatcher("listproduct").forward(req, resp);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
