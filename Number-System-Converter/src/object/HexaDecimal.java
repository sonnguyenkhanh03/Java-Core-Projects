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
public class HexaDecimal {
    private String hexa;
    
    public HexaDecimal(){
        
    }
    public HexaDecimal(String hexa){
        this.hexa = hexa;
    }
    public String getHexa(){
        return hexa;
    }
    public void setHexa(String hexa){
        this.hexa= hexa;
    }
    
    private String convertHexaToDecimal(){
        int decimal = Integer.parseInt(hexa, 16); // parse theo cơ số 16
        return String.valueOf(decimal);
    }
    private String convertHexaToBinary(){
        Decimal deci = new Decimal();
        String decimal = convertHexaToDecimal();
        String binary =  deci.convertDecimalToBinary(decimal);
        return binary;
    }
    public void inputHexa(){
        hexa= Validation.CheckInputHexa();
    }
    
    public void convertFromHexaDecimal(){
         int choice = Validation.getChoice("HexaDecimal","Binary","Decimal");
          switch(choice){
              case 1:
                  System.out.println("Binary: "+ convertHexaToBinary());
                  break;
              case 2:
                  System.out.println("Decimal: "+ convertHexaToDecimal());
                  break;
          } 
    }
      
    
    
}
