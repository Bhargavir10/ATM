/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;
class Bankaccount{
    private double balance;
    public Bankaccount(double initialBalance){
        balance=initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposit of $" + amount + "sucessful.");
        }
        else{
           System.out.println("Invalid deposit amount."); 
        }
    }
    public boolean withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Withdrawl of $ "+amount+" successful.");
            return true;
        }
        else{
            System.out.println("Insufficient balance.");
            return false;
        }
    }
}
class ATM{
    private Bankaccount userAccount;
    public ATM(Bankaccount account){
        userAccount=account;
    }
    public void displayMenu(){
        System.out.println("==================================");
        System.out.println("Welcome!\nPlease select the transaction.");
        System.out.println("1.Check Balance");
        System.out.println("2.Deposit");
        System.out.println("3.Withdrawl");
        System.out.println("4.Exit");
}
public void run(){
    Scanner scanner = new Scanner(System.in);
    int choice;
    do{
        displayMenu();
        System.out.println("Enter your choice:");
        choice = scanner.nextInt();
        switch(choice){
        case 1:
            checkBalance();break;
        case 2:
            deposit(scanner);break;
        case 3:
            withdraw(scanner);break;
        case 4:
            System.out.println("Thankyou for using the ATM");break;
        default:
            System.out.println("Invalid choice.Please try again.");
    }
    }while(choice!=4);
    scanner.close();
}
public void checkBalance(){
    System.out.println("Your Balance is:$ "+userAccount.getBalance());
}
private void deposit(Scanner scanner){
    System.out.print("Enter the amount to deposit: $");
    double amount=scanner.nextDouble();
    userAccount.deposit(amount);
}
private void withdraw(Scanner scanner){
    System.out.print("Enter the amount to withdraw: $");
    double amount=scanner.nextDouble();
    if(userAccount.withdraw(amount)){
        System.out.println("Please take your cash.");
    }else{
        System.out.println("Sorry! Transcation failed.");
    }
}
}
public class Main{
    public static void main(String[] args){
        Bankaccount account=new Bankaccount(1000);
        ATM atm=new ATM(account);
        atm.run();
}
}

