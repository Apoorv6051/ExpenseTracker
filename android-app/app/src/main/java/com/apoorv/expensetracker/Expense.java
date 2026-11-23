
package com.apoorv.expensetracker;

// This class represents a single expense
public class Expense {

    // Variables to store expense information
    private double amount;
    private String category;
    private String description;
    private String date;

    // Constructor to initialize an expense object
    public Expense(double amount, String category,
                   String description, String date) {

        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    // Return the expense amount
    public double getAmount() {
        return amount;
    }

    // Return the expense category
    public String getCategory() {
        return category;
    }

    // Return the expense description
    public String getDescription() {
        return description;
    }

    // Return the expense date
    public String getDate() {
        return date;
    }
}
