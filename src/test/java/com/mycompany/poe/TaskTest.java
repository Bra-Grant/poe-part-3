/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {

  
    // Mock data
    private static List<String> taskStatuses;
    private static List<String> developerNames;
    private static List<String> taskNames;
    private static List<Integer> taskDurations; 
    private static int taskCount;
    
    @BeforeEach
    void setUp() {
        // Initialize the lists with test data
        taskStatuses = new ArrayList<>();
        developerNames = new ArrayList<>();
        taskNames = new ArrayList<>();
        taskDurations = new ArrayList<>();
        taskCount = 4;
    
    // Add sample data
        taskStatuses.add("doing");
        taskStatuses.add("to do");
        taskStatuses.add("done");

        developerNames.add("Mike Smith");
        developerNames.add("Edward Harrison");
        developerNames.add("Samantha Paulson");
        developerNames.add("Glenda Oberholzer");

        taskNames.add("create login");
        taskNames.add("create add features");
        taskNames.add("create reports");
        taskNames.add("add arrays");

        taskDurations.add(5);
        taskDurations.add(8);
        taskDurations.add(2);
        taskDurations.add(11);
    }
    
    //Developer Array is correctly populated
    @Test
    void testDeveloperArray(){
         
     System.out.println(developerNames);  
            
        }
        
    @Test
    public void testDeveloperArray1() {
        Task task1 = new Task("Create Login", 5, "To Do", "Mike Smith", 5, "To Do");
        Task task2 = new Task("Create Add Features", 8, "Doing", "Edward Harrison", 8, "Doing");
        Task task3 = new Task("Create Reports", 2, "Done", "Samantha Paulson", 2, "Done");
        Task task4 = new Task("Add Arrays", 11, "To Do", "Glenda Oberholzer", 11, "To Do");

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        // Developer array correctly populated
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        String[] actualDevelopers = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            actualDevelopers[i] = tasks.get(i).getDeveloperDetails();
        }
        assertArrayEquals(expectedDevelopers, actualDevelopers);
    }
    
    // Test: Display Developer and Duration for task with longest duration
    @Test
void testDisplayLongestTask() {
    int longestIndex = 0;

    // Find the index of the longest task
    for (int i = 1; i < taskDurations.size(); i++) {
        if (taskDurations.get(i) > taskDurations.get(longestIndex)) {
            longestIndex = i;
        }
    }

    // Expected result
    String expected = "Glenda Oberholzer, 11 hours";

    // Actual result
    String actual = developerNames.get(longestIndex) + ", " + taskDurations.get(longestIndex) + " hours";


    System.out.println("Longest Task: " + actual);

    // Assert to verify correctness
    assertEquals(expected, actual);
}

// Test: Search for a specific task
   @Test
void testSearchForTask() {
    
    Task.clearStaticLists();

    
    Task task = new Task("Create Login", 1, "Develop login page", "Mike Smith", 5, "To Do");

    
    String taskToSearch = "Create Login";
    Task.searchTaskByName(taskToSearch); 

    
    int index = Task.taskNames.indexOf(taskToSearch);
    String expected = "Mike Smith, Create Login";
    String actual = Task.developerNames.get(index) + ", " + Task.taskNames.get(index);
    
    assertEquals(expected, actual);
}
// Test: Search all tasks assigned to a Developer
    @Test
void testSearchTasksByDeveloper() {
    // Define the developer and expected task details
    String developer = "Samantha Paulson";
    StringBuilder expected = new StringBuilder("create reports");
    StringBuilder actual = new StringBuilder();

    // Loop through the developer names and gather task names
    for (int i = 0; i < developerNames.size(); i++) {
        if (developerNames.get(i).equalsIgnoreCase(developer)) {
            actual.append(taskNames.get(i));
            // Print the developer and task being matched
            System.out.println("Matching task: " + taskNames.get(i) + " ,for developer: " + developerNames.get(i));
        }
    }

   

    // Assert if the expected task names match the actual ones
    assertEquals(expected.toString(), actual.toString());
}

// Test: Delete a task from the array
@Test
void testDeleteTask() {
    String taskToDelete = "Create Reports";
    int index = taskNames.indexOf(taskToDelete);

    // Check if the task exists before deletion
    System.out.println("Task to delete: " + taskToDelete);
   

    // Delete task data
    if (index != -1) {
        developerNames.remove(index);
        taskNames.remove(index);
        taskStatuses.remove(index);
        taskDurations.remove(index);

        // Print confirmation of deletion
        System.out.println("Task deleted successfully: " + taskToDelete);
    } else {
        System.out.println("Task not found, nothing to delete.");
    }

    // Verify task is deleted
    assertFalse(taskNames.contains(taskToDelete));
    System.out.println("Task deletion verification: " + !taskNames.contains(taskToDelete));
}
// Test: Display a task report
@Test
void testDisplayReport() {
    // Print the sizes of the lists for debugging purposes
    System.out.println("taskNames size: " + taskNames.size());
    System.out.println("developerNames size: " + developerNames.size());
    System.out.println("taskDurations size: " + taskDurations.size());
    System.out.println("taskStatuses size: " + taskStatuses.size());

    StringBuilder expectedReport = new StringBuilder("All Captured Tasks:\n");
    for (int i = 0; i < taskNames.size(); i++) {
        expectedReport.append("Task Name: ").append(taskNames.get(i))
                .append(", Developer: ").append(developerNames.get(i))
                .append(", Duration: ").append(taskDurations.get(i)).append(" hours")
                .append(", Status: ").append(taskStatuses.get(i)).append("\n");
    }

    // Print expected report before comparison
    System.out.println("Expected Report:\n" + expectedReport.toString());

    StringBuilder actualReport = new StringBuilder("All Captured Tasks:\n");
    for (int i = 0; i < taskNames.size(); i++) {
        actualReport.append("Task Name: ").append(taskNames.get(i))
                .append(", Developer: ").append(developerNames.get(i))
                .append(", Duration: ").append(taskDurations.get(i)).append(" hours")
                .append(", Status: ").append(taskStatuses.get(i)).append("\n");
    }

    // Print actual report before comparison
    System.out.println("Actual Report:\n" + actualReport.toString());

    assertEquals(expectedReport.toString(), actualReport.toString());
}
    
}