package MainApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create a Scanner object to take input from the user.
        Scanner sc = new Scanner(System.in);

        // ArrayList is used to store multiple MainApplication.Expense objects.
        //
        // Each time the user adds an expense, a new MainApplication.Expense object
        // will be created and stored inside this ArrayList.
        ArrayList<Expense> expenses = new ArrayList<>();

        // Variable to store the user's menu choice.
        //
        // We start with 0 so that the while loop can begin.
        int choice = 0;

        // Keep showing the menu until the user chooses option 4.
        while (choice != 4) {

            // ==============================
            // DISPLAY MENU
            // ==============================

            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add MainApplication.Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Show Total");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            try {

                // Read the user's menu choice.
                // nextInt() expects the user to enter an integer.
                // For example: 1, 2, 3 or 4.
                choice = sc.nextInt();

            } catch (InputMismatchException e) {

                // This exception occurs when the user enters
                // something that is not an integer.
                //
                // Example:
                // abc
                // hello
                // xyz
                System.out.println("Please enter a valid choice.");

                // Remove the invalid input from the Scanner buffer.
                //
                // Otherwise, nextInt() would read the same invalid
                // input again and cause an infinite loop.
                sc.nextLine();

                // Set choice to 0 so that none of the valid
                // menu options are executed.
                choice = 0;
            }


            // ==============================
            // OPTION 1: ADD EXPENSE
            // ==============================

            if (choice == 1) {

                // Call the addExpense() method.
                //
                // We pass:
                //
                // 1. Scanner object
                //    -> used to take input from the user.
                //
                // 2. expenses ArrayList
                //    -> used to store the new MainApplication.Expense object.
                addExpense(sc, expenses);


                // ==============================
                // OPTION 2: VIEW EXPENSES
                // ==============================

            } else if (choice == 2) {

                // Call the viewExpenses() method.
                //
                // We pass the expenses ArrayList because
                // this method needs to read and display
                // the expenses stored inside it.
                viewExpenses(expenses);


                // ==============================
                // OPTION 3: SHOW TOTAL
                // ==============================

            } else if (choice == 3) {

                // Call the showTotal() method.
                //
                // This method is responsible for calculating
                // and displaying the total amount of expenses.
                showTotal(expenses);


                // ==============================
                // OPTION 4: EXIT
                // ==============================

            } else if (choice == 4) {

                // Display a message before exiting the program.
                System.out.println(
                        "Thank you for using MainApplication.Expense Tracker!"
                );


                // ==============================
                // INVALID MENU CHOICE
                // ==============================

            } else {

                // This executes when the user enters
                // a number that is not between 1 and 4.
                System.out.println(
                        "Invalid choice. Please try again."
                );
            }
        }

        // Close the Scanner when the program finishes.
        sc.close();
    }


    // ==========================================================
    // METHOD: addExpense()
    // ==========================================================
    //
    // This method is responsible only for adding
    // a new expense.
    //
    // Scanner sc:
    // Used to take input from the user.
    //
    // ArrayList<MainApplication.Expense> expenses:
    // Used to store the newly created MainApplication.Expense object.
    //
    static void addExpense(
            Scanner sc,
            ArrayList<Expense> expenses
    ) {

        // Variables required to create an MainApplication.Expense object.
        double amount;
        String category;
        String description;

        // Initially, we assume that the amount is not valid.
        //
        // The loop will continue until the user
        // enters a valid positive amount.
        boolean validAmount = false;


        // Keep asking for the amount until
        // the user enters a valid positive number.
        while (!validAmount) {

            try {

                System.out.print("Enter amount: ");

                // Read the amount entered by the user.
                //
                // nextDouble() expects a numeric value.
                amount = sc.nextDouble();


                // ==========================================
                // VALIDATE AMOUNT
                // ==========================================

                // Amount cannot be zero or negative.
                //
                // This is a business-rule validation.
                //
                // We use if-else instead of throwing an
                // exception because zero/negative numbers
                // are valid numbers, but they are not valid
                // expense amounts.
                if (amount <= 0) {

                    System.out.println(
                            "Please enter a valid amount."
                    );

                } else {

                    // The amount is valid,
                    // so we can stop the validation loop.
                    validAmount = true;


                    // ==========================================
                    // CONSUME LEFTOVER NEWLINE
                    // ==========================================

                    // Consume the leftover Enter/newline
                    // after nextDouble().
                    //
                    // Without this, the next nextLine()
                    // would read the leftover newline and
                    // return an empty string.
                    sc.nextLine();


                    // ==========================================
                    // TAKE CATEGORY
                    // ==========================================

                    // Take the category from the user.
                    //
                    // nextLine() allows the user to enter
                    // spaces if required.
                    System.out.print("Enter category: ");
                    category = sc.nextLine();


                    // ==========================================
                    // TAKE DESCRIPTION
                    // ==========================================

                    // Take the description from the user.
                    //
                    // nextLine() allows descriptions such as:
                    //
                    // "Lunch with friends"
                    // "Movie with family"
                    // "Bought new shoes"
                    System.out.print("Enter description: ");
                    description = sc.nextLine();


                    // ==========================================
                    // CREATE EXPENSE OBJECT
                    // ==========================================

                    // Create a new MainApplication.Expense object using
                    // the information entered by the user.
                    //
                    // LocalDate.now() automatically stores
                    // today's date.
                    expenses.add(new Expense(
                            amount,
                            category,
                            description,
                            LocalDate.now()
                    ));


                    // Inform the user that the expense
                    // has been successfully added.
                    System.out.println(
                            "MainApplication.Expense added successfully!"
                    );
                }


            } catch (InputMismatchException e) {

                // This exception occurs when the user enters
                // something that is not a valid number.
                //
                // Example:
                //
                // abc
                // hello
                // xyz
                //
                System.out.println(
                        "Invalid input. Please enter a valid number."
                );


                // Remove the invalid input from the Scanner buffer.
                //
                // Otherwise, the while loop would keep reading
                // the same invalid input again and again.
                sc.nextLine();
            }
        }
    }


    // ==========================================================
    // METHOD: viewExpenses()
    // ==========================================================
    //
    // This method is responsible only for displaying
    // all the expenses stored inside the ArrayList.
    //
    // We only need the ArrayList here because
    // we are not taking any input from the user.
    //
    // ArrayList<MainApplication.Expense> expenses:
    // Contains all the MainApplication.Expense objects that have
    // been added by the user.
    //
    static void viewExpenses(ArrayList<Expense> expenses) {

        // Display the heading before showing expenses.
        System.out.println("\nYour Expenses:");


        // ==========================================
        // CHECK IF THERE ARE NO EXPENSES
        // ==========================================

        // isEmpty() returns true if the ArrayList
        // does not contain any MainApplication.Expense objects.
        //
        // This prevents us from displaying an empty list.
        if (expenses.isEmpty()) {

            // Inform the user that there are currently
            // no expenses stored.
            System.out.println("No expenses found.");

        } else {

            // ==========================================
            // DISPLAY ALL EXPENSES
            // ==========================================

            // Enhanced for-loop is used to visit
            // every MainApplication.Expense object inside the ArrayList.
            //
            // "expense" represents one MainApplication.Expense object
            // at a time.
            for (Expense expense : expenses) {

                // Display the amount of the current expense.
                System.out.println(
                        "Amount: " + expense.getAmount()
                );

                // Display the category of the current expense.
                System.out.println(
                        "Category: " + expense.getCategory()
                );

                // Display the description of the current expense.
                System.out.println(
                        "Description: " + expense.getDescription()
                );

                // Display the date of the current expense.
                System.out.println(
                        "Date: " + expense.getDate()
                );

                // Separator between two expenses
                // to make the output easier to read.
                System.out.println("---------------------------");
            }
        }
    }


    // ==========================================================
    // METHOD: showTotal()
    // ==========================================================
    //
    // This method is responsible only for calculating
    // and displaying the total amount of all expenses.
    //
    // ArrayList<MainApplication.Expense> expenses:
    // Contains all the MainApplication.Expense objects whose amounts
    // need to be added together.
    //
    static void showTotal(ArrayList<Expense> expenses) {

        // Variable used to store the total amount
        // of all expenses.
        //
        // We start with 0 because initially
        // there are no expenses to add.
        double totalExpense = 0.0;


        // ==========================================
        // CALCULATE TOTAL
        // ==========================================

        // Enhanced for-loop visits every MainApplication.Expense object
        // stored inside the ArrayList.
        for (Expense expense : expenses) {

            // Get the amount of the current expense
            // using the getAmount() getter.
            //
            // Add that amount to totalExpense.
            totalExpense += expense.getAmount();
        }


        // ==========================================
        // DISPLAY TOTAL
        // ==========================================

        // Display the final total amount.
        System.out.println(
                "Total Expenses: " + totalExpense
        );
    }
}