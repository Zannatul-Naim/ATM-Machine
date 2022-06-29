import java.util.Scanner;
import java.text.DecimalFormat;

public class Account_Info {
    private int accountNumber;
    private int pinNumber;
    private double balance;

    Scanner scan = new Scanner(System.in);
    DecimalFormat decimalFormat = new DecimalFormat("'$'####,##,##0.00");

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public int getPinNumber() {
        return this.pinNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public double withdraw(double amount) {
        balance = balance - amount;
        return balance;
    }

    public double diposit(double amount) {
        balance += amount;
        return balance;
    }

    public void checkWithdrawable() {
        System.out.println("\nEnter amount to withdraw : ");
        double amount = scan.nextDouble();
        if((amount - balance) >= 0) {
            System.out.println("\nNew Account Balance : " + decimalFormat.format(withdraw(amount)));
        }
        else {
            System.out.println("\nInsufficient Balance.");
        }
    }

    public void dipositMoney() {
        System.out.println("\nAccount Balance : " + decimalFormat.format(getBalance()));
        System.out.println("\nEnter amount to diposit : ");
        double amount = scan.nextDouble();
        if(amount > 0) {
            System.out.println("\nNew Balance : " + diposit(amount));
        }
        else {
            System.out.println("\nAmount can't be negative.");
        }
    }
}
