/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import java.util.List;
import util.Validation;
import java.util.Hashtable;
import model.*;
public class Manager {
    
    Hashtable<String, ArrayList<Order>> orderTable = new Hashtable<>();
    List<Fruit> fruitList = new ArrayList<>();
    Validation validation = new Validation();
    
    
    public void createFruit() {
        do {
            String id = validation.inputString("Enter fruit id: ");
            String name = validation.inputString("Enter fruit name: ");
            double price = validation.inputDouble("Enter price: ");
            int quantity = validation.inputInt("Enter quantity: ");
            String origin = validation.inputString("Enter origin: ");
            fruitList.add(new Fruit(id, name, price, quantity, origin));
        } while (validation.checkYesOrNo("Do you want to continue creating fruit Y or N: "));
    }

    public void viewOrder() {
        if (orderTable.isEmpty()) {
            System.out.println("No orders yet!");
            return;
        }
        
        for (String customer : orderTable.keySet()) {
            ArrayList<Order> orders = orderTable.get(customer);
            for (Order order : orders) {
                
                System.out.println("Customer: " + order.getCustomerName());
                System.out.printf("%-10s%-15s%-10s%-10s\n","Product","Quantity","Price","Amount");
                
                double total = 0;
                for (Fruit fruit : order.getItem()) {
                    double amount = fruit.getPrice() * fruit.getQuantity();
                    System.out.printf("%-10s%-15d%-10.0f$%-10.0f\n",fruit.getName(), fruit.getQuantity(), fruit.getPrice(), amount);
                    total += amount;
                }
               System.out.printf("Total: %.2f$\n", total);
            }
        }
    }

    public void shopping() {
        
        if (fruitList.isEmpty()) {
            System.out.println("No fruit available!");
            return;
        }
        
        ArrayList<Fruit> buyList = new ArrayList<>();
        while (true) {
            
            System.out.printf("|%-7s| %-15s| %-9s | %-9s |\n","++Item++","++Fruit Name++","++Origin++","++Price++");
            for (int i = 0; i < fruitList.size(); i++) {
                Fruit f = fruitList.get(i);
                System.out.printf("| %-7d| %-15s| %-10s | $%-8.2f |\n", i + 1, f.getName(), f.getOrigin(), f.getPrice());
            }

            int item = validation.inputInt("Select item: ");
            if (item <= 0 || item > fruitList.size()) {
                System.out.println("Invalid selection!");
                continue;
            }

            Fruit selected = fruitList.get(item - 1);
            int quantity = validation.inputInt("Please input quantity: ");
            if (quantity > selected.getQuantity()) {
                System.out.println("Not enough quantity!| Remanining: "+selected.getQuantity());
                continue;
            }

            buyList.add(new Fruit(selected.getId(), selected.getName(), selected.getPrice(), quantity, selected.getOrigin()));
            selected.setQuantity(selected.getQuantity() - quantity);

            if (validation.checkYesOrNo("Do you want to order now Y or N : ")) {
                break;
            }
        }

        double total = 0;
        System.out.printf("%-10s%-15s%-10s%-10s\n","Product","Quantity","Price","Amount");
        for (Fruit f : buyList) {
            double amount = f.getPrice() * f.getQuantity();
            System.out.printf("%-10s%-15d%-10.0f$%-10.0f\n", f.getName(), f.getQuantity(), f.getPrice(), amount);
            total += amount;
        }
        System.out.printf("Total: %.2f$\n", total);
        
        
        String nameHuman = validation.inputString("Input your name: ");
        Order order = new Order(nameHuman, buyList);

        if (orderTable.containsKey(nameHuman)) {
            orderTable.get(nameHuman).add(order);
        } else {
            ArrayList<Order> orders = new ArrayList<>();
            orders.add(order);
            orderTable.put(nameHuman, orders);
        }
        System.out.println("Order complete!");

    }
    
    public void initFruits() {
        fruitList.add(new Fruit("F1", "Banana", 10.0, 20, "Vietnam"));
        fruitList.add(new Fruit("F2", "Apple", 15.0, 15, "USA"));
        fruitList.add(new Fruit("F3", "Orange", 10.0, 8, "Australia"));
        fruitList.add(new Fruit("F4", "Mango", 25.0, 12, "Thailand"));
        fruitList.add(new Fruit("F5", "Grapes", 30.0, 20, "France"));
    }
}
