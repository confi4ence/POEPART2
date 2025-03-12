/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationlogin;

/**
 *
 * @author Confidence
 */

    import java.util.Map;
import javax.swing.JOptionPane;

public class Login {
    private Map<String, String> accounts;

    public Login(Map<String, String> accounts) {
        this.accounts = accounts;
    }
//This is for prompting the user to enter their username and password
    public void performLogin() {
        String username = JOptionPane.showInputDialog("Please enter your username:");
        String password = JOptionPane.showInputDialog("Please enter your password:");

        if (loginUser(username, password)) {
            JOptionPane.showMessageDialog(null, "Login successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
        }
    }

    public boolean checkUserName(String username) {
        return username.contains("_");
    }

    public boolean checkPasswordComplexity(String password) {
       //this checks password complexity 
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".\\d.");
        boolean hasSpecialChar = password.matches(".[!@#$%^&()].*");
        boolean isComplex = (password.length() >= 8) && hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
        
        return isComplex;
    }
    
    public String registerUser() {
        //This prompts the user to enter a username
        String username = JOptionPane.showInputDialog("Please Enter your username:");
        //This prompts user to enter a password
        String password = JOptionPane.showInputDialog("Please enter your password:");
        //This checks if the username and password are valid
        if (checkUserName(username) && checkPasswordComplexity(password)) {
            accounts.put(username, password);
            //Return a success message
            return "User has registered successfully!";
        } else {
            return "Invalid username or password. Please try again."; //Return an error message when the username and password are wrong.
        }
    }
    
    public boolean loginUser(String username, String password) {
        //checks if the account contains the given username and checks if the username and password matches then return a true statement
        if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
            return true;
        } else {
            return false; // If the username doesn't exist or the password doesn't match, return false (failed login)
        }
        
   // public boolean loginUser(String pass, String username, boolean checkName, boolean checkPassword){
        
        //boolean logged = false;
        //if(checkName && checkPassword) { //only run in the user successfully registered
                      
            //String username = JOptionPane.showInputDialog("Enter the username you used to register");
            
            //String password = JOptionPane.showInputDialog("Enter the password you used to register");
            
            //if (password.equals(pass) && username.equals(usrname)  ){
              //  logged = true;
           // }
        //}
       // return logged;
    }
    
    public String returnLoginStatus(String username, String password) {
        // Call the loginUser method to check if the login is successful
        if (loginUser(username, password)) {
            return "Login successful!";  // If the login is successful, return a success message
        } else {
            return "Invalid username or password. Please try again.";   // If the login fails, return an error message
        }
    }
    
    
}
