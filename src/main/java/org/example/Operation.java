package org.example;

import java.time.LocalDate;

public class Operation {

    private final LocalDate date;
    private final OperationType type;
    private final int amount;

    public Operation(OperationType type, int amount) {
        date = LocalDate.now();
        this.type = type;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public OperationType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public int balanceAmount() {
        return type.balanceAmount(amount);
    }
}
