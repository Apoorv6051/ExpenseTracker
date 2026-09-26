# Expense Tracker

A personal finance management Android application designed to help users track
expenses and income, automatically detect eligible bank transaction SMS,
categorize transactions, and provide useful spending insights.

## Project Status

🚧 **Currently under development**

The project is being developed step-by-step, starting with a Java console
application and gradually evolving into a full Android expense management
application.

---

## 🎯 Project Goal

The goal of this project is to build a practical personal finance application
that can:

- Track income and expenses
- Store and manage transactions
- Automatically detect eligible bank transaction SMS
- Extract transaction information from SMS
- Categorize transactions intelligently
- Provide spending insights
- Display useful financial statistics
- Store data locally
- Optionally support cloud synchronization in the future

---

## 🛠️ Planned Technology Stack

### Current Development

- Java
- Object-Oriented Programming
- Java Collections
- Exception Handling
- File Handling
- Git & GitHub

### Android Development

- Android Studio
- Java / Kotlin
- Android UI
- Room Database
- SQLite

### Intelligent Features

- Rule-based transaction parsing
- AI-powered transaction categorization
- AI-powered spending insights

### Optional Future Backend

- Spring Boot
- REST API
- MySQL
- Cloud synchronization

---

## 🏗️ Development Roadmap

### Phase 1 — Java Foundation

- [x] Java project setup
- [x] GitHub repository setup
- [x] Expense model using OOP
- [x] ArrayList for storing expenses
- [x] Add expenses
- [x] View expenses
- [x] Calculate total expenses
- [x] Menu-based console application
- [x] Input validation
- [x] Exception handling
- [ ] Refactor code into methods
- [ ] Testing and cleanup

### Phase 2 — Data Persistence

- [ ] Learn file handling
- [ ] Save expenses to a file
- [ ] Load expenses from a file
- [ ] Handle missing/corrupted data

### Phase 3 — Android Fundamentals

- [ ] Learn Android Studio
- [ ] Understand Android project structure
- [ ] Learn Activities and app lifecycle
- [ ] Build Android UI
- [ ] Handle user input
- [ ] Navigation between screens

### Phase 4 — Android Expense Tracker

- [ ] Add income
- [ ] Add expenses
- [ ] Categories
- [ ] Transaction history
- [ ] Balance calculation
- [ ] Local data storage
- [ ] Room Database
- [ ] Basic dashboard

### Phase 5 — Bank SMS Transaction Detection

- [ ] Understand Android SMS permissions and restrictions
- [ ] Detect eligible transaction SMS
- [ ] Identify debit and credit transactions
- [ ] Extract transaction amount
- [ ] Extract merchant information
- [ ] Extract transaction date
- [ ] Build transaction parser
- [ ] Convert detected transactions into Expense/Income records

### Phase 6 — AI Features

- [ ] Smart transaction categorization
- [ ] Spending pattern analysis
- [ ] Monthly spending insights
- [ ] Unusual spending detection
- [ ] Personalized financial insights

AI will be introduced only after the core application is working.

### Phase 7 — Optional Backend

- [ ] Spring Boot backend
- [ ] REST APIs
- [ ] MySQL database
- [ ] User authentication
- [ ] Cloud synchronization
- [ ] Backup and restore

---

## 🔄 Planned Architecture

### Current

```text
User
  ↓
Java Console Application
  ↓
Expense Objects
  ↓
ArrayList