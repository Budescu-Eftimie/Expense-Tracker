import java.time.LocalDate;

public class Expense {
    private String name;
    private LocalDate date;
    private Money amount;

    public Expense(String name, LocalDate date, Money amount){
        this.name = name;
        this.date = date;
        this.amount = amount;
    }

}
