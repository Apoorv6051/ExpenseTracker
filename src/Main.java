import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Expense> expenses = new ArrayList<>();

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Show Total");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();

                System.out.print("Enter category: ");
                String category = sc.next();

                System.out.print("Enter description: ");
                String description = sc.next();

                expenses.add(new Expense(
                        amount,
                        category,
                        description,
                        LocalDate.now()
                ));

                System.out.println("Expense added successfully!");

            } else if (choice == 2) {

                System.out.println("\nYour Expenses:");

                for (Expense expense : expenses) {

                    System.out.println("Amount: " + expense.getAmount());
                    System.out.println("Category: " + expense.getCategory());
                    System.out.println("Description: " + expense.getDescription());
                    System.out.println("Date: " + expense.getDate());
                    System.out.println("---------------------------");
                }

            } else if (choice == 3) {

                double totalExpense = 0.0;

                for (Expense expense : expenses) {
                    totalExpense += expense.getAmount();
                }

                System.out.println("Total Expenses: " + totalExpense);

            } else if (choice == 4) {

                System.out.println("Thank you for using Expense Tracker!");

            } else {

                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}