import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Expense> expenses = new ArrayList<>(); // to store multiple expences

        expenses.add(new Expense(
                250.0,
                "Food",
                "Lunch",
                LocalDate.now()
        ));

        expenses.add(new Expense(
                500.0,
                "Travel",
                "Bus",
                LocalDate.now()
        ));

        expenses.add(new Expense(
                1000.0,
                "Shopping",
                "Shoes",
                LocalDate.now()
        ));

        Double totalExpense =0.0;
        for(Expense expense: expenses){
            totalExpense +=expense.getAmount();
        }
        System.out.println("Total Expenses: " + totalExpense);

//       for(Expense expense: expenses) {
//           System.out.println("Amount: " + expense.getAmount());
//           System.out.println("Category: " + expense.getCategory());
//           System.out.println("Description: " + expense.getDescription());
//           System.out.println("Date: " + expense.getDate());
//           System.out.println("-----------------------------------------");
//       }

     }
   }

