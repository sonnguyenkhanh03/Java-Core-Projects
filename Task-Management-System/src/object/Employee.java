/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private List<Task> tasks = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    public String getName() { 
        return name; 
    }

    public List<Task> getTasks() { 
        return tasks; 
    }

    // thêm task mới, kiểm tra trùng giờ
    public void addTask(Task newTask) throws Exception {
        for (Task t : tasks) {
            // kiểm tra cùng ngày
            if (t.getDate().equals(newTask.getDate())) {
                // kiểm tra chồng thời gian
                if (newTask.getPlanFrom() < t.getPlanTo() && newTask.getPlanTo() > t.getPlanFrom()) {
                    throw new Exception("Task time overlaps with existing task for employee: " + name);
                }
            }
        }
        tasks.add(newTask);
    }
}
