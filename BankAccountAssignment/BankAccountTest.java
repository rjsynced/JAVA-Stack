import java.util.ArrayList;
public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount();
        BankAccount ba2 = new BankAccount("Judah", "01", 10, 50, 50);

        ba2.getName();
        ba2.getSavingsBalance();
        ba2.getCheckingBalance();
        System.out.println(ba2.getName() + "\n" + ba2.getCheckingBalance() + "\n" + ba2.getSavingsBalance());
        System.out.println("# of Active Accounts: " + BankAccount.getAccounts() + "\n" +
                            "Total Monayy: " + BankAccount.)
        ba2.deposit(50)
    }
}