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
        return this.operations.stream()
                .mapToInt(operation -> {
                    int res = 0;
                    if(OperationType.WITHDRAW.equals(operation.getType())){
                        res -= operation.getAmount();
                    }else if (OperationType.DEPOSIT.equals(operation.getType())){
                        res += operation.getAmount();
                    }
                    return res;
                })
                .sum();
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
