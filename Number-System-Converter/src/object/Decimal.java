/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

/**
 *
 * @author Admin
 */
import operation.Validation;
public class Decimal {
      private String decimal;
      
      
      public Decimal(){
          
      }
      public Decimal(String decimal){
          this.decimal=decimal;
      }
      public String getDecimal(){
          return decimal;
      }
      public void setDecimal(String decimal){
          this.decimal = decimal;
      }
      
      public String convertDecimalToBinary(String decimal){
        int deci = Integer.parseInt(decimal); // chuyển chuỗi sang int
        return Integer.toBinaryString(deci); 
      }
      
      public String convertDecimalToHexa(String decimal){
        int deci = Integer.parseInt(decimal); // chuyển chuỗi sang int
        return Integer.toHexString(deci).toUpperCase();
      }
      
      public void inputDecimal(){
          decimal = Validation.CheckInputDecimal();
      }
      
      public void convertFromDecimal(String decimal){
          
          int choice = Validation.getChoice("Decimal", "Binary","HexaDecimal");
          switch(choice){
              case 1:
                  System.out.println("Binary: "+ convertDecimalToBinary(decimal));
                  break;
              case 2:
                  System.out.println("HexaDecimal: "+ convertDecimalToHexa(decimal));
                  break;
          }
      }
}
 