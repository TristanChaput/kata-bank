package org.example;

public class Account {
    public int balance;

    public Account(int initialAmount) {
    }

    public void deposit(int amount) {
        balance = amount;
    }
}
