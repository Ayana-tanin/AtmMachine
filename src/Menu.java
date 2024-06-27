import java.util.Scanner;


public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private AccountService accountService = new AccountService();

    public void start() {
        while (true) {
            System.out.println("Добро пожаловать в Банкомат!\n" + "1. Войти в систему\n" + "2. Создать новый аккаунт\n" + "3. Выход");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    System.out.println("Спасибо за использование Банкомата.");
                    break;
                default:
                    System.out.println("Введен некорректный выбор");
            }
        }
    }

    public void login() {
        System.out.print("Введите номер счета: ");
        int accountNumber = scanner.nextInt();
        Account account = accountService.findAccountByNumber(accountNumber);

        if (account != null) {
            for (int i = 0; i < 4; i++) {
                System.out.print("Введите пароль:");
                int pinCode = scanner.nextInt();

                if (accountService.checkPinCode(pinCode)) {
                    menuOptions();
                } else {
                    System.out.println("Не правельный пароль. Осталось " + i + " попыток.");
                }
            }
        }
    }

    private void menuOptions() {
        int menuNumber;
        displayMenu();
        while (true) {
            menuNumber = scanner.nextInt();
            switch (menuNumber) {
                case 0:
                    displayMenu();
                    break;
                case 1:
                    accountService.displayBalance();
                    break;
                case 2:
                    System.out.print("Введите сумму для пополнения: ");
                    double depositAmount = scanner.nextDouble();
                    accountService.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Введите сумму для снятия: ");
                    double withdrawAmount = scanner.nextDouble();
                    accountService.withdraw(withdrawAmount);
                    break;
                case 4:
                    accountService.accountStatement();
                    break;
                case 5:
                    System.out.println("Для потдверждения удаления счета введите пароль");
                    int pinCode = scanner.nextInt();
                    accountService.deleteAccount(pinCode);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Такой опции нет.");
                    break;
            }
        }
    }

    public void displayMenu() {
        System.out.println("Меню возможностей Банкомата! \n" + "0. Показать меню возможностей заново \n" + "1. Проверить доступный баланс. \n" + "2. Пополнить счет \n" + "3. Снять деньги \n" + "4. Выписка с информацией о пользователе \n" + "5. Удалить счет \n" + "6. Выход");

    }

    private void createAccount() {
        System.out.println("Для создания багковского счета необходимо придумать пин-код, " + "минимально 4 символа, максимально 8.  Номер банковского аккаунта выдается автоматически. \n" + "Введите пин-код и запомните его!");
        int pinCode = scanner.nextInt();
        accountService.addNewAccount(pinCode);

    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.start();
    }
}

