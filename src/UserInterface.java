import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserInterface {

    final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        while (true) {
            printMenu();

            String userInput = scanner.nextLine();
            if (userInput.isEmpty()) {
                continue;
            }
            if (userInput.equals("q")) {
                break;
            }
            if (userInput.equals("1")) {
                expenseFlow();
            }

        }

    }

    private void printMenu() {
        System.out.println("Menu: ");
        System.out.println("1 - to add new expense; 2 - to add new income;");
        System.out.println("Type \"q\" to exit program.");
    }




    private void expenseFlow() {
        System.out.println("type q - to cancel \nWrite expense category (food, electricity..): ");
        String category = scanner.nextLine();
        if (category.equals("q")) {
            System.out.println("-----------");
            return;
        }

        Money money = promptValidMoneyInput();


        System.out.println(money.toString() + " -------------------");
        System.out.println("If today type enter otherwise type the date:");
        System.out.println("format dd.mm.yyyy");
        String dateString = scanner.nextLine();
        LocalDate today = LocalDate.now();
        if (!dateString.isEmpty()) {
            try {
                today = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format");
            }
        }

        Expense expense = new Expense(category, money, today);
    }







    private Money promptValidMoneyInput() {
        Money money = null;
        boolean validMoney = false;
        while (!validMoney) {
            try {
                System.out.println("Enter amount (format: €€.¢¢): ");
                String amount = scanner.nextLine();
                money = new Money(amount);
                validMoney = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");

            }
        }
        return money;
    }

}
