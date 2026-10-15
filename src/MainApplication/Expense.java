
package MainApplication;

import java.time.LocalDate;

public class Expense {

    // Store the details of an expense.
    private double amount;
    private String category;
    private String description;
    private LocalDate date;

    // Initialize a new expense.
    public Expense(double amount, String category,
                   String description, LocalDate date) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    // Getters allow other classes to read expense details.
    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    // Setters allow existing expense details to be updated.
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
