public class CurrentAccount extends Account {
    private final double overdraftLimit;
    private static final double MONTHLY_FEE = 10.00;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("[" + accountNumber + "] Withdrawal rejected: amount must be positive.");
            return;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.printf("[%s] Withdrawal of %.2f rejected: exceeds overdraft limit of %.2f.%n",
                    accountNumber, amount, overdraftLimit);
            return;
        }
        balance -= amount;
        System.out.printf("[%s] Withdrew %.2f. New balance: %.2f%s%n", accountNumber, amount, balance,
                balance < 0 ? " (in overdraft)" : "");
    }

    @Override
    public void endOfMonth() {
        balance -= MONTHLY_FEE;
        System.out.printf("[%s] Current month-end: maintenance fee of %.2f deducted. Balance: %.2f%n",
                accountNumber, MONTHLY_FEE, balance);
    }
}