
package com.apoorv.expensetracker;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

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
        // 1. CATEGORY DROPDOWN FUNCTIONALITY
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


        // -----------------------------------------
        // 2. DATE PICKER FUNCTIONALITY
        // -----------------------------------------

        // Connect the Select Date button from XML to Java
        Button btnSelectDate = findViewById(R.id.btnSelectDate);

        // Get today's date
        Calendar calendar = Calendar.getInstance();

        // Open Date Picker when the button is clicked
        btnSelectDate.setOnClickListener(v -> {

            // Get the current date
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Create Date Picker dialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    AddExpenseActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {

                        // Format the selected date
                        String selectedDate = selectedDay + "/"
                                + (selectedMonth + 1) + "/"
                                + selectedYear;

                        // Display selected date on the button
                        btnSelectDate.setText(selectedDate);
                    },
                    year,
                    month,
                    day
            );

            // Display the Date Picker
            // Prevent the user from selecting a future date
            datePickerDialog.getDatePicker().setMaxDate(
                    System.currentTimeMillis()
            );

            // Display the Date Picker
            datePickerDialog.show();
        });


        // -----------------------------------------
        // 3. CONNECT INPUT FIELDS
        // -----------------------------------------

        // Connect Amount EditText
        EditText etAmount = findViewById(R.id.etAmount);

        // Connect Description EditText
        EditText etDescription = findViewById(R.id.etDescription);

        // Connect Save Expense button
        Button btnSaveExpense = findViewById(R.id.btnSaveExpense);


        // -----------------------------------------
        // 4. SAVE EXPENSE BUTTON FUNCTIONALITY
        // -----------------------------------------

        // Execute this code when Save Expense is clicked
        btnSaveExpense.setOnClickListener(v -> {

            // Read the amount entered by the user
            String amountText = etAmount.getText().toString().trim();

            // Read the selected category
            String category = spCategory.getSelectedItem().toString();

            // Read the description entered by the user
            String description = etDescription.getText().toString().trim();

            // Read the selected date
            String date = btnSelectDate.getText().toString();

            // Check whether the amount is empty
            if (amountText.isEmpty()) {

                etAmount.setError("Please enter an amount");
                etAmount.requestFocus();

                return;
            }

            // Convert amount String into a numeric value
            double amount;

            try {
                amount = Double.parseDouble(amountText);

            } catch (NumberFormatException e) {

                etAmount.setError("Please enter a valid amount");
                etAmount.requestFocus();

                return;
            }

            // Check whether the amount is zero or negative
            if (!Double.isFinite(amount) || amount <= 0) {

                etAmount.setError("Amount must be greater than zero");
                etAmount.requestFocus();

                return;
            }

            // Check whether description is empty
            if (description.isEmpty()) {

                etDescription.setError("Please enter a description");
                etDescription.requestFocus();

                return;
            }

            // Check whether the user has selected a date
            if (date.equals("Select Date")) {

                Toast.makeText(
                        AddExpenseActivity.this,
                        "Please select a date",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Create an Expense object using the entered details
            Expense expense = new Expense(
                    amount,
                    category,
                    description,
                    date
            );

            // Add the Expense object to our shared ArrayList
            ExpenseStorage.addExpense(expense);

            // Show confirmation message
            Toast.makeText(
                    AddExpenseActivity.this,
                    "Expense saved successfully!",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }
}
