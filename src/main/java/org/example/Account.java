package org.example;

public class Account {

    private int balance;

    public Account(int initialAmount) {
        balance = initialAmount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if( balance < amount ) {
            throw new NotEnoughMoneyException();
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
