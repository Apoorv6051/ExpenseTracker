package com.apoorv.expensetracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Locale;

public class ViewExpensesActivity extends AppCompatActivity {

    // Declare views that we need to access
    private LinearLayout layoutExpenseList;
    private TextView tvTotalAmount;
    private TextView tvEmptyState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge screen display
        WindowCompat.enableEdgeToEdge(getWindow());

        // Connect the XML layout to this Activity
        setContentView(R.layout.activity_view_expenses);

        // Handle system bars and screen padding
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        // Connect XML views with Java
        layoutExpenseList = findViewById(R.id.layoutExpenseList);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        tvEmptyState = findViewById(R.id.tvEmptyState);

        // Back button functionality
        TextView btnHistoryBack = findViewById(R.id.btnHistoryBack);
        btnHistoryBack.setOnClickListener(v -> finish());

        // Load all saved expenses
        displayExpenses();
    }

    // Retrieve and display all expenses
    private void displayExpenses() {

        ArrayList<Expense> expenses = ExpenseStorage.getExpenses();

        // Clear previously displayed cards
        layoutExpenseList.removeAllViews();

        // Check whether the expense list is empty
        if (expenses.isEmpty()) {
            tvEmptyState.setVisibility(View.VISIBLE);
            tvTotalAmount.setText("₹0.00");
            return;
        } else {
            tvEmptyState.setVisibility(View.GONE);
        }

        // Variable to calculate total expenses
        double total = 0;

        // Create a LayoutInflater
        LayoutInflater inflater = LayoutInflater.from(this);

        // Loop through every expense
        for (Expense expense : expenses) {

            total += expense.getAmount();

            // Inflate one expense card from item_expense.xml
            View expenseView = inflater.inflate(
                    R.layout.item_expense,
                    layoutExpenseList,
                    false
            );

            // Connect TextViews from the expense card
            TextView tvDescription =
                    expenseView.findViewById(R.id.tvExpenseDescription);

            TextView tvCategory =
                    expenseView.findViewById(R.id.tvExpenseCategory);

            TextView tvDate =
                    expenseView.findViewById(R.id.tvExpenseDate);

            TextView tvAmount =
                    expenseView.findViewById(R.id.tvExpenseAmount);

            // IMPORTANT: Connect the ImageView from XML
            ImageView ivExpenseIcon =
                    expenseView.findViewById(R.id.ivExpenseIcon);

            // Set actual expense information
            tvDescription.setText(expense.getDescription());
            tvCategory.setText(expense.getCategory());
            tvDate.setText(expense.getDate());

            // IMPORTANT: Set the category-specific icon
            ivExpenseIcon.setImageResource(
                    getCategoryIcon(expense.getCategory())
            );

            // Format amount in Indian Rupees
            tvAmount.setText(
                    String.format(
                            Locale.US,
                            "₹%.2f",
                            expense.getAmount()
                    )
            );

            // Add the completed card to the expense list
            layoutExpenseList.addView(expenseView);
        }

        // Display total expenses
        tvTotalAmount.setText(
                String.format(Locale.US, "₹%.2f", total)
        );
    }

    // Return the drawable resource according to expense category
    private int getCategoryIcon(String category) {

        switch (category.trim().toLowerCase(Locale.ROOT)) {

            case "food":
                return R.drawable.ic_food;

            case "travel":
                return R.drawable.ic_travel;

            case "shopping":
                return R.drawable.ic_shopping;

            case "education":
                return R.drawable.ic_education;

            case "entertainment":
                return R.drawable.ic_movie;

            default:
                return R.drawable.ic_category;
        }
    }
}
