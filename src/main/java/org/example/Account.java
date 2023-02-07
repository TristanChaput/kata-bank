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

    public String printStatement() {
        StringBuilder statement = new StringBuilder("Date Amount Balance\n");
        for (Operation operation: operations) {
            int currentIndex = operations.indexOf(operation);
            List<Operation> operationsToCompute = operations.subList(0, currentIndex + 1);

            statement.append(operation.getDate())
                    .append(" ")
                    .append(operation.getType().equals(OperationType.DEPOSIT) ? "+" : "-")
                    .append(operation.getAmount())
                    .append(" ")
                    .append(getBalanceFromAListOfOperations(operationsToCompute))
                    .append("\n");
        }
        return statement.toString();
    }
}
