package com.flexon.corejava;

public class BankAccount {
    private long accountNumber;
    private double balance;
    private String customerFirstName;
    private String customerLastName;
    private String email;
    private int phoneNumber;

    public BankAccount(long accountNumber, double balance, String customerFirstName, String customerLastName, String email, int phoneNumber){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void depositFunds(double deposit) {
        this.balance += deposit;
    }

    public void withdrawFunds(double withdraw) {
        if(balance < withdraw) System.out.println(customerFirstName + " " + customerLastName + "\n sorry, you have insufficient balance: " + balance );
        else this.balance -= withdraw;
    }

    public void printInfo(){
        System.out.println("Customer Name: "+ customerFirstName + " " + customerLastName + "\nAccount Number: " + accountNumber + "\nBalance: " + balance + "\nEmail: " + email + "\nPhone Number: " + phoneNumber);
    }

}
