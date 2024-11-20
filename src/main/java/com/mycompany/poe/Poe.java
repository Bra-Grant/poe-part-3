/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;
import java.util.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class Poe {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static String firstname = "";
    private static String lastname = "";

    public static void main(String[] args) {
        InputValidation checkAll = new InputValidation();
        String firstname = "";
        String lastname = "";
        String username = "";
        String password = "";

         while (true) {
            String menu = "Please select an option:\n"
                        + "1. Register\n"
                        + "2. Login\n"
                        + "3. Tasks\n"
                        + "4. Exit";
            
            String inputOption = JOptionPane.showInputDialog(menu);
            int option = Integer.parseInt(inputOption);

            switch (option) {
                case 1: // Register info.
                   firstname = JOptionPane.showInputDialog("Enter first name:");
                    lastname = JOptionPane.showInputDialog("Enter last name:");
                    username = JOptionPane.showInputDialog("Create a username:");
                    password = JOptionPane.showInputDialog("Create a password:");
                    
                    String registrationMessage = checkAll.registerUser(firstname, lastname, username, password);
                    JOptionPane.showMessageDialog(null, registrationMessage); 
                    break;
                    
                case 2: // Login
                    String loginUsername = JOptionPane.showInputDialog("Username:");
                    String loginPassword = JOptionPane.showInputDialog("Password:");
                    checkAll.login(loginUsername, loginPassword, username, password, firstname, lastname);
                    break;
                
                case 3: // Exit
                    taskMenu();
                    break;
                    
                case 4:
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    return;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }
    
// Placeholder for task menu
    private static void taskMenu() {
        
        while (true) {
             String taskMenu = "Task Menu:\n"
                            + "1. Add Task\n"
                            + "2. Show Report\n"
                            + "3. View Tasks\n"
                            + "4. Exit Task Menu";
             
             String inputOption = JOptionPane.showInputDialog(taskMenu);
            int option = Integer.parseInt(inputOption);
             
switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    return;
                case 3:
                    viewTasks();
                    return;
                case 4:
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
    }

// Method to add tasks
    private static void addTask() {
        String numTasksStr = JOptionPane.showInputDialog("How many tasks would you like to add?");
        int numTasks = Integer.parseInt(numTasksStr);
        
for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description (Max 50 characters):");

 // Validate task description length
            while (taskDescription.length() > 50) {
                taskDescription = JOptionPane.showInputDialog("Please enter a task description of less than 50 characters:");
            }
            
String developerDetails = JOptionPane.showInputDialog("Enter developer name:");
            String taskDurationStr = JOptionPane.showInputDialog("Enter task duration (in hours):");
            int taskDuration = Integer.parseInt(taskDurationStr);
            
// Generate Task ID in the required format
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" 
                      + i + ":" 
                      + developerDetails.substring(developerDetails.length() - 3).toUpperCase();

            // Task status options (To Do, Doing, Done)
            String[] statusOptions = {"To Do", "Doing", "Done"};
            int statusChoice = JOptionPane.showOptionDialog(null, "Select task status:", "Task Status",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, statusOptions, statusOptions[0]);

            String taskStatus = statusOptions[statusChoice];
            
// Create a new task and add it to the list
            Task newTask = new Task(taskName, i + 1, taskDescription, developerDetails, taskDuration, taskStatus);
            tasks.add(newTask);

            JOptionPane.showMessageDialog(null, "Task successfully added!");
        }
    }
    
    // Method to view tasks
    private static void viewTasks() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
        } else {
            StringBuilder taskList = new StringBuilder();
            for (Task task : tasks) {
                taskList.append("Task ID: ").append(task.getTaskID()).append("\n")
                        .append("Task Name: ").append(task.getTaskName()).append("\n")
                        .append("Task Description: ").append(task.getTaskDescription()).append("\n")
                        .append("Developer Name: ").append(task.getDeveloperDetails()).append("\n")
                        .append("Task Duration: ").append(task.getTaskDuration()).append(" hours\n")
                        .append("Task Status: ").append(task.getTaskStatus()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, taskList.toString());
        }
    }
}