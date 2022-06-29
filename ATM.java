import java.util.*;
import java.io.*;

public class ATM {
    public static void main(String[] args) throws IOException{
        System.out.println("=================================================");
        System.out.println("                     ATM                         ");
        System.out.println("=================================================");

        System.out.println("Enter your choice : ");
        System.out.println("Enter (1) New user Register");
        System.out.println("Enter (2) Log In");

        Menu menu = new Menu();

        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        
        switch(choice) {
            case 1:
                menu.register();
                break;
            case 2:
                menu.login();
                break;
            default :
                System.out.println("Invalid Choice");
        }
        scan.close();
    }
}
