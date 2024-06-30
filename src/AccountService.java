import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private static List<Account> bankAccounts = new ArrayList<>();
    private Account currentAccount;

    public void addNewAccount(int pinCode) {

        if (pinCode > 999 && pinCode < 99999999) {
            Account newAccount = new Account(pinCode);
            bankAccounts.add(newAccount);

            System.out.println("Счет создан! Номер счета:" + newAccount.getAccountNumber() +
                    ", Пин-код:" + newAccount.getPinCode() + ", Баланс:" + newAccount.getBalance());
        } else {
            System.out.println("Пин-код должен быть от 4 символов но не длинее 8");
        }
    }

    public Account findAccountByNumber(int accountNumber) {
        for (Account account : bankAccounts) {
            if (account.getAccountNumber() == accountNumber) {
                currentAccount = account;
                return account;
            }
        }
        currentAccount = null;
        return null;
    }

    public boolean checkPinCode(int pinCode) {
        if (currentAccount.getPinCode() == pinCode && currentAccount != null) {
            return true;
        }
        System.out.println("Пароль не соответствует.");
        return false;
    }

    public void deleteAccount(int pinCode) {
        if (checkPinCode(pinCode) && currentAccount != null) {
            currentAccount = null;
            System.out.println("Счет удален.");
        } else {
            System.out.println("Пин-код неверен");
        }

    }

    public void withdraw(double amount) {
        if (currentAccount.withdraw(amount) && currentAccount != null) {
            System.out.println("С вашего счета была снята " + amount);
        } else {
            System.out.println("На счету недостаточно средств");
        }

    }

    public void deposit(double amount) {
        if (currentAccount != null) {
            currentAccount.deposit(amount);
        }
    }

    public void displayBalance() {
        System.out.println("На вашем счету: " + currentAccount.getBalance());
    }

    public void accountStatement() {
        System.out.println("Персональный номер аккаунта -- " + currentAccount.getAccountNumber() + "\n" +
                "Баланс на текущей момент -- " + currentAccount.getBalance() + "\n" +
                "Ваш пин-код (просим его никому не сообщать) -- " + currentAccount.getPinCode());

    }
}
