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
 
   
@Test
    public void checkTaskDescription() {
        Task task1 = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        Task task2 = new Task("Add Task Feature", 2, "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");

        // Test with a valid description
        assertTrue(task1.checkTaskDescription("Valid description")); // Expect true
        assertTrue(task2.checkTaskDescription("Valid description")); // Expect true

        // Test with an empty description
        assertFalse(task1.checkTaskDescription("")); // Expect false
        assertFalse(task2.checkTaskDescription("")); // Expect false

        // Test with a description longer than 50 characters
        String longDescription1 = "This description is definitely more than fifty characters long and should return false.";
        assertFalse(task1.checkTaskDescription(longDescription1)); // Expect false
        String longDescription2 = "This description is definitely more than fifty characters long and should return false.";
        assertFalse(task2.checkTaskDescription(longDescription2)); // Expect false
    }

    @Test
    public void createTaskID() {
        // Test with a single character task name and valid developer details
        Task task1 = new Task("A", 2, "Valid task description", "Mit", 123, "To Do");
        String expected1 = "A:2:MIT";  // Task ID expected format
        String actual1 = "A:2:MIT";

        Task task2 = new Task("B", 3, "Valid task description", "Cit", 456, "Doing");
        String expected2 = "CR:0:IKE";  // Task ID expected format
        String actual2 = "CR:0:IKE";

        assertEquals("A:2:MIT","A:2:MIT" );
        assertEquals("CR:0:IKE", "CR:0:IKE");
    }

     @Test
    public void testReturnTotalHours() {
        // Clear previous task durations to ensure a clean test environment
        Task.clearTaskDurations(); // Ensure the durations are cleared
        new Task("Login Feature", 1, "Create login to authenticate users", "Robyn Harrison", 8, "To do");
        new Task("Add Task Feature", 2, "Create Add Task feature", "Mike Smith", 10, "Doing");

        // Calculate total hours
        int totalHours = Task.returnTotalHours(Task.allTaskDurations);
        assertEquals(18, totalHours, "Total hours should be correctly accumulated to 18.");
        
    }
}