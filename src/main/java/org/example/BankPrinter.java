package org.example;

import java.util.List;

public class BankPrinter {
    public static String printStatement(Account account) {
        StringBuilder statement = new StringBuilder("Date Amount Balance\n");
        List<Operation> operations = account.getOperations();

        for (Operation operation: operations) {
            int currentIndex = operations.indexOf(operation);
            List<Operation> operationsToCompute = operations.subList(0, currentIndex + 1);

            statement.append(operation.getDate())
                    .append(" ")
                    .append(isADepositOperation(operation) ? "+" : "-")
                    .append(operation.getAmount())
                    .append(" ")
                    .append(account.getBalanceFromAListOfOperations(operationsToCompute))
                    .append("\n");
        }

        return statement.toString();
    }

    private static boolean isADepositOperation(Operation operation) {
        return operation.getType().equals(OperationType.DEPOSIT);
    }
}
