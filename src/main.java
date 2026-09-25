import java.time.LocalDate;

public class main {
    public static void main(String[] args) {

        Expence expense = new Expence(
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

