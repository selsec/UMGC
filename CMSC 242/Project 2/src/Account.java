/*
 * This class defines the behavior of account objects and contains a constructor as well as getters and setters
 * There is also a counter which determines the number of transactions and adds a surcharge if the number of
 * transactions exceeds 4.
 * Author: Steven Thaw
 * Date: 23 Oct 19
 * CMIS 242 Intermediate Programming Project 2
 */

public class Account {
    //define class variables which contain the balance and a transaction counter

    private double balance;
    private int transactionCount;

    public Account() {
        this.balance = 0;
        this.transactionCount = 0;
    }
    //getter for balance
    public double getBalance() {
        return balance;
    }
    //deposit method
    public void makeDeposit(double amount) {
        balance = balance + amount;
        transactionCount = transactionCount + 1;
    }
    //withdrawl method
    public void makeWithdrawl(double amount) {
        balance = balance - amount;
        transactionCount = transactionCount + 1;
    }
    //transaction count method
    public int checkTransaction() {
        return transactionCount;
    }
}
