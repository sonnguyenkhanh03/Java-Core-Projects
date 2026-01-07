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
    
    public  String inputString(String message){
        while(true){
            System.out.print(message);
            String key = sc.nextLine();
            if(key.isEmpty()){
                System.out.print("Input cannot empty.Please try again");
                System.out.print("Try again: ");
            }else{
                return key;
            }
        }
    }
    
    public int inputInt(String message, int max, int min){
        while(true){
            try{
            System.out.print(message);
            int value = Integer.parseInt(sc.nextLine());
            if(value >= min && value<= max){
                return value;
              }
            }catch(NumberFormatException Ingore){
                
            }
            System.out.print("Invalid number!");
        }
    }
    
    public boolean checkYesOrNo(String message){
        while(true){
            String input = inputString( message+"Y|N: ");
            if(input.equalsIgnoreCase("Y")){
                return true;
            }else if(input.equalsIgnoreCase("N")){
                return false;
            }else{
                System.out.print("please enter Y or N");
            }
        }
    }
    
}
