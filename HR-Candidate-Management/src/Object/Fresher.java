/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author Admin
 */
public class Fresher extends Candidate{
    
    private String graduationDate;
    private String graduationRank;
    private String education;
    
    public Fresher(){
      
    }
    public Fresher(String graduationDate,String graduationRank, String education, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int type){
        super(id,firstName,lastName,birthDate,address,phone,email,type);
        
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
    
    public String getGraduationDate(){
        return graduationDate;
    }
    public void setGraduationDate(String graduationDate){
        this.graduationDate = graduationDate;
    }
    public String getGraduationRank(){
        return graduationRank;
    }
    public void setGraduationRank(String graduationRank){
        this.graduationRank = graduationRank;
    }
    public String getEducation(){
        return education;
    }
    public void setEducation(String education){
        this.education = education;
    }
    public String toString(){
        return super.toString()+" Graduation date: "+ graduationDate+" Graduation rank: "+ graduationRank+" Education: "+education;
    }
}
