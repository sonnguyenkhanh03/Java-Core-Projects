/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author Admin
 */
public class Intern extends Candidate {
    
    private String majors;
    private String semester;
    private String university;
    
    
    public Intern(){
       
    }
    public Intern( String majors, String semester, String university, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int type){
        super(id,firstName,lastName,birthDate,address,phone,email,type);
        
        this.majors = majors;
        this.semester = semester;
        this.university = university;
    }
    
    public String getMajors(){
        return majors;
    }
    public void setMajors(String majors){
        this.majors = majors;
    }
    public String getsemester(){
        return semester;
    }
    public void setSemster(String semester){
        this.semester = semester;
    }
    public String getUnversity(){
        return university;
    }
    public void setUnviversity(String university){
        this.university = university;
    }
    public String toString(){
        return super.toString()+" Majors: "+majors+" Semester: "+ semester+" University: " + university;
    }
}

