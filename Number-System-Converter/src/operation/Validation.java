/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation;

/**
 *
 * @author Admin
 */
import java.util.Scanner;

public class Validation {
       private static final Scanner sc = new Scanner(System.in);
    
    public static int getInt(String msg, int min, int max){
           while(true){
               try{
                   System.out.print(msg);
                   int result = Integer.parseInt(sc.nextLine());
                   if (result >= min && result <= max){
                       return result;
                   } else{
                       throw new NumberFormatException();
                   }
               } catch(NumberFormatException e){
                   System.out.println("Please input number in range:" +min+ "->" +max);
                   System.out.println("Enter again:");
               }
           }
       }
       
    public static String CheckInputBinary(){
        System.out.print("Enter number binary: ");
        while(true){
            String result = sc.nextLine().trim();
            if (result.matches("[0-1]*")){
                return result;
            }
            System.out.println("Number be enter 0 or 1");
            System.out.println("Re-enter: ");
        }
    }
    
    public static String CheckInputDecimal(){
        System.out.print("Enter number decimal: ");
        while(true){
            String result = sc.nextLine().trim();
            if (result.matches("[0-9]*")){
                return result;
            }
            System.out.println("Number be enter 0-9");
            System.out.println("Re-enter: ");
        }
    }
    
    public static String CheckInputHexa(){
        System.out.print("Enter number Hexadecimal: ");
        
        while(true){
            String result = sc.nextLine().trim();
            if (result.matches("[0-9A-F]*")){
                return result;
            }
            System.out.println("Number be enter 0-9 A-F");
            System.out.println("Re-enter: ");
        }
    }
    
    public static int getChoice( String from, String case1, String case2 ){
        System.out.println("1. Convert from "+from+" to "+case1);
        System.out.println("2. Convert from "+from+" to "+case2);
        int choice = getInt("Enter your choice:" ,1,2);
        return choice;
    }
}
