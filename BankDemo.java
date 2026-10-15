import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV001", 500.00, 100.00));
        accounts.add(new CurrentAccount("CUR001", 200.00, 300.00));
        accounts.add(new SavingsAccount("SAV002", 1000.00, 200.00));
        accounts.add(new CurrentAccount("CUR002", 50.00, 100.00));

        System.out.println("=== Withdrawals (polymorphic) ===");
        double[] amounts = {450.00, 400.00, 700.00, 200.00};
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);   // Account reference only, no casting
            acc.withdraw(amounts[i]);
        }

        System.out.println("\n=== End of month (polymorphic) ===");
        for (Account acc : accounts) {
            acc.endOfMonth();
        }

        System.out.println("\n=== Final balances ===");
        for (Account acc : accounts) {
            System.out.printf("%s -> %.2f%n", acc.accountNumber, acc.getBalance());
        }
    }
}