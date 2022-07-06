import java.util.Scanner;
import java.text.DecimalFormat;

public class Account_Info {
    private int accountNumber;
    private int pinNumber;
    private double balance;

    Scanner scan = new Scanner(System.in);
    DecimalFormat decimalFormat = new DecimalFormat("'$'####,##,##0.00");   // Craete a number format

    public void setAccountNumber(int accountNumber) {  // Set Account Number
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {   // Return Account number
        return this.accountNumber;
    }

    public void setPinNumber(int pinNumber) {   /// set Pin number
        this.pinNumber = pinNumber;
    }

    public int getPinNumber() {   // return pin Number
        return this.pinNumber;
    }

    public double getBalance() {   // Return net present balance
        return this.balance;
    }

    public double withdraw(double amount) {   // Withdraw a balance
        balance = balance - amount;
        return balance;
    }

    public double diposit(double amount) {  // Diposit a money
        balance += amount;
        return balance;
    }

    public void checkWithdrawable() {   // Check a balance withdrawable or not!
        System.out.println("\nEnter amount to withdraw : ");
        double amount = scan.nextDouble();
        if((amount - balance) >= 0) {
            System.out.println("\nNew Account Balance : " + decimalFormat.format(withdraw(amount)));
        }
        else {
            System.out.println("\nInsufficient Balance.");
        }
    }

    public void dipositMoney() {   // diposit a positive money
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
