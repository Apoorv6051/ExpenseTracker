
package MainApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseFileManager {

    // File where all expenses will be stored.
    private static final Path FILE_PATH = Path.of("expenses.txt");

    /*
     * Converts the expenses list into text and saves
     * the complete list to expenses.txt.
     */
    public static void saveExpenses(ArrayList<Expense> expenses) {

        // Build the complete file content.
        StringBuilder data = new StringBuilder();

        // Convert each Expense object into one comma-separated line.
        for (Expense expense : expenses) {
            String line =
                    expense.getAmount() + ","
                            + expense.getCategory() + ","
                            + expense.getDescription() + ","
                            + expense.getDate();

            // Put each expense on a separate line.
            data.append(line).append("\n");
        }

        try {
            // Replace the file contents with the complete updated list.
            Files.writeString(FILE_PATH, data.toString());
            System.out.println("Expenses saved successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /*
     * Reads saved expenses and reconstructs Expense objects.
     */
    public static ArrayList<Expense> loadExpenses() {

        // This list will contain all loaded expenses.
        ArrayList<Expense> expenses = new ArrayList<>();

        // A new user may not have an expenses file yet.
        if (!Files.exists(FILE_PATH)) {
            return expenses;
        }

        try {
            // Read every line from expenses.txt.
            List<String> lines = Files.readAllLines(FILE_PATH);

            for (String line : lines) {

                // Separate the four comma-separated fields.
                String[] parts = line.split(",", -1);

                // Skip records that do not contain four fields.
                if (parts.length != 4) {
                    System.out.println("Skipping invalid record: " + line);
                    continue;
                }

                // Convert the saved text into the correct data types.
                double amount = Double.parseDouble(parts[0]);
                String category = parts[1];
                String description = parts[2];
                LocalDate date = LocalDate.parse(parts[3]);

                // Reconstruct the Expense object.
                Expense expense = new Expense(
                        amount,
                        category,
                        description,
                        date
                );

                // Add the reconstructed object to the list.
                expenses.add(expense);
            }

            System.out.println("Loaded " + expenses.size() + " expenses.");

        } catch (IOException | IllegalArgumentException e) {
            // Handle file-reading or invalid-data errors.
            System.out.println("Error loading expenses: " + e.getMessage());
        }

        // Return the list to Main.java.
        return expenses;
    }
}
