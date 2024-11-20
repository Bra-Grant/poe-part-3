/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;


import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class InputValidation {

    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPassword(String password) {
        Pattern checkNum = Pattern.compile("[0123456789]");
        Pattern checkSpecials = Pattern.compile("[*-.`~!@#$%&_'^]");
        Pattern checkUpper = Pattern.compile("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]");
        return password.length() >= 8 
            && checkNum.matcher(password).find() 
            && checkSpecials.matcher(password).find() 
            && checkUpper.matcher(password).find();
    }

    public String registerUser(String firstname, String lastname, String username, String password) {
        if (!checkUsername(username)) {
            return "Invalid username. It must contain an underscore and be no more than 5 characters.";
        }
        if (!checkPassword(password)) {
            return "Invalid password. It must contain at least 8 characters, a capital letter, a number, and a special character.";
        }

        return "Registration successful!";
    }
    
// Method to handle login.
   public boolean login(String loginUsername, String loginPassword, String correctUsername, String correctPassword, String firstName, String lastName) {
        boolean loginSuccess = loginUsername.equals(correctUsername) && loginPassword.equals(correctPassword);
        String message = returnLoginStatus(loginSuccess, firstName, lastName);
        JOptionPane.showMessageDialog(null, message);
        return loginSuccess;
    }
   
    public String returnLoginStatus(boolean loginSuccess,String firstName, String lastName) {
        if (loginSuccess) {
            return "Welcome! "+ firstName + " " + lastName + "!";
        } else {
            return "Username or password incorrect.";
        }
    }

    // Method to handle registration
   public String[] register(String username, String password,String firstname,String lastname) {
       
// Prompt for username
        do {
    username = JOptionPane.showInputDialog("Create a username (must contain an underscore and be no more than 5 characters):");
    
    if (username != null && checkUsername(username)) {
        JOptionPane.showMessageDialog(null, "Username is valid and captured!");
    } else {
        JOptionPane.showMessageDialog(null, "Invalid username. It must contain an underscore and be no more than 5 characters.");
    }
    } while (!checkUsername(username));

        
//prompt for password
do {
            password = JOptionPane.showInputDialog(null, "Enter password (must be at least 8 characters, contain a capital letter, a number, and a special character):");
            if (checkPassword(password)) {
                JOptionPane.showMessageDialog(null, "Password is captured!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid password. It must contain at least 8 characters, a capital letter, a number, and a special character.");
            }
        } while (!checkPassword(password));

return new String[]{username, password,firstname, lastname}; 


   
    

}
}

        