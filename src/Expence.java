import java.time.LocalDate;
public class Expence {
            // these are the data belong to Expences
    private Double amount; //We don't want other parts of the program directly changing the
    private String category;      //We don't want other parts of the program directly changing the
    private String Description; //We don't want other parts of the program directly changing the
    private LocalDate date; //We don't want other parts of the program directly changing the

    public Expence(Double amount, String category, String Description , LocalDate date){  // this is constructor (It creates and initializes an Expense object.)

        this.amount = amount;
        this.category = category;
        this.Description = Description;
        this.date = date;

    }

    public Double getAmount() {  // this is Getter

        return amount;
        //They allow other classes to read the data safely.
    }
    public String getCategory() {
        return category;
        //They allow other classes to read the data safely.
    }
    public String getDescription() {
        return Description;
        //They allow other classes to read the data safely.
    }
    public LocalDate getDate() {
        return date;
        //They allow other classes to read the data safely.
    }
}
