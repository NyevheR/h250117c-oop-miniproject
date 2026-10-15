public abstract class Account {//abstract class
    protected String accountNumber;//protected account number
    protected double balance;//protected balance

    public Account(String accountNumber, double balance) {//constructor
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Concrete: shared by all account types
    public void deposit(double amount) {
        if (amount <= 0) {//rejects non positive amoubts
            System.out.println("[" + accountNumber + "] Deposit rejected: amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("[%s] Deposited %.2f. New balance: %.2f%n", accountNumber, amount, balance);
    }

    // Concrete: shared by all account types
    public double getBalance() {
        return balance;
    }

    // Abstract: each account type decides its own rules
    public abstract void withdraw(double amount);

    public abstract void endOfMonth();//end of month hook method
}