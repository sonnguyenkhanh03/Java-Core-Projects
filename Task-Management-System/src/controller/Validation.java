/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

/**
 *
 * @author Admin
 */
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Validation {
    
    private static final Scanner sc = new Scanner (System.in);
    
    public int inputInt(String msg, int min, int max){
       
        while(true){
            
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result >= min && result <= max){
                    return result;
                }else{
                    System.out.print("Please input number range[" +min+"->"+max+"] :");
                }
            } catch(NumberFormatException e){
                System.out.print("Number must be integer.Enter again: ");
            }
        }
    }
    
    public double inputDouble(String msg, double min, double max){
         while (true) {
            try {
                System.out.print(msg);
                double result = Double.parseDouble(sc.nextLine().trim());

                // kiểm tra số có chia hết cho 0.5 không
                if (result % 0.5 != 0) {
                    System.out.println("Please input a number that is .0 or .5 (ex: 8.0, 8.5, 9.0).");
                    continue;
                }

                // kiểm tra khoảng
                if (result >= min && result <= max) {
                    return result;
                } else {
                    System.out.println("Please input number in range [" + min + " -> " + max + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Number must be double. Enter again:");
            }
        }
    }
    
    public String inputString(String msg, String regex){
         while (true) {
            System.out.print(msg);
            String result = sc.nextLine().trim();

            // kiểm tra rỗng
            if (result.isEmpty()) {
                System.out.println("Please input a non-empty string.");
                continue;
            }

            // kiểm tra regex
            if (!result.matches(regex)) {
                System.out.println("Please input a string that matches regex: " + regex);
                continue;
            }

            return result;
            }
    }
    public String inputDate(String msg) {
        
        while (true) {
            try {
                System.out.print(msg);
                String result = sc.nextLine().trim();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date date = dateFormat.parse(result);

                // nếu chuỗi nhập khớp đúng với format
                if (result.equalsIgnoreCase(dateFormat.format(date))) {
                    return result;
                } else {
                    System.out.print("Date not valid. Please enter again: ");
                }
            } catch (ParseException e) {
                System.out.print("Please input follow format dd-MM-yyyy. Enter again: ");
            }
        }
    }

    // Nhập lựa chọn Y/N
    public boolean checkInputYN() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please enter Y/y or N/n");
            System.out.print("Enter again: ");
        }
    }
}
