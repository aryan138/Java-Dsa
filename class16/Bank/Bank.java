package class16.Bank;

import java.util.HashMap;
import java.util.Scanner;

class Details {
    String name;
    String address;
    String phoneNumber;
    long accountNo;
    int amt;
    int pin;
}

@SuppressWarnings("resource")
public class Bank {
    Scanner sc = new Scanner(System.in);
    HashMap<Long, Details> users = new HashMap<>();

    public void deposit(Details user, int amount) {
        if (amount > 0) {
            user.amt += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void checkBalance(Details user) {
        System.out.println("Your current balance is "+user.amt);
    }

    public void withdraw(Details user, int amount) {
        if (amount > 0 && amount <= user.amt) {
            user.amt -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }

    public Details newUser() {
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        long accountNo = randomAcc();
        System.out.println("Enter your initial amount:");
        int amt = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your address:");
        String address = sc.nextLine();
        System.out.println("Enter your phone number:");
        String phoneNumber = sc.nextLine();

        Details user = new Details();
        user.name = name;
        user.address = address;
        user.phoneNumber = phoneNumber;
        user.accountNo = accountNo;
        user.amt = amt;

        System.out.println("Bank details:");
        System.out.println("Name: " + user.name);
        System.out.println("Amount: " + user.amt);
        System.out.println("Address: " + user.address);
        System.out.println("Phone number: " + user.phoneNumber);

        System.out.println("\n\nYour Account Number is: " + user.accountNo);
        System.out.println("Enter 4 digit pin for your account");
        boolean m = true;
        while (m) {
            user.pin = sc.nextInt();
            m = false;
            if (!(user.pin > 999 && user.pin < 10000)) {
                System.out.println("Entered pin should be between 1000 and 9999");
                m = true;
            }
        }

        users.put(user.accountNo, user);
        sc.nextLine();
        return user;
    }

    public void oldUser() {
        System.out.println("Enter your account number:");
        long accountNo = sc.nextLong();
        sc.nextLine();
        Details user = users.get(accountNo);

        if (user != null) {
            System.out.println("Enter your pin:");
            int p = sc.nextInt();

            if (p == user.pin) {
                System.out.println("Welcome "+user.name);
                while (true) {
                    System.out.println("\nEnter 1 for deposit, 2 for withdrawal, 3 for check balance, 4 to exit:");
                    int n = sc.nextInt();
                    int c;

                    if (n == 1) {
                        System.out.println("Enter deposit amount:");
                        c = sc.nextInt();
                        deposit(user, c);
                        System.out.println("Updated Amount after deposit: " + user.amt);
                    } else if (n == 2) {
                        System.out.println("Enter withdrawal amount:");
                        c = sc.nextInt();
                        withdraw(user, c);
                        System.out.println("Updated Amount after withdrawal: " + user.amt);
                    } else if (n == 4) {
                        System.out.println("Exiting...");
                        break;
                    } else if(n==3){
                        checkBalance(user);
                    }
                    else {
                        System.out.println("Invalid Choice. Please try again.");
                    }
                }
            } else {
                System.out.println("Wrong Pin");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank();

        while (true) {
            System.out.println("\n\nWelcome to Our Bank\n");
            System.out.println("If you are new ENTER 1");
            System.out.println("If you already have an account ENTER 2");
            int k = sc.nextInt();
            sc.nextLine();

            if (k == 1) {
                b.newUser();
            } else if (k == 2) {
                b.oldUser();
            } else {
                System.out.println("Invalid Choice. Please try again.");
            }
        }
    }

    private static long randomAcc() {
        return (long) (Math.random() * (long) Math.pow(10, 12));
    }
}
