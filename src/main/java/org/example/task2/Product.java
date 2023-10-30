package org.example.task2;

public class Product {
    private String title;
    private float price;


    public Product(String productName, float price) {
        this.title = productName;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String productName) {
        this.title = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
