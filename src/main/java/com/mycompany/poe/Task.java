/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author RC_Student_lab
 */
public class Task {
    //declare variables
    private String taskName;
    private int taskNumber;
    private String taskDescription;
     private String developerDetails;
     private int taskDuration;
    private String taskID;
    private String taskStatus;
    
    // Static lists to keep track of task details.
    static List<String> developerNames = new ArrayList<>(); 
    static List<String> taskNames = new ArrayList<>(); 
    static List<String> taskIDs = new ArrayList<>(); 
    static List<Integer> taskDurations = new ArrayList<>(); 
    static List<String> taskStatuses = new ArrayList<>();
    
    //constructor to initialize task details.
    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        
        // Validate the task description
        if (!checkTaskDescription(taskDescription)) {
            JOptionPane.showMessageDialog(null, "Invalid task description. Task creation failed.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // If invalid, do not proceed with task creation
        }
        
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
        
    // Adding to static lists 
    developerNames.add(developerDetails); 
    taskNames.add(taskName); 
    taskIDs.add(taskID); 
    taskDurations.add(taskDuration); 
    taskStatuses.add(taskStatus);
    }
   //getter methods to access attributes
   public String getTaskName(){
       return taskName;
   }
   
   public int getTaskNumber(){
       return taskNumber;
   }
   
   public String getTaskDescription(){
       return taskDescription;
   }
   
   public String getDeveloperDetails(){
       return developerDetails;
   }
   
   public int getTaskDuration(){
       return taskDuration;
   }
   
   public String getTaskID(){
       return taskID;
   }
  
    public String getTaskStatus() {
        return taskStatus;
    }
   
   //method to return a string with full task detaiils
   public String getTaskDetails(){
       return "Task Number: " + taskNumber + 
               "\nTask Name:" + taskName +
               "\nTask Description: " +
               taskDescription + "\nDeveloper: " + developerDetails +
               "\nDuration: " + taskDuration + "hours" + "\nTask ID: " +
               "\nStatus: " + taskStatus;
   }
   
   // Method to validate task description length
    public boolean checkTaskDescription(String taskDescription) {
        boolean isValid = taskDescription != null && !taskDescription.isEmpty() && taskDescription.length() <= 50;
        if (isValid) {
            JOptionPane.showMessageDialog(null, "Task successfully captured", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return isValid;
    }

    // Method to create and return the TaskID
    public String createTaskID() {
        String taskPrefix = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String developerSuffix = developerDetails.length() >= 3 ? developerDetails.substring(developerDetails.length() - 3).toUpperCase() : developerDetails.toUpperCase();
        return taskPrefix + ":" + taskNumber + ":" + developerSuffix;
    }

    /// Method to return the total combined hours of all entered tasks
    public static int returnTotalHours(List<Integer> taskDurations) {
        int totalHours = 0;
        for (int duration : taskDurations) {
            totalHours += duration;
        }
        return totalHours;
    }

    // Method to clear all task durations
    public static void clearTaskDurations() {
        allTaskDurations.clear();
    }

   // Method to display the total combined hours of all tasks using JOptionPane
    public static void displayTotalHours(List<Integer> taskDurations) {
        int totalHours = returnTotalHours(taskDurations);
        JOptionPane.showMessageDialog(null, "Total hours for all tasks: " + totalHours + " hours", "Total Hours", JOptionPane.INFORMATION_MESSAGE);
    }


    // Method to display the full task details using JOptionPane
    public void printTaskDetails() {
        JOptionPane.showMessageDialog(null, getTaskDetails(), "Task Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private static class allTaskDurations {

        private static void clear() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public allTaskDurations() {
        }
    }
    
    /** * Method to display the Developer, Task Names, and Task Duration for tasks with the status "done". */
    public static void displayCompletedTasks() { 
        StringBuilder completedTasks = new StringBuilder("Completed Tasks:\n"); 
    for (int i = 0; i < taskStatuses.size(); i++) 
    { if ("done".equalsIgnoreCase(taskStatuses.get(i))) 
    { completedTasks.append("Developer: ").append(developerNames.get(i)) .append(", Task Name: ").append(taskNames.get(i)) .append(", Duration: ").append(taskDurations.get(i)) .append(" hours\n"); 
    } } JOptionPane.showMessageDialog(null, completedTasks.toString(), "Completed Tasks", JOptionPane.INFORMATION_MESSAGE); }

/** * Method to display the Developer and Duration of the task with the longest duration. */
    public static void displayLongestTask() { 
        int longestIndex = 0; 
        for (int i = 1; i < taskDurations.size(); i++) { 
            if (taskDurations.get(i) > taskDurations.get(longestIndex)) { longestIndex = i; } }
        JOptionPane.showMessageDialog(null, "Developer: " + developerNames.get(longestIndex) + ", Duration: " + taskDurations.get(longestIndex) + " hours", "Longest Task", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /** * Method to search for a task by name and display its details. */ 
    public static void searchTaskByName(String taskName) { for (int i = 0; i < taskNames.size(); i++) { 
        if (taskNames.get(i).equalsIgnoreCase(taskName)) { 
            JOptionPane.showMessageDialog(null, "Task Name: " + taskNames.get(i) + "\nDeveloper: " + developerNames.get(i) + 
                    "\nTask Status: " + taskStatuses.get(i), "Task Found", JOptionPane.INFORMATION_MESSAGE); return; 
        } 
    } JOptionPane.showMessageDialog(null, "Task not found", "Error", JOptionPane.ERROR_MESSAGE); 
    }

}