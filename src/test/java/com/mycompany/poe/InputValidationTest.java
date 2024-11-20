/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;

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
public class InputValidationTest {
    
    public InputValidationTest() {
    }
    
   

    /**
     * Test of checkUsername method, of class InputValidation.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "";
        InputValidation instance = new InputValidation();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkPassword method, of class InputValidation.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "";
        InputValidation instance = new InputValidation();
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of registerUser method, of class InputValidation.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String firstname = "";
        String lastname = "";
        String username = "";
        String password = "";
        InputValidation instance = new InputValidation();
        String expResult = "";
        String result = instance.registerUser(firstname, lastname, username, password);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of login method, of class InputValidation.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String loginUsername = "";
        String loginPassword = "";
        String correctUsername = "";
        String correctPassword = "";
        String firstName = "";
        String lastName = "";
        InputValidation instance = new InputValidation();
        boolean expResult = false;
        boolean result = instance.login(loginUsername, loginPassword, correctUsername, correctPassword, firstName, lastName);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of returnLoginStatus method, of class InputValidation.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean loginSuccess = false;
        String firstName = "";
        String lastName = "";
        InputValidation instance = new InputValidation();
        String expResult = "";
        String result = instance.returnLoginStatus(loginSuccess, firstName, lastName);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of register method, of class InputValidation.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        String username = "";
        String password = "";
        String firstname = "";
        String lastname = "";
        InputValidation instance = new InputValidation();
        String[] expResult = null;
        String[] result = instance.register(username, password, firstname, lastname);
        assertArrayEquals(expResult, result);
        
    }
    
}
