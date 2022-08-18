package com.web.entity;
// Generated Apr 5, 2022 1:09:35 AM by Hibernate Tools 4.3.1


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Cartdetails generated by hbm2java
 */
@Entity
@Table(name="cartdetails"
    ,schema="dbo"
    ,catalog="webbanhang2"
)
public class Cartdetail  implements java.io.Serializable {


     private int cartDetailId;
     private Cart carts;
     private Product products;
     private int quantity;
     private double price;
     private String note;

    public Cartdetail() {
    }

	
    public Cartdetail(int cartDetailId, Cart carts, Product products, int quantity, double price) {
        this.cartDetailId = cartDetailId;
        this.carts = carts;
        this.products = products;
        this.quantity = quantity;
        this.price = price;
    }
    public Cartdetail(int cartDetailId, Cart carts, Product products, int quantity, double price, String note) {
       this.cartDetailId = cartDetailId;
       this.carts = carts;
       this.products = products;
       this.quantity = quantity;
       this.price = price;
       this.note = note;
    }
   
     @Id 

    
    @Column(name="CartDetailId", unique=true, nullable=false)
    public int getCartDetailId() {
        return this.cartDetailId;
    }
    
    public void setCartDetailId(int cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CartId", nullable=false)
    public Cart getCarts() {
        return this.carts;
    }
    
    public void setCarts(Cart carts) {
        this.carts = carts;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ProductId", nullable=false)
    public Product getProducts() {
        return this.products;
    }
    
    public void setProducts(Product products) {
        this.products = products;
    }

    
    @Column(name="Quantity", nullable=false)
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    @Column(name="Price", nullable=false, precision=53, scale=0)
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    
    @Column(name="Note")
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }




}


