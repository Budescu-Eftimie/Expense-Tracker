public class Money {
    private int euros;
    private int cents;
    private double balance;

    public Money(String amount) {
        if (isValidMoney(amount)) {
            int[] units = getUnits(amount);
            this.euros = units[0];
            this.cents = units[1];
        } else {
            throw new IllegalArgumentException("Invalid amount format. Please use the format: €€.¢¢ (e.g., €128.44)");
        }


    }

    // Checks if the string can be converted to a valid amount of money
    public boolean isValidMoney(String moneyString) {
        String money = moneyString.replace(",", "."); // Replace commas with dots
        try {
            double value = Double.parseDouble(money); // Parse the string to a double to validate
            String[] parts = money.split("\\.");
            if (parts.length == 2 && parts[1].length() > 2) { // Check if there are more than 2 decimal places
                return false; // Invalid if more than 2 decimal places (cents)
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public int[] getUnits(String money) {
        int[] units = new int[2];

        money = money.replace(",", ".");
        String[] stringUnits = money.split("\\.");
        int euros = Integer.parseInt(stringUnits[0]);
        int cents = 0;

        try {
            cents = Integer.parseInt(stringUnits[1]);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //int cents = Integer.parseInt(stringUnits[1]);


        units[0] = euros;
        units[1] = cents;

        return units;
    }

    public int getEuros() {
        return this.euros;
    }

    public int getCents() {
        return this.cents;
    }

    @Override
    public String toString() {
        return "€" + this.euros + "." + String.format("%02d", this.cents) + "¢";
    }

}
