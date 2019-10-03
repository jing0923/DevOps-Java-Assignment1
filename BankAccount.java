package com.flexon.corejava;

import java.awt.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

class BankAccount {
    private long accountNumber;
    private String accountType;
    private double balance;
    private String customerFirstName;
    private String customerLastName;
    private String email;
    private int phoneNumber;

    private int depositNo = 0;
    private double depositTotal = 0;
    private double withdrawTotal = 0;


    DateFormat timestampFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
    Date timeStamp= new Date();

    List<String> History = new ArrayList<>();

    public BankAccount(long accountNumber, String accountType, double balance, String customerFirstName, String customerLastName, String email, int phoneNumber){
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void showBalance() {
        System.out.println("Name: " + customerFirstName + " " + customerLastName + "\n" + "AccountType: " + accountType + "\n" + "Balance: $ " + balance);
        System.out.println(timestampFormat.format(timeStamp) + "\n");
    }


    public int getDepositNo() {
        return depositNo;
    }

    public double getDepositTotal() {
        return depositTotal;
    }

    public void depositFunds(double deposit) {
            if(deposit>500) System.out.println("Sorry, the limitation for each transaction is $500.\n");
            else if(deposit<50) System.out.println("Sorry, deposit less than $50 is not allowed.\n");
            else {
                this.balance += deposit;
                depositTotal += deposit;
                depositNo++;
                String deposittransaction = "\nDoposit " + deposit + " at " + timeStamp + ", balance: $" + balance +". \n";
                History.add(deposittransaction);
                System.out.println("Deposit Successfully, now you balance is: $" + balance + "\n");
            }
    }

    public void withdrawFunds(double withdraw) {
        if(withdrawTotal<=1000){
            if(balance < withdraw) System.out.println(customerFirstName + " " + customerLastName + "\n sorry, you have insufficient balance: $" + balance );
            else {
                this.balance -= withdraw;
                withdrawTotal += withdraw;
                double remain = 1000 - withdrawTotal;
                String withdrawtransaction = "\nWithdraw " + withdraw + " at " + timeStamp + ", balance: $" + balance;
                History.add(withdrawtransaction);
                System.out.println("Withdraw Successfully, now your balance is: $" + balance + "\nYou can still withdraw $" + remain +"\n");
            }
        }
        else System.out.println("Sorry, the limitation for daily withdraw is $1000.\n");
    }

    public void printInfo(){
        System.out.println("Customer Name: "+ customerFirstName + " " + customerLastName + "\nAccount Number: " + accountNumber + "\nBalance: $" + balance + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\n ");
    }

    public void transactionHistory(){
        System.out.println("Here are all your transaction: \n" + History.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim() + "\n");
    }

}
