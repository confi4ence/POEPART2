/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationlogin;

import javax.swing.JOptionPane;

/**
 *
 * @author Confidence
 */
public class Task {
    // This method checks if the given task description has a length limit of 50 characters
public static boolean checkTaskDescription(String taskDescription) {
    return taskDescription.length() <= 50;
}
// This method creates a unique task ID based on the task name, task number, and developer's last name
public static String createTaskID(String taskName, int taskNumber, String developerLastName) {
    return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerLastName.substring(developerLastName.length() - 3).toUpperCase();
}
// This method prints the details of a task, including the task ID, name, description, assigned developer, duration, and status
public static String printTaskDetails(String taskId, String taskName, String taskDescription, String developerFirstName, String developerLastName, int taskDuration, String taskStatus) {
    return "Task ID: " + taskId + "\nTask Name: " + taskName + "\nDescription: " + taskDescription + "\nAssigned to: " + developerFirstName + " " + developerLastName + "\nDuration: " + taskDuration + " hours\nStatus: " + taskStatus;
}
// This method calculates the total hours of all the tasks
public static int returnTotalHours(int[] taskDurations) {
    int totalHours = 0;
    for (int duration : taskDurations) {
        totalHours += duration;
    }
    return totalHours;
}
// This method is the main for adding tasks
private static void addTask(int numTasks) {
    int taskNumber = 0;
    int[] taskDurations = new int[numTasks];
 // This Loop collects task information from the user
    for (int i = 0; i < numTasks; i++) {
        String taskName = "Add login feature";
        String taskDescription = JOptionPane.showInputDialog("Enter the task description:");
        String developerFirstName = JOptionPane.showInputDialog("Enter the developer's first name:");
        String developerLastName = JOptionPane.showInputDialog("Enter the developer's last name:");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the estimated duration of the task in hours:"));
        taskDurations[i] = taskDuration;

        if (checkTaskDescription(taskDescription)) {
            String taskId = createTaskID(taskName, taskNumber, developerLastName);

            // Allow the user to select the task status
            String[] statusOptions = {"To Do", "Done", "Doing"};
            int selectedStatus = JOptionPane.showOptionDialog(null, "Select the task status:", "Task Status", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
            String taskStatus = statusOptions[selectedStatus];

            // Display the task information
            String taskDetails = printTaskDetails(taskId, taskName, taskDescription, developerFirstName, developerLastName, taskDuration, taskStatus);
            JOptionPane.showMessageDialog(null, taskDetails);
            taskNumber++;
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
        }
    }

    int totalHours = returnTotalHours(taskDurations);
    JOptionPane.showMessageDialog(null, "The total combined hours of all tasks is: " + totalHours + " hours.");
}
}
