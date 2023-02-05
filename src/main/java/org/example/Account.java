package org.example;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int balance;
    private final List<Operation> operations;

    public Account(int initialAmount) {
        balance = initialAmount;
        operations = new ArrayList<>();
        deposit(initialAmount);
    }

    public void deposit(int amount) {
        operations.add(new Operation(OperationType.DEPOSIT, amount));
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

    public List<Operation> getOperations() {
        return operations;
    }
}
