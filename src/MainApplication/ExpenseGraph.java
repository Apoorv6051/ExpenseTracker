
package MainApplication;

import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class ExpenseGraph {

    // Displays every recorded expense as a separate bar.
    public static void showIndividualExpenses(
            ArrayList<Expense> expenses) {

        // Step 1: Check whether expenses are available.
        if (expenses.isEmpty()) {
            System.out.println("No expenses available to display.");
            return;
        }

        // Step 2: Create a dataset to hold graph values.
        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        // Step 3: Add each expense to the dataset.
        int expenseNumber = 1;

        for (Expense expense : expenses) {

            // Use a short label so more of each expense name is visible.
            String label = "#" + expenseNumber + " "
                    + expense.getDescription();

            dataset.addValue(
                    expense.getAmount(),
                    "Expenses",
                    label
            );

            expenseNumber++;
        }

        // Step 4: Create the bar chart.
        JFreeChart chart = ChartFactory.createBarChart(
                "Individual Expenses",  // Chart title
                "Expense Description",  // Horizontal axis
                "Amount (₹)",           // Vertical axis
                dataset                 // Graph data
        );

        // Step 5: Put the chart inside a panel.
        // Create a larger graph area for the expense labels.
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(1000, 600));

        // Step 6: Create a window to display the graph.
        JFrame frame =
                new JFrame("Expense Tracker - Individual Expenses");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
