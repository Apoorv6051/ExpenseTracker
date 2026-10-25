# ExpenseTracker — Personal Finance Management

A personal finance management project built with Java, with the long-term goal of becoming an Android application that helps users track expenses and income, detect eligible bank transaction SMS, categorize transactions, and understand their spending habits.

## 📌 Project Status

**Current Stage:** Java Console Application — Core Features Implemented

ExpenseTracker currently provides a menu-driven Java console application with expense management, filtering, monthly summaries, input validation, and file-based persistence.

**Next Milestone — V2:** Develop, test, and deploy the Android application. Visual analytics and expense graphs will be introduced after deployment.

## 🎯 Project Goals

The long-term goal is to build a practical personal finance application that can:

- Track income and expenses.
- Add, view, edit, and delete transactions.
- Organize transactions by category and date.
- Calculate total and monthly expenses.
- Store financial data locally.
- Automatically detect eligible bank transaction SMS.
- Categorize transactions intelligently.
- Display visual spending statistics and graphs.
- Provide useful financial insights.
- Optionally support cloud synchronization in the future.

## ✨ Current Features — V1: Java Console Application

- **Add Expenses:** Record an expense with its amount, category, description, and date.
- **View Expenses:** Display recorded expenses and their details.
- **Calculate Total:** Calculate total spending across recorded expenses.
- **Edit Expenses:** Update an existing expense.
- **Delete Expenses:** Remove an expense by its displayed number.
- **Filter by Category:** Find expenses belonging to a particular category.
- **Filter by Date:** Find expenses recorded on a specific date.
- **Filter by Month:** View expenses for a selected month and year.
- **Monthly Expense Summary:** Calculate total spending for a selected month and year.
- **Input Validation:** Handle invalid amounts and menu input.
- **Exception Handling:** Handle common input and date parsing errors.
- **File Persistence:** Save expenses locally and load them when the application starts.

## 🛠️ Technology Stack

### Currently Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections (`ArrayList`)
- Exception Handling
- Java Date and Time API (`LocalDate`)
- File Handling
- Git and GitHub
- IntelliJ IDEA

### Planned for Android Development

- Android Studio
- Java and/or Kotlin
- Android UI components
- Room Database
- SQLite

### Planned for Intelligent Features

- Rule-based transaction parsing
- Smart transaction categorization
- Spending pattern analysis
- AI-assisted financial insights

### Optional Future Backend

- Spring Boot
- REST APIs
- MySQL
- User authentication
- Cloud synchronization

## 🗺️ Development Roadmap

### Phase 1 — V1: Java Console Application

- [x] Java project setup
- [x] Expense model using OOP
- [x] Store expenses using `ArrayList`
- [x] Add and view expenses
- [x] Calculate total expenses
- [x] Edit and delete expenses
- [x] Filter expenses by category
- [x] Filter expenses by date
- [x] Filter expenses by month and year
- [x] Monthly expense summary
- [x] Input validation and exception handling
- [x] File-based persistence
- [ ] Final documentation and release preparation

### Phase 2 — V2: Android Application Development and Deployment

The second version will focus on transforming the existing Java console-based ExpenseTracker into a functional Android application.

**Planned features and milestones:**

- [ ] Set up the Android project in Android Studio.
- [ ] Build a user-friendly mobile interface.
- [ ] Add, view, edit, and delete income and expense transactions.
- [ ] Implement transaction categories and history.
- [ ] Calculate total expenses, income, and balance.
- [ ] Integrate Room Database with SQLite for local data storage.
- [ ] Test the application on Android devices.
- [ ] Prepare a release build and deploy the Android application.

**Post-Deployment Enhancement:** Introduce individual expense graphs, category-wise spending charts, monthly spending trends, and visual financial analytics in a subsequent update.

### Phase 3 — Bank SMS Transaction Detection

- [ ] Understand Android SMS permissions and platform restrictions.
- [ ] Identify eligible bank transaction messages.
- [ ] Detect debit and credit transactions.
- [ ] Extract transaction amount, merchant, and date.
- [ ] Develop a transaction parser.
- [ ] Convert parsed transactions into expense or income records.
- [ ] Handle duplicate detection and parsing errors.

### Phase 4 — Intelligent Financial Features

- [ ] Smart transaction categorization.
- [ ] Monthly spending insights.
- [ ] Spending pattern analysis.
- [ ] Unusual spending detection.
- [ ] Personalized financial insights.

AI functionality will be introduced after the core application is working reliably.

### Phase 5 — Optional Backend and Cloud Synchronization

- [ ] Develop a Spring Boot backend.
- [ ] Create REST APIs.
- [ ] Integrate MySQL.
- [ ] Implement authentication.
- [ ] Add optional cloud synchronization.
- [ ] Implement backup and restore.

## 🏗️ Current Architecture

The current console application follows a simple Java architecture:

```text
User
  |
  v
Java Console Application
  |
  v
Expense Objects
  |
  v
ArrayList<Expense>
  |
  v
File-Based Storage
(expenses.txt)
```

The application loads saved expenses when it starts and persists changes through its file-management functionality.

## 🔮 Planned Android Architecture

The Android application is planned to use a local database, with optional backend integration in the future.

```text
User
  |
  v
Android Application
  |
  v
Transaction Management
  |
  v
Room Database / SQLite
  |
  +----> Visual Analytics (after deployment)
  |
  +----> SMS Transaction Parsing
  |
  +----> Intelligent Categorization
  |
  v
Optional Spring Boot Backend
  |
  v
MySQL / Cloud Synchronization
```

This is a planned architecture. The Android, SMS, visual analytics, and backend components are not claimed to be implemented in the current console version.

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK)
- IntelliJ IDEA or another Java IDE
- Git (optional, for cloning the repository)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Apoorv6051/ExpenseTracker.git
   ```

2. Open the project in IntelliJ IDEA.
3. Configure the JDK.
4. Locate `Main.java` in the `MainApplication` package.
5. Run the `Main` class.
6. Follow the console menu to manage expenses.

### Data Storage

The current application stores expenses locally in `expenses.txt` through its file-management functionality.

Keep the data file safe if you want to preserve your recorded expenses.

## 🔐 Privacy and Security

Bank SMS detection and cloud synchronization are planned features, not current capabilities. Any future implementation will need to consider permissions, transaction-data privacy, secure storage, and applicable Android platform restrictions.

## 📚 Learning Objectives

This project provides practical experience with:

- Java fundamentals and OOP
- Collections and data structures
- Input validation and exception handling
- File handling and persistence
- Modular code organization
- Git and GitHub workflows
- Android development
- Database integration
- Transaction parsing
- Financial analytics

## 🤝 Contributions

This is currently a personal learning and portfolio project. Suggestions and constructive feedback are welcome.

## 📄 License

No license has been specified yet. 

---

**ExpenseTracker** — From a Java console application to a smarter Android personal finance experience.
