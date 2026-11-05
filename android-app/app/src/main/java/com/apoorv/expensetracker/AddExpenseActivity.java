
package com.apoorv.expensetracker;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.DatePickerDialog;
import android.widget.Button;
import java.util.Calendar;
import android.widget.EditText;

public class AddExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display
        WindowCompat.enableEdgeToEdge(getWindow());

        // Load the Add Expense screen XML layout
        setContentView(R.layout.activity_add_expense);

        // Handle system bar padding using the ScrollView
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.scrollView), (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    // Apply padding to avoid overlapping system bars
                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        // -----------------------------------------
        // CATEGORY DROPDOWN FUNCTIONALITY
        // -----------------------------------------

        // Connect Spinner from XML to Java
        Spinner spCategory = findViewById(R.id.spCategory);

        // Create an array containing expense categories
        String[] categories = {
                "Food",
                "Travel",
                "Shopping",
                "Education",
                "Entertainment",
                "Other"
        };
        // Connect the Select Date button from XML to Java
        Button btnSelectDate = findViewById(R.id.btnSelectDate);

// Set today's date as the default date
        Calendar calendar = Calendar.getInstance();

        btnSelectDate.setOnClickListener(v -> {

            // Get the current date
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Open the Date Picker dialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    AddExpenseActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {

                        // Display the selected date on the button
                        String selectedDate = selectedDay + "/"
                                + (selectedMonth + 1) + "/"
                                + selectedYear;

                        btnSelectDate.setText(selectedDate);
                    },
                    year,
                    month,
                    day
            );

            // Display the dialog
            datePickerDialog.show();
        });

        // Create an ArrayAdapter to connect data with Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                categories
        );

        // Set the dropdown item appearance
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        // Attach the adapter to the Spinner
        spCategory.setAdapter(adapter);

    }
}
