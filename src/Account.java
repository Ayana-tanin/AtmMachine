public class Account {
    private static int nextAccountNumber = 1000;

    private int accountNumber;
    private int pinCode;
    private double balance;

    public Account(int pinCode){
        this.accountNumber = nextAccountNumber++;
        this.pinCode = pinCode;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = amount + balance;
            System.out.println("Баланс обновлен сейчас сумма на счету равна " + balance);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Текущий баланс: " + balance);
            return true;
        }
        return false;
    }

}