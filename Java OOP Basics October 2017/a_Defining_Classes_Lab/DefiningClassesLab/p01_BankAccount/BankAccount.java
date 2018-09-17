package DefiningClassesLab.p01_BankAccount;

public class BankAccount {
    private int id;
    double balance;

    void setId(int id) {
        this.id = id;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }

}
