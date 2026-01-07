/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Admin
 */
import java.util.Scanner;


public class Validation {
    
    private static final Scanner sc = new Scanner (System.in);
    
    public int inputInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(inputString(message));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    public double inputDouble(String message) {
        while (true) {
            try {
                return Double.parseDouble(inputString(message));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid decimal number!");
            }
        }
    }
    
    public  String inputString(String message) {      
        while (true) {
            System.out.print(message);
            String key = sc.nextLine();
            if (key.isEmpty()) {
                System.out.println("Input cannot be empty. PLease try again.");
                System.out.print("Retry: ");
            } else {
                return key;
            }
        }
    }

    public  boolean checkYesOrNo(String message) {
        while (true) {
            String input = inputString(message);
            if (input.equalsIgnoreCase("Y")) {
                return true;
            }
            if (input.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please enter Y or N!");
        }
    }
    
}