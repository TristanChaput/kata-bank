package org.example;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final List<Operation> operations;

    public Account(int initialAmount) {
        operations = new ArrayList<>();
        deposit(initialAmount);
    }

    public void deposit(int amount) {
        operations.add(new Operation(OperationType.DEPOSIT, amount));
    }

    public void withdraw(int amount) {
        if( getBalance() < amount ) {
            throw new NotEnoughMoneyException();
        }
        operations.add(new Operation(OperationType.WITHDRAW, amount));
    }

    public int getBalance() {
        return getBalanceFromAListOfOperations(operations);
    }

    public int getBalanceFromAListOfOperations(List<Operation> operations) {
        return operations.stream()
                .mapToInt(Operation::balanceAmount)
                .sum();
    }

    public List<Operation> getOperations() {
        return operations;
    }

}
