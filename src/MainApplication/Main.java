
package MainApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Load saved expenses when the application starts.
        ArrayList<Expense> expenses = ExpenseFileManager.loadExpenses();

        int choice = 0;

        // Keep running until the user chooses Exit.
        while (choice != 7) {

            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Show Total");
            System.out.println("4. Delete Expense");
            System.out.println("5. Edit Expense");
            System.out.println("6. Filter by Category");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                choice = 0;
            }

            if (choice == 1) {
                addExpense(sc, expenses);
                ExpenseFileManager.saveExpenses(expenses);

            } else if (choice == 2) {
                viewExpenses(expenses);

            } else if (choice == 3) {
                showTotal(expenses);

            } else if (choice == 4) {
                deleteExpense(sc, expenses);

            } else if (choice == 5) {
                editExpense(sc, expenses);

            } else if (choice == 6) {
                //Clear the new line by nextInt();
                sc.nextLine();

                // filter expense by category
                filterByCategory(sc, expenses);


            } else if (choice == 7) {

                // Exit the application.
                System.out.println("Thank you for using Expense Tracker!");

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

    // Adds an expense after validating its details.
    static void addExpense(Scanner sc, ArrayList<Expense> expenses) {

        double amount;
        String category;
        String description;

        while (true) {
            try {
                System.out.print("Enter amount: ");
                amount = sc.nextDouble();

                if (!Double.isFinite(amount) || amount <= 0) {
                    System.out.println("Enter a valid positive amount.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }

        sc.nextLine();

        // Require a non-empty category.
        do {
            System.out.print("Enter category: ");
            category = sc.nextLine().trim();

            if (category.isEmpty()) {
                System.out.println("Category cannot be empty.");
            }
        } while (category.isEmpty());

        // Require a non-empty description.
        do {
            System.out.print("Enter description: ");
            description = sc.nextLine().trim();

            if (description.isEmpty()) {
                System.out.println("Description cannot be empty.");
            }
        } while (description.isEmpty());

        // Create and store the new expense.
        Expense expense = new Expense(
                amount, category, description, LocalDate.now()
        );

        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    // Displays all expenses with numbers for selection.
    static void viewExpenses(ArrayList<Expense> expenses) {

        System.out.println("\n===== YOUR EXPENSES =====");

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        for (int i = 0; i < expenses.size(); i++) {
            Expense expense = expenses.get(i);

            System.out.println("Expense No.: " + (i + 1));
            System.out.println("Amount: " + expense.getAmount());
            System.out.println("Category: " + expense.getCategory());
            System.out.println("Description: " + expense.getDescription());
            System.out.println("Date: " + expense.getDate());
            System.out.println("---------------------------");
        }
    }

    // Calculates the total of all expenses.
    static void showTotal(ArrayList<Expense> expenses) {

        double totalExpense = 0.0;

        for (Expense expense : expenses) {
            totalExpense += expense.getAmount();
        }

        System.out.println("Total Expenses: " + totalExpense);
    }

    // Deletes an expense selected by its displayed number.
    static void deleteExpense(Scanner sc, ArrayList<Expense> expenses) {

        if (expenses.isEmpty()) {
            System.out.println("No expenses available to delete.");
            return;
        }

        viewExpenses(expenses);

        int expenseNumber;

        try {
            System.out.print("Enter the expense number to delete: ");
            expenseNumber = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a whole number.");
            sc.nextLine();
            return;
        }

        if (expenseNumber < 1 || expenseNumber > expenses.size()) {
            System.out.println("Invalid expense number. Nothing was deleted.");
            return;
        }

        // Remove the selected expense using its zero-based index.
        Expense removedExpense = expenses.remove(expenseNumber - 1);

        System.out.println(
                "Deleted: " + removedExpense.getCategory()
                        + " - " + removedExpense.getAmount()
        );

        // Save the updated list so deletion persists.
        ExpenseFileManager.saveExpenses(expenses);
    }

    // Edits an existing expense selected by its displayed number.
    static void editExpense(Scanner sc, ArrayList<Expense> expenses) {

        if (expenses.isEmpty()) {
            System.out.println("No expenses available to edit.");
            return;
        }

        viewExpenses(expenses);

        int expenseNumber;

        try {
            System.out.print("Enter the expense number to edit: ");
            expenseNumber = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a whole number.");
            sc.nextLine();
            return;
        }

        // Validate the selected expense number.
        if (expenseNumber < 1 || expenseNumber > expenses.size()) {
            System.out.println("Invalid expense number. Nothing was edited.");
            return;
        }

        // Get the existing Expense object from the list.
        Expense expense = expenses.get(expenseNumber - 1);

        System.out.println("\nLeave a field blank to keep its current value.");

        // Read and validate a replacement amount, if provided.
        System.out.print("New amount (" + expense.getAmount() + "): ");
        sc.nextLine();
        String amountInput = sc.nextLine().trim();

        if (!amountInput.isEmpty()) {
            try {
                double newAmount = Double.parseDouble(amountInput);

                if (!Double.isFinite(newAmount) || newAmount <= 0) {
                    System.out.println(
                            "Invalid amount. Keeping the previous amount."
                    );
                } else {
                    expense.setAmount(newAmount);
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid amount. Keeping the previous amount."
                );
            }
        }

        // Update the category only if a new value is provided.
        System.out.print("New category (" + expense.getCategory() + "): ");
        String newCategory = sc.nextLine().trim();

        if (!newCategory.isEmpty()) {
            expense.setCategory(newCategory);
        }

        // Update the description only if a new value is provided.
        System.out.print(
                "New description (" + expense.getDescription() + "): "
        );
        String newDescription = sc.nextLine().trim();

        if (!newDescription.isEmpty()) {
            expense.setDescription(newDescription);
        }

        // Save the edited expense list to the file.
        ExpenseFileManager.saveExpenses(expenses);

        System.out.println("Expense updated successfully!");
    }
    // Displays expenses matching the selected category.

    static void filterByCategory(Scanner sc, ArrayList<Expense> expenses) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses available to filter by.");
            return;
        }
        System.out.println("Enter category to search: ");
        String searchCategory = sc.nextLine().trim();

        boolean found = false;

        // check every expense for matching category
        for (Expense expense : expenses) {
            if (expense.getCategory()
                    .equalsIgnoreCase(searchCategory)) {
                System.out.println("Amount: " + expense.getAmount());
                System.out.println("Category: " + expense.getCategory());
                System.out.println("Description: " + expense.getDescription());
                System.out.println("Date: " + expense.getDate());
                System.out.println("---------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found in this category.");
        }

    }
}
