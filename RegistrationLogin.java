/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationlogin;

/**
 *
 * @author Confidence
 */
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
public class RegistrationLogin {
    private static Map<String, String> accounts = new HashMap<>();

    public static void main(String[] args) {
        boolean exit = false;
     // Main loop that displays the account options and handles user input
        while (!exit) {
            String[] options = {"Create an account", "Login", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "WELCOME TO EASYKHANBAN!", "Account Registration/Login",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    createAccount();
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban. Goodbye!");
        System.exit(0);
    }

    // Method to create an account
    private static void createAccount() {
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");
        String firstName = JOptionPane.showInputDialog("Enter your firstName:");
        String lastName = JOptionPane.showInputDialog("Enter your lastName:");

        if (isValidUsername(username)) {
            if (isValidPassword(password)) {
                 // Store the account information in the accounts
                accounts.put(username, password);
                accounts.put(username + "_firstName", firstName); // Store the first name
                accounts.put(username + "_lastName", lastName); // Store the last name
                JOptionPane.showMessageDialog(null, "Account created successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid password format. Please ensure that your password contains at least 8 characters, a capital letter, a number, and a special character.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username format. Please ensure that your username contains an underscore and is no more than 5 characters in length.");
        }
    }
// Validate the username 
    private static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }
// Validates password
    private static boolean isValidPassword(String password) {
        // Password must be at least 8 characters long, contain a capital letter, a number, and a special character
        String pattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])\\S{8,}$";
        return password.matches(pattern);
    }
//The login process is handled here
    private static void login() {
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");

        if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
            String firstName = getFirstName(username);
            String lastName = getLastName(username);
            String welcomeMessage = "Welcome " + firstName + " " + lastName + ", it is great to see you again!\nWelcome to EasyKanban";
            JOptionPane.showMessageDialog(null, welcomeMessage);

            boolean loggedIn = true;
            while (loggedIn) {
                String[] menuOptions = {"Add Task", "Show Report", "Quit"};
                int menuChoice = JOptionPane.showOptionDialog(null, "Choose an option:", "Menu",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuOptions, menuOptions[0]);

                switch (menuChoice) {
                    case 0:
                        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks you want to add:"));
                        addTask(numTasks);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Coming soon!");
                        break;
                    case 2:
                        loggedIn = false;
                        break;
                    default:
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
        }
    }
// Method to extract the first name from the stored account information
    private static String getFirstName(String username) {
        String[] parts = username.split("_");
        return parts[0];
    }
// Method to extract the last name from the stored account information
    private static String getLastName(String username) {
        String[] parts = username.split("_");
        return parts[1];
    }
//method adds tasks
    private static void addTask(int numTasks) {
        int taskNumber = 0;
        for (int i = 0; i < numTasks; i++) {
            String taskName = "Add login feature";
            String taskDescription = JOptionPane.showInputDialog("Enter task description:");
            String developerFirstName = JOptionPane.showInputDialog("Enter developer's first name:");
            String developerLastName = JOptionPane.showInputDialog("Enter developer's last name:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the estimated duration of the task in hours:"));
// Ensure that the task description is less than 50 characters
            if (taskDescription.length() <= 50) {
                String taskId = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerLastName.substring(developerLastName.length() - 3).toUpperCase();
// Allow the user to select the task status
                String[] statusOptions = {"To Do", "Done", "Doing"};
                int selectedStatus = JOptionPane.showOptionDialog(null, "Select the task status:", "Task Status", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
                String taskStatus = statusOptions[selectedStatus];
// Display the task information
                JOptionPane.showMessageDialog(null, "Task ID: " + taskId + "\nTask Name: " + taskName + "\nDescription: " + taskDescription + "\nAssigned to: " + developerFirstName + " " + developerLastName + "\nDuration: " + taskDuration + " hours\nStatus: " + taskStatus);
                taskNumber++;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
            }
        }
    }
}