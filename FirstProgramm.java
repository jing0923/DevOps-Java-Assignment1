package com.flexon.corejava;

import java.util.Scanner;

public class FirstProgramm {
    public static void main(String[] args) {

        BankAccount myAccount = new BankAccount(123456789, "R", 50.00, "Jing", "Hu", "jinghu0923@gmail.com", 111111111); //Hardcode for now

        Scanner input = new Scanner(System.in);
        String flag = "";

        do {
            System.out.println("Welcome to Bank! Please select from the following: \n1. Account Information \n2. Account Balance \n3. Deposit Money \n4. Withdraw Money \n5. Transaction History \n6.Exit");
            flag =  input.nextLine();
            switch (flag) {
                case "1":
                    myAccount.printInfo();
                    break;
                case "2":
                     myAccount.showBalance();
                    break;
                case "3":
                    if(myAccount.getDepositNo()>=3) System.out.println("Sorry, 3 deposits are allowed daily.\n");
                    else if(myAccount.getDepositTotal()>=1500) System.out.println("Sorry, $1500 deposits are allowed daily.\n");
                    else {
                        System.out.println("Please enter the amount money: "); //connect with API
                        myAccount.depositFunds(Double.parseDouble(input.nextLine()));
                    }
                    break;
                case "4":
                    System.out.println("Please enter the amount of money you want to withdraw: ");
                    myAccount.withdrawFunds(Double.parseDouble(input.nextLine()));
                    break;
                case "5": myAccount.transactionHistory();break;
                case "6": break;
                default:
                    System.out.println("Wrong input!\n");
                    break;
            }
        }while(!flag.equals("6"));

        System.out.println("Exit Successfully");


    }
}
