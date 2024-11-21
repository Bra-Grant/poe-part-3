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
    
    @Test
    public void testDeveloperArray() {
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