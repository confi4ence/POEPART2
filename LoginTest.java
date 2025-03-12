/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mycompany.registrationlogin.Login;
/**
 *
 * @author Confidence
 */import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    private Login login;
    private Map<String, String> accounts;

    @BeforeEach
    void setUp() {
        // Initialize the accounts map with some sample data
        accounts = new HashMap<>();
        accounts.put("use_1", "Password@123!");
        accounts.put("use_r", "Abc123@def");
        accounts.put("use_3", "My@Password!");

        // Create a new instance of the Login class with the accounts map
        login = new Login(accounts);
    }

    @Test
    void testCheckUserName_ValidUsername() {
        assertTrue(login.checkUserName("Kyl_1"));
    }

    @Test
    void testCheckUserName_InvalidUsername() {
        assertFalse(login.checkUserName("Kyle!!!!!!!!!"));
    }

    @Test
    void testCheckPasswordComplexity_ValidPassword() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    void testCheckPasswordComplexity_InvalidPassword() {
        assertFalse(login.checkPasswordComplexity("Password"));
    }

    @Test
    void testRegisterUser_ValidCredentials() {
        String result = login.registerUser();
        assertEquals("User registered successfully!", result);
    }

    @Test
    void testRegisterUser_InvalidCredentials() {
        // Simulate invalid credentials
        login.registerUser();
        String result = login.registerUser();
        assertEquals("Invalid username or password. Please try again.", result);
    }

    @Test
    void testLoginUser_ValidCredentials() {
        assertTrue(login.loginUser("Kyl_1", "Password@123!"));
    }

    @Test
    void testLoginUser_InvalidCredentials() {
        assertFalse(login.loginUser("user1", "InvalidPassword"));
    }

    @Test
    void testReturnLoginStatus_ValidCredentials() {
        String result = login.returnLoginStatus("use_1", "Password@123!");
        assertEquals("Login successful!", result);
    }

    @Test
    void testReturnLoginStatus_InvalidCredentials() {
        String result = login.returnLoginStatus("user1", "InvalidPassword");
        assertEquals("Invalid username or password. Please try again.", result);
    }
}
