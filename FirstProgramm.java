package com.flexon.corejava;

import java.util.Scanner;

public class FirstProgramm {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(123456789, 50.0, "Jing", "Hu", "jinghu0923@gmail.com", 111111111); //Hardcode for now

        while (true) {
            System.out.println("Please select from the following: \n1. Show Account Balance \n2. Deposit Money \n3. Withdraw Money \n4. Exit");

            Scanner input = new Scanner(System.in);
            String flag = input.nextLine();
            if (flag.equals("4")) break;

            switch (flag) {
                case "1":
                    System.out.println("Your balance is: " + account.getBalance() +"\n");
                    break;
                case "2":
                    System.out.println("Please enter the amount money: "); //connect with API
                    Scanner in = new Scanner(System.in);
                    String deposit = in.nextLine();
                    account.depositFunds(Double.parseDouble(deposit));
                    System.out.println("Deposit Successfully\n");
                    break;
                case "3":
                    System.out.println("Please enter the amount of money you want to withdraw: ");
                    Scanner out = new Scanner(System.in);
                    String withdraw = out.nextLine();
                    account.withdrawFunds(Double.parseDouble(withdraw));
                    System.out.println("Withdraw Successfully\n");
                    break;
                default:
                    System.out.println("Wrong input!\n");
                    break;
            }
        }

        System.out.println("Exit Successfully");


    }
}
