
package com.apoorv.expensetracker;

// Import ArrayList to store multiple expense objects
import java.util.ArrayList;

// This class manages temporary expense storage
public class ExpenseStorage {

    // Shared ArrayList to store all expense objects
    private static final ArrayList<Expense> expenses = new ArrayList<>();

    // Add a new expense to the list
    public static void addExpense(Expense expense) {
        expenses.add(expense);
    }

    // Return all stored expenses
    public static ArrayList<Expense> getExpenses() {
        return expenses;
    }
}
