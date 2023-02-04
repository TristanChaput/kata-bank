package org.example;

public class Account {
    public int balance;

    public Account(int initialAmount) {
        balance = initialAmount;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
