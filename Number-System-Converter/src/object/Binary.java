/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package object;

/**
 *
 * @author Admin
 */
import operation.Validation;

public class Binary {
    
    private String binary;
    public Binary(){
        
    }
    public Binary(String binary){
        this.binary = binary;
    }
      
    public String getBinary(){
        return binary;
    }
    public void setBinary(String binary){
        this.binary= binary;
    }
 
    private String convertBinaryToDecimal(){
      
        int decimal = Integer.parseInt(binary,2);
        return String.valueOf(decimal);
    }
    
    
    private String convertBinaryToHexa(){
        Decimal deci = new Decimal();
        String decimal = convertBinaryToDecimal();
        String hexa = deci.convertDecimalToHexa(decimal);
        return hexa; 
    }
    
    public void inputBinary(){
        binary =  Validation.CheckInputBinary();
    }
    public void convertFormBinary(){
        int choice = Validation.getChoice("Binary","Decimal", "HexaDecimal");
          switch(choice){
              case 1:
                  System.out.println("Decimal: "+ convertBinaryToDecimal());
                  break;
              case 2:
                  System.out.println("HexaDecimal: "+ convertBinaryToHexa());
                  break;
          }  
    }
}
