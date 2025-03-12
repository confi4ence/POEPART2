/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mycompany.registrationlogin.Task;
/**
 *
 * @author Confidence
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import javax.swing.JOptionPane;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
   

    @Test
    void testCheckTaskDescription() {
        assertTrue(Task.checkTaskDescription("This is a valid task description."));
        assertFalse(Task.checkTaskDescription("This task description is more than 50 characters long and should not be allowed."));
    }

    @Test
    void testCreateTaskID() {
        assertEquals("AD:1:ESO", Task.createTaskID("Add login feature", 1, "Robyn Harrison"));
        assertEquals("CR:2:SMI", Task.createTaskID("Create report", 2, "Mike Smith"));
    }

    @Test
    void testPrintTaskDetails() {
        String expectedOutput = "Task ID: AD:1:ESO\nTask Name: Add login feature\nDescription: Implement login feature\nAssigned to: John Eason\nDuration: 20 hours\nStatus: To Do";
        String actualOutput = Task.printTaskDetails("AD:1:ESO", "Add login feature", "Implement login feature", "John", "Eason", 20, "To Do");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testReturnTotalHours() {
        int[] taskDurations = {8, 12, 16, 10};
        assertEquals(46, Task.returnTotalHours(taskDurations));

    }
}
