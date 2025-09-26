# EasyKanban - Registration, Login & Task Management System

## 📌 Overview
EasyKanban is a **Java Swing-based application** that provides a simple way to manage user accounts and tasks.  
It simulates the core functionalities of a lightweight **Kanban system**, including **registration, login, and task tracking**.

## 🚀 Features
- **Account Registration**
  - Username must contain `_` and be at most 5 characters.
  - Password must be at least 8 characters, with:
    - One uppercase letter
    - One number
    - One special character
- **Login**
  - Secure login using registered credentials
  - Personalized welcome message
- **Task Management**
  - Add multiple tasks
  - Task validation (description ≤ 50 characters)
  - Unique Task IDs (`XX:NUM:DEV`)
  - Assign developers and set task duration
  - Choose task status: `To Do`, `Doing`, or `Done`
  - Total combined task hours calculation
- **User Interface**
  - Menu-driven interaction via `JOptionPane`
  - Beginner-friendly GUI

## 🛠️ Technologies Used
- **Java** (JDK 8+)
- **Swing (JOptionPane)**
- **HashMap** for in-memory storage

## 📂 Project Structure
com.mycompany.registrationlogin
│
├── RegistrationLogin.java # Main program with account & task logic
├── Login.java # Handles login, registration validation
└── Task.java # Manages task creation and total hours
