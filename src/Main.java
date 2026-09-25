import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Expence expense = new Expence( //creates one Expense object:
                250.0,
                "food",
                "luch",
                LocalDate.now()
        );
        System.out.println("Amount: " + expense.getAmount());
        System.out.println("Category: " + expense.getCategory());
        System.out.println("Description: " + expense.getDescription());
        System.out.println("Date: " + expense.getDate());

     }
   }

