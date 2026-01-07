/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import operation.Manager;
import operation.Validation;
/**
 *
 * @author Admin
 */
public class Menu {
    public void display(){
        Manager manager = new Manager();
        manager.exampleCandidate();
        Validation validation = new Validation();
        while (true) {
            System.out.println("\n=== CANDIDATE MANAGEMENT SYSTEM ===");
            System.out.println("1. Create Experience Candidate");
            System.out.println("2. Create Fresher Candidate");
            System.out.println("3. Create Internship Candidate");
            System.out.println("4. Search Candidate");
            System.out.println("5. Exit");
            int choice = validation.inputInt("Please choose (1-5): ",5,1);

            switch (choice) {
                case 1:
                    manager.createCandidate(0);
                    break;
                case 2:
                    manager.createCandidate(1);
                    break;
                case 3:
                    manager.createCandidate(2);
                    break;
                case 4:
                    manager.searchCandidate();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1–5.");
            }
        }
    }
    
}
