package com.web.entity;
// Generated Apr 5, 2022 1:09:35 AM by Hibernate Tools 4.3.1
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name="products"
    ,schema="dbo"
    ,catalog="webbanhang2"
)
public class Product  implements java.io.Serializable {
     private int productId;
     private Category categories;
     private String productName;
     private String image;
     private Integer quantity;
     private Double price;
     private String status;
     private Date manufacturedDate;
     private String description;
     private Set<Cartdetail> cartdetailses = new HashSet<Cartdetail>(0);

    public Product() {
    }

	
    public Product(int productId) {
        this.productId = productId;
    }
    public Product(int productId, Category categories, String productName, String image, Integer quantity, Double price, String status, Date manufacturedDate, String description, Set<Cartdetail> cartdetailses) {
       this.productId = productId;
       this.categories = categories;
       this.productName = productName;
       this.image = image;
       this.quantity = quantity;
       this.price = price;
       this.status = status;
       this.manufacturedDate = manufacturedDate;
       this.description = description;
       this.cartdetailses = cartdetailses;
    }
   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProductId", unique=true, nullable=false)
    public int getProductId() {
        return this.productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CategoryId")
    public Category getCategories() {
        return this.categories;
    }
    
    public void setCategories(Category categories) {
        this.categories = categories;
    }

    
    @Column(name="ProductName")
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    
    @Column(name="Image")
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    
    @Column(name="Quantity")
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
    @Column(name="Price", precision=53, scale=0)
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    
    @Column(name="Status")
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ManufacturedDate", length=10)
    public Date getManufacturedDate() {
        return this.manufacturedDate;
    }
    
    public void setManufacturedDate(Date manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    
    @Column(name="Description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="products")
    public Set<Cartdetail> getCartdetailses() {
        return this.cartdetailses;
    }
    
    public void setCartdetailses(Set<Cartdetail> cartdetailses) {
        this.cartdetailses = cartdetailses;
    }
}


