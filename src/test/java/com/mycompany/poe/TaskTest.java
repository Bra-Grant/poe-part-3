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
}