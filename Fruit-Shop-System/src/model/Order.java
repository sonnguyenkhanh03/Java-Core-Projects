/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
public class Order {
    private String customerName;
    private ArrayList<Fruit> item;

    public Order() {
    }

    public Order(String customerName, ArrayList<Fruit> item) {
        this.customerName = customerName;
        this.item = item;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Fruit> getItem() {
        return item;
    }

    public void setItem(ArrayList<Fruit> item) {
        this.item = item;
    }
    
    
    
}
