/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Admin
 */
import java.util.List;
import java.util.ArrayList;
import object.*;

public class ManagerTask {
    private static final List<Employee> employeeList = new ArrayList<>();
    Validation validation = new Validation();
    private void getTaskType(TaskType taskType) {
        String[] task = {"Code", "Test", "Design", "Review"};
        printTask(task);
        int choice = validation.inputInt("Enter task type: ", 1, 4);
        taskType.setTaskId(choice);
        taskType.setDescription(task[choice - 1]);
    }

    private void printTask(String[] task) {
        System.out.println("AVAILABLE TASK");
        for (int i = 0; i < task.length; i++) {
            System.out.println((i + 1) + " = " + task[i]);
        }
    }

    public void addTask() {
        // Tạo ID
        int ID = 1;
//        if (!employeeList.isEmpty()) {
//            for (Employee e : employeeList) {
//                if (!e.getTasks().isEmpty()) {
//                    ID = e.getTasks().get(e.getTasks().size() - 1).getId() + 1;
//                }
//            }
//        }
        if (!employeeList.isEmpty()) {
            int maxId = 0;
            for (Employee e : employeeList) {
                for (Task t : e.getTasks()) {
                    if (t.getId() > maxId) {
                        maxId = t.getId();
                    }
                }
            }
            ID = maxId + 1; // lấy ID lớn nhất + 1
        }

        // Nhập thông tin Task
        String requirementName = validation.inputString("Enter requirement name: ", "[A-Za-z\\s]+");
        TaskType taskType = new TaskType();
        getTaskType(taskType);

        String date = validation.inputDate("Enter Date: ");
        double planFrom = validation.inputDouble("Enter planFrom: ", 8, 17.5);
        double planTo = validation.inputDouble("Enter planTo: ", planFrom + 0.5, 17.5);

        String assignee = validation.inputString("Enter assignee: ", "[A-Za-z\\s]+");
        String reviewer = validation.inputString("Enter reviewer: ", "[A-Za-z\\s]+");

        Task newTask = new Task(ID, taskType, requirementName, date, planFrom, planTo, assignee, reviewer);

        // Kiểm tra nhân viên
        Employee emp = findEmployeeByName(assignee);
        if (emp == null) {
            emp = new Employee(assignee);
            employeeList.add(emp);
        }

        try {
            emp.addTask(newTask);
            System.out.println("Add task successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // tìm employee theo tên
    private Employee findEmployeeByName(String name) {
        for (Employee e : employeeList) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }
    
    public void deleteTask() {
        int ID = validation.inputInt("Enter ID you want to delete: ", 1, Integer.MAX_VALUE);

        for (Employee emp : employeeList) {
            for (Task task : emp.getTasks()) {
                if (task.getId() == ID) {
                    System.out.print("Task found. Are you sure delete task (Y/N): ");
                    boolean choice = validation.checkInputYN();
                    if (choice) {
                        emp.getTasks().remove(task);
                        System.out.println("Delete task successfully!!!");
                        return;
                    } else {
                        System.out.println("Cancel Delete!!!");
                        return;
                    }
                }
            }
        }
        System.out.println("ID not found in the database!!!");
    }

    public void displayTask() {
        boolean hasTask = false;

        for (Employee emp : employeeList) {
            if (!emp.getTasks().isEmpty()) {
                hasTask = true;
                break;
            }
        }

        if (!hasTask) {
            System.out.println("No task for display!!!");
            return;
        }

        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");

        for (Employee emp : employeeList) {
            for (Task task : emp.getTasks()) {
                double time = task.getPlanTo() - task.getPlanFrom();
                System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                        task.getId(),
                        task.getRequirementName(),
                        task.getTaskType().getDescription(),
                        task.getDate(),
                        time,
                        task.getAssignee(),
                        task.getReviewer());
            }
        }
    }
    
}