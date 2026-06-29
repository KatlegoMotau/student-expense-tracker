# 💰 Student Expense Tracker (Java)

A simple yet powerful **Java-based Student Expense Tracking System** that helps users record, manage, and analyse daily expenses.

The application includes both:
- 🖥️ A console-style JOptionPane interface
- 🎨 A fully functional Java Swing GUI

It also supports **persistent file storage**, ensuring all data is saved automatically in a local text file.

---

## ✨ Features

- ➕ Add new expenses (description, amount, category)
- 📋 View all recorded expenses
- 💸 Calculate total spending
- 📊 View spending grouped by category
- ❌ Delete expenses (GUI version)
- 💾 Persistent storage using `expenses.txt`
- 🖥️ Two interfaces:
  - JOptionPane-based menu system
  - Java Swing graphical interface

---

## 🧱 Project Structure

```
studentexpensetracker/
│
├── studentexpensetracker/
│ └── StudentExpenseTracker.java
│
├── expensetrackergui/
│ └── ExpenseTrackerGUI.java
│
├── expense/
│ └── Expense.java
│
├── expensemanager/
│ └── ExpenseManager.java
│
└── expenses.txt
```

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- Java Swing
- Java AWT
- File Handling (BufferedReader, FileWriter, PrintWriter)
- Object-Oriented Programming (OOP)

---

## 🚀 How to Run

### 1. Clone the repository

```bash
git clone https://github.com/your-username/student-expense-tracker.git
```

### 2. Open in an IDE

You can run this project using:

NetBeans
IntelliJ IDEA
Eclipse

### 3. Run the Application
▶ JOptionPane / Console Version

Run:

StudentExpenseTracker.java

▶ GUI Version

Run:

ExpenseTrackerGUI.java

---

## 💾 Data Storage

All expenses are stored in a local file:

expenses.txt

Each record follows this format:

description,amount,category

Example:

Lunch,50,Food
Taxi,30,Transport

---

## 📊 Core Functionalities
🧠 ExpenseManager (Business Logic)

Handles all backend operations:

Add expense
Delete expense
Load/save data from file
Calculate total expenses
Group expenses by category

---

## 🧾 Expense Class

Represents a single expense entry:

Description
Amount
Category

---

## 📚 Learning Outcomes

This project demonstrates strong understanding of:

Object-Oriented Programming (OOP)
GUI development using Java Swing
File persistence in Java
Exception handling
Separation of concerns (UI vs logic architecture)
