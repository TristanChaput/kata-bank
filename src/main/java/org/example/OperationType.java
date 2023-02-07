package org.example;

public enum OperationType {
    DEPOSIT {
        @Override
        public Integer balanceAmount(Integer operationAmount) {
            return operationAmount;
        }
    }, WITHDRAW {
        @Override
        public Integer balanceAmount(Integer operationAmount) {
            return -operationAmount;
        }
    };
    abstract public Integer balanceAmount(Integer operationAmount);
}
