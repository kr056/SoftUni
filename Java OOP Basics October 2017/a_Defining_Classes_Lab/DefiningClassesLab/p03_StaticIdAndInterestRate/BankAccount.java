package DefiningClassesLab.p03_StaticIdAndInterestRate;

public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;
    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountsCount;
    private int id;
    private double balance;

    BankAccount() {
        this.id = ++bankAccountsCount;
    }

    static void setInterestRate(double interest) {
        rate = interest;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    double getInterest(int years) {
        return this.balance * rate * years;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
