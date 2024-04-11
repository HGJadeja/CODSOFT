import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class task3_ATM_Interface {
    static Scanner sc = new Scanner(System.in);
    static Bank_Account b = new Bank_Account();

    public static void main(String[] args) {
        task3_ATM_Interface atm = new task3_ATM_Interface();
        
        System.out.println("This is ATM Interface");
        System.out.println("---------------------------");
        System.out.println("---------------------------");

        b.getAccountDetails();

        while(true)
        {
        System.out.println("");
        System.out.println("1.Withdraw Amount \n2.Deposit Amount \n3.Check Balance \n4.Exit");
        System.out.print("\nEnter Option:");
        int op = sc.nextInt();
        

        switch (op) {
                case 1:
                    System.out.print("\nEnter amount to withdraw:");
                    double amount = sc.nextDouble();
                    atm.Withdraw(amount);
                    break;
    
                case 2: 
                    System.out.print("\nEnter amount to deposit:");
                    double dep_amt = sc.nextDouble();
                    atm.Deposit(dep_amt);
                    break;
    
                case 3:
                    atm.checkBalance();
                    break;
    
                case 4:
                    System.out.println("Thank you for visiting this ATM_Interface...!!!");
                    System.exit(0);
            
                default:System.out.println("Please enter valid option");
            } 
            b.saveBalance();
        }
        
    }

    public double Withdraw(double amount){
        if(amount>b.balance){
            System.out.println("Insufficient entered amount.Please enter valid amount to withdraw.");
            System.exit(0);
        }
        else {
            b.balance = b.balance - amount;
            System.out.println("Available Balance: "+b.balance);
        }
        return amount;
    }

    public double Deposit(double dep_amt){
        if(dep_amt>50000){
            System.out.println("Deposit limit exceeded.Maximum deposit amount allowed:30000");
            System.exit(0);
        }
        else {
            b.balance += dep_amt;
            System.out.println("Successfully amount deposited to account");
            System.out.println("Current Balance: "+b.balance);
        }
        return dep_amt;
    }

    public void checkBalance(){
        System.out.println("Your current Balance: "+b.balance);
    }

}

class Bank_Account{

    void saveBalance(){
        try (PrintWriter writer = new PrintWriter("balance.txt")){
            writer.println(balance);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    double getSavedBalance(){
        double savedBalance = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader("balance.txt"))) {
            savedBalance = Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savedBalance;
    }

    int account_no=1234;
    String cust_name=new String("Hiraliba");
    String acc_type=new String("Savings");
    double balance = getSavedBalance();

    void getAccountDetails(){
        System.out.println("\nAccount No.: "+account_no);
        System.out.println("Customer Name: "+cust_name);
        System.out.println("Account-Type: "+acc_type);
    }

    
}


