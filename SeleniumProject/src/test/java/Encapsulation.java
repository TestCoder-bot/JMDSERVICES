

import HandsOnTask.BankAccount;

public class Encapsulation {
    public static void main(String[] args) {
        // Creating a BankAccount object
        BankAccount account = new BankAccount("John", 1000, "3154653218");

        // Access and print account details
        System.out.println("Account Holder Name: " + account.getAccountHolderName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Current Balance: " + account.getBalance());

        // Deposit money
        account.deposit(5000);
        System.out.println("Updated Balance: " + account.getBalance());

        // Withdraw money
        account.withdraw(1500);
        System.out.println("Remaining Balance: " + account.getBalance());
    }
}
