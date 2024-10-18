public class Account {
    final String name;
    private double balance;

    public Account(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public void addMoney(double amount){
        this.balance += amount;
    }

    public void takeMoney(double amount){
        this.balance -= amount;
    }

}
