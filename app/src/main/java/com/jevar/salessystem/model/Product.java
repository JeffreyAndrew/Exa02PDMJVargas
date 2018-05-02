package com.jevar.salessystem.model;

public class Product extends ProductId{

     String name_prod,price,stock ;
     boolean status;


    public Product() {

    }
    public Product(String name_prod, String price, String stock) {
        this.name_prod = name_prod;
        this.price = price;
        this.stock = stock;
    }

    public String getName_prod() {
        return name_prod;
    }

    public void setName_prod(String name_prod) {
        this.name_prod = name_prod;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
