package com.apoorv.expensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display
        WindowCompat.enableEdgeToEdge(getWindow());

        // Load the dashboard XML layout
        setContentView(R.layout.activity_main);

        // Handle system bar padding for the dashboard
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

        // ----------------------------------
        // ADD EXPENSE BUTTON
        // ----------------------------------

        // Connect the Add Expense button from XML
        Button btnAddExpense = findViewById(R.id.btnAddExpense);

        // Open AddExpenseActivity when clicked
        btnAddExpense.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    AddExpenseActivity.class
            );

            startActivity(intent);
        });


        // ----------------------------------
        // VIEW HISTORY BUTTON
        // ----------------------------------

        // Connect the View History button from XML
        Button btnViewHistory = findViewById(R.id.btnViewHistory);

        // Open ViewExpensesActivity when clicked
        btnViewHistory.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    ViewExpensesActivity.class
            );

            startActivity(intent);
        });

    }
}
