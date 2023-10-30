package org.example.task2;

public class Order {
    private Customer customer;
    private Product product;
    private int amount;


    public Order(Customer customer, Product product, int amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }


    public Product getProduct() {
        return product;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer.getName() +
                ", product=" + product.getTitle() +
                ", amount=" + amount +
                '}';
    }

}
