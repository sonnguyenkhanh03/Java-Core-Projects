/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation;

import Object.Candidate;
import Object.Experience;
import Object.Fresher;
import Object.Intern;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author Admin
 */
public class Manager {
    private final List<Candidate> candidates = new ArrayList<>();
    Validation validation = new Validation();
    public void createCandidate(int type){
        do{
            String firstName = validation.inputString("Enter Frist Name: ");
            String lastName = validation.inputString("Enter Last Name: ");
            String id= validation.inputString("Enter id: ");
            int birthDate = validation.inputInt("Enter birth date (1900-" + Calendar.getInstance().get(Calendar.YEAR)+"): ",Calendar.getInstance().get(Calendar.YEAR),1900);
            
            String phone;
            while(true){
                phone = validation.inputString("Enter phone number: ");
                if(phone.length()>= 10&& phone.chars().allMatch(Character:: isDigit)){
                    break;
                }
                System.out.print("Invalid phone number");
            }
            
            String email;
            while(true){
                email = validation.inputString("Enter your email: ");
                if(email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")){
                     break;
                }
               System.out.print("Invliad email");
            }
            
            String address = validation.inputString("Enter adress: ");
            
            switch(type){
                case 0:
                    int explnYear = validation.inputInt("Enter year of experience: ",100,0);
                    String proSkill = validation.inputString("Enter professional skill: ");
                    candidates.add(new Experience(explnYear, proSkill, id, firstName, lastName,birthDate, address, phone, email, type));
                    break;
                case 1:
                    String graduationDate = validation.inputString("Enter graduation date: ");
                    String graduationRank = validation.inputString("Enter graduation rank: ");
                    String education = validation.inputString("Enter eduaction: ");
                    candidates.add(new Fresher(graduationDate, graduationRank, education, id, firstName, lastName,birthDate, address, phone, email, type));
                    break;
                case 2:
                    String majors = validation.inputString("Enter majors: ");
                    String semester = validation.inputString("Enter semester: ");
                    String university = validation.inputString("Enter university: ");
                    candidates.add(new Intern(majors, semester, university,id, firstName, lastName,birthDate, address, phone, email, type));
                    break;
                    
            }
            System.out.println("Candidate create sucessfully");
            
        }while(validation.checkYesOrNo("Do you want continue"));
    }
    public void searchCandidate(){
        System.out.println("List of Candidate");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for(Candidate c : candidates){
            if(c.getType()==0){
            System.out.println(c.getFirstName()+" "+c.getLastName());
            }
        }
        
        System.out.println("===========FRESHER CANDIDATE============");
        for(Candidate c : candidates){
            if(c.getType()==1){
            System.out.println(c.getFirstName()+" "+c.getLastName());
            }
        }
        
        System.out.println("===========INTERN CANDIDATE============");
        for(Candidate c : candidates){
            if(c.getType()==2){
            System.out.println(c.getFirstName()+" "+c.getLastName());
            }
        }
        
        String name = validation.inputString("Enter Name Of Candidate(First name or Last name): ").toLowerCase();
        int type= validation.inputInt("Enter type Candiadte: ", 2,0);
        
        boolean found = false;
        for(Candidate c : candidates){
            if((c.getType() == type) && (c.getFirstName().toLowerCase().contains(name) || c.getLastName().toLowerCase().contains(name))){
                if(!found){
                    System.out.println("The candidates found:");
                    found= true;
                }
                System.out.print(c.toString());
            }
        }
        if(!found){
            System.out.println("Name not found");
        }
    }
    
    public void exampleCandidate(){
        candidates.add(new Experience(5, "Java", "E001", "Nam", "Nguyen",1990, "123 Hanoi", "0912345678", "nam.nguyen@example.com", 0));
        candidates.add(new Experience(3, "Python", "E002", "Anh", "Tran",2000, "456 HCM", "0923456789", "anh.tran@example.com", 0));

        candidates.add(new Fresher("2023", "Excellent", "HUST", "F001", "Lan", "Le",2001, "789 Da Nang", "0934567890", "lan.le@example.com", 1));
        candidates.add(new Fresher("2022", "Good", "FTU", "F002", "Minh", "Pham",2001, "321 Hue", "0945678901", "minh.pham@example.com", 1));

        candidates.add(new Intern("Information Technology", "Spring 2025", "VNU", "I001", "Tuan", "Do",2005,"654 Can Tho", "0956789012", "tuan.do@example.com", 2));
        candidates.add(new Intern("Business", "Fall 2024", "UEH", "I002", "Huong", "Nguyen",2006, "987 Nha Trang", "0967890123", "huong.nguyen@example.com", 2));
    }
}
