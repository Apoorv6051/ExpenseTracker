
package MainApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Scanner takes input from the user.
        Scanner sc = new Scanner(System.in);

        // Load previously saved expenses when the application starts.
        ArrayList<Expense> expenses = ExpenseFileManager.loadExpenses();

        // Menu keeps running until the user chooses option 4.
        int choice = 0;

        while (choice != 4) {

            // Display the menu.
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Show Total");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            try {
                // Read the user's menu choice.
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                // Handle non-numeric menu input.
                System.out.println("Please enter a valid choice.");
                sc.nextLine(); // Clear invalid input.
                choice = 0;
            }

            // Option 1: Add an expense and save the updated list.
            if (choice == 1) {
                addExpense(sc, expenses);
                ExpenseFileManager.saveExpenses(expenses);

                // Option 2: Display all saved expenses.
            } else if (choice == 2) {
                viewExpenses(expenses);

                // Option 3: Display the total of all expenses.
            } else if (choice == 3) {
                showTotal(expenses);

                // Option 4: Exit the application.
            } else if (choice == 4) {
                System.out.println("Thank you for using Expense Tracker!");

                // Handle invalid menu choices.
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        // Close Scanner when the program ends.
        sc.close();
    }

    // Adds one expense to the ArrayList.
    static void addExpense(Scanner sc, ArrayList<Expense> expenses) {

        double amount;
        String category;
        String description;
        boolean validAmount = false;

        while (!validAmount) {
            try {
                System.out.print("Enter amount: ");
                amount = sc.nextDouble();

                // Expense amount must be greater than zero.
                if (amount <= 0) {
                    System.out.println("Please enter a valid amount.");
                } else {
                    validAmount = true;

                    // Remove the leftover newline after nextDouble().
                    sc.nextLine();
                    do {
                        System.out.print("Enter category: ");
                        category = sc.nextLine().trim();

                        if(category.isEmpty()) {
                            System.out.println("Category cannot be empty.");
                        }
                    } while (category.isEmpty());
                    do {

                        System.out.print("Enter description: ");
                        description = sc.nextLine().trim();

                        if(description.isEmpty()) {
                            System.out.println("Description cannot be empty.");
                        }
                    } while (description.isEmpty());

                    // Create and store the new Expense object.
                    Expense expense = new Expense(
                            amount,
                            category,
                            description,
                            LocalDate.now()
                    );

                    expenses.add(expense);

                    System.out.println("Expense added successfully!");
                }

            } catch (InputMismatchException e) {
                // Handle invalid amount input.
                System.out.println(
                        "Invalid input. Please enter a valid number."
                );
                sc.nextLine(); // Clear invalid input.
            }
        }
    }

    // Displays all expenses currently stored in the ArrayList.
    static void viewExpenses(ArrayList<Expense> expenses) {

        System.out.println("\nYour Expenses:");

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
        } else {
            for (Expense expense : expenses) {
                System.out.println("Amount: " + expense.getAmount());
                System.out.println("Category: " + expense.getCategory());
                System.out.println("Description: " + expense.getDescription());
                System.out.println("Date: " + expense.getDate());
                System.out.println("---------------------------");
            }
        }
    }

    // Calculates and displays the total of all expenses.
    static void showTotal(ArrayList<Expense> expenses) {


        double totalExpense = 0.0;

        for (Expense expense : expenses) {
            totalExpense += expense.getAmount();
        }

        System.out.println("Total Expenses: " + totalExpense);
    }
}
