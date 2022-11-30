import java.util.ArrayList;
public class BankAccount {
    // attributes
    private String name;
    private String accountNumber;
    private double balance;
    private double checkingsBalance;
    private double savingsBalance;
    private static double numOfAccounts;
    private static double totalAccMoney;

    // constructor
    public BankAccount(){ // default values
        this.name = "somebody";
        this.accountNumber = "00";
        this.balance = 0;
        numOfAccounts++;
    }

    public BankAccount(String name, String accountNumber, double balance, double checkingsBalance, double savingsBalance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.checkingsBalance = checkingsBalance;
        this.savingsBalance = savingsBalance;
        numOfAccounts++;
        totalAccMoney += checkingsBalance + savingsBalance;
    }

    // getters

    public String getName(){
        return this.name;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getCheckingBalance() {
        return this.checkingsBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCheckingBalance(double newBalance) {
        totalAccMoney -= this.checkingsBalance;
        this.checkingsBalance = newBalance;
        totalAccMoney += newBalance;
    }

    public void setSavingsBalance(double newBalance) {
        totalAccMoney -= this.savingsBalance;
        this.savingsBalance = newBalance;
        totalAccMoney += newBalance;
    }

    // methods



    public void checkBalance(double balance){
        System.out.println("Current Balance: " + this.balance);
    }

    public void depositFunds(double deposit) {
        if (deposit < 0) {
            System.out.println("Deposit must be greater than 0");
        } else {
            this.balance += deposit;
            System.out.println("New Balance: " + this.balance);
        }
    }

    public void withdrawFunds(double withdraw) {
        if(withdraw > this.balance) {
            System.out.println("Insufficient Funds, " + this.balance + " is your current balance. Please try again");
        } else {
            this.balance -= withdraw;
            System.out.println("New Balance: " + this.balance);
        }
    }


}