/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author Admin
 */
public class Experience extends Candidate{
    
    private int explnYear;
    private String proSkill;
    public Experience(){
      
    }
    public Experience(int explnYear, String proSkill,String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int type){
        super(id,firstName,lastName,birthDate,address,phone,email,type);
        
        this.explnYear = explnYear;
        this.proSkill = proSkill;
    }
    
    public int getExplnYear(){
        return explnYear;
    }
    public void setExplnYear(int explnYear){
        this.explnYear = explnYear;
    }
    public String getProSkill(){
        return proSkill;
    }
    public void setProSkill(String proSkill){
        this.proSkill = proSkill;
    }
    public String toString(){
        return super.toString()+" Experience year: "+explnYear+" Profestional Skill: "+proSkill;
    }
}
