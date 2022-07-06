import java.util.Scanner;
import java.io.*;

public class Menu extends Account_Info {
    String accNo, pinNo, userName;
    Scanner scan = new Scanner(System.in);

public void view() {
    System.out.println("\n============ Welcome to ATM ============\n");
    System.out.println("\nPress 1 for Check Balance : ");
    System.out.println("\nPress 2 for Withdraw Money : ");
    System.out.println("\nPress 3 for Diposit : ");
    System.out.println("\nPress 4 for Exit.");
    System.out.print("Enter your Choice : ");
    int choice = scan.nextInt();
    System.out.println("\n");
    switch(choice) {
        case 1:
            System.out.println("Present Balance : " + decimalFormat.format(getBalance()));
            break;
        case 2:
            checkWithdrawable();
            break;
        case 3:
            dipositMoney();
            break;
        case 4:
            System.out.println("Thank You!");
            System.exit(0);
            break;
        default :
            System.out.println("Invalid Choice");
    }
}
 
public void register() throws IOException {   // Registration Page
    System.out.println("======== Register New account ========");

    System.out.println("\nWelcome to ATM\n");

    System.out.println("\nEnter your UserName : ");
    userName = scan.nextLine();

    System.out.println("Enter a 10 digit Account Number : ");
    accNo = scan.nextLine();

    System.out.println("\nSet Pin Number : ");
    pinNo = scan.nextLine();

    String accInfo = userName + " " + accNo + " " + pinNo;

    BufferedWriter writer = new BufferedWriter(new FileWriter("./info.txt", true));
    writer.append(accInfo);
    writer.newLine();
    writer.close();

    System.out.println("\nHello! " + userName + " Successfully Registered!");
    login();
}

public void login() throws IOException {   // Login page
    System.out.println("============ Log In information ==========");
    System.out.println("\nWelcome to ATM");
    
    System.out.println("\nEnter your 10 digit Account Number : ");
    accNo = scan.nextLine();
    setAccountNumber(Integer.valueOf(accNo));

    System.out.println("\nEnter your Pin Number : ");
    pinNo = scan.nextLine();
    setPinNumber(Integer.valueOf(pinNo));

    FileReader reader = new FileReader("./info.txt");

    BufferedReader bufferedReader = new BufferedReader(reader);
    
    String info;
    Boolean flag = false;

    while((info = bufferedReader.readLine()) != null) {
        String[] line = info.split("\\s");

        if(accNo.equals(line[1]) && pinNo.equals(line[2])) {
            System.out.println("\n=== Log in Successfull ===\n");
            flag = true;
            while(true) {
                view();
            }
        }
    }

    if(!flag) {
        System.out.println("\nInvalid information.\n\nEnter 1 to move Register page\n\nEnter 2 to move login page");

        int choice = scan.nextInt();
        switch(choice) {
            case 1:
                register();   // Register for a new Account
                break;
            case 2:
                login();   // Login with acc No and pin No.
                break;
            default :
                System.out.println("\nInvalid Input\n");
        }
    }
    bufferedReader.close();   // Closing the Buffer Reader
}

}
