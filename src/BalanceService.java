public class BalanceService extends Account{
    private double balance = getBalance();

    public BalanceService(int pinCode) {
        super(pinCode);
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
