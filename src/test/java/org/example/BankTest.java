package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @ParameterizedTest(name = "When initial amount is {2}, the amount of the operation should be {0} and the balance should be {1}")
    @CsvSource({"500, 500, 500", "100, 100, 100", "200, 200, 200"})
    void test_should_return_a_deposit_operation_when_deposit_amount_on_a_new_account(int expected, int expectedAmount, int initialAmount){
        Account account = new Account(initialAmount);

        assertEquals(expected, account.getBalance());
        assertEquals(expectedAmount, account.getOperations().get(account.getOperations().size() - 1).getAmount());
        assertEquals(LocalDate.now(), account.getOperations().get(account.getOperations().size() - 1).getDate());
        assertEquals(OperationType.DEPOSIT, account.getOperations().get(account.getOperations().size() - 1).getType());
    }

    @ParameterizedTest(name = "When initial amount is {1}, and withdraw amount is {2} the balance should be {0}")
    @CsvSource({"0, 500, 500, 500", "0, 100, 100, 100", "200, 200, 400, 200"})
    void test_should_return_a_withdraw_operation_when_withdraw_amount_on_a_new_account_with_an_initial_amount
            (int expected, int expectedAmount, int initialAmount, int amount){
        Account account = new Account(initialAmount);

        account.withdraw(amount);

        assertEquals(expected, account.getBalance());
        assertEquals(expectedAmount, account.getOperations().get(account.getOperations().size() - 1).getAmount());
        assertEquals(LocalDate.now(), account.getOperations().get(account.getOperations().size() - 1).getDate());
        assertEquals(OperationType.WITHDRAW, account.getOperations().get(account.getOperations().size() - 1).getType());
    }

    @Test
    void test_should_return_a_NotEnoughMoneyException_when_the_balance_account_is_0_and_withdraw_amount_is_100(){
        Account account = new Account(0);

        assertThrows(NotEnoughMoneyException.class, () -> account.withdraw(100));
    }

    @Test
    void test_should_return_an_operation_with_a_date_an_operation_type_and_the_amount(){
        Operation operation = new Operation(OperationType.DEPOSIT, 100);

        assertEquals(LocalDate.now(), operation.getDate());
        assertEquals(OperationType.DEPOSIT, operation.getType());
        assertEquals(100, operation.getAmount());
    }

    @Test
    void test_should_return_the_statement_of_an_account(){
        Account account = new Account(500);
        account.withdraw(100);

        String expected =
                "Date Amount Balance\n"+
                LocalDate.now() + " +500 500\n"+
                LocalDate.now() + " -100 400\n";

        assertEquals(expected, BankPrinter.printStatement(account));
    }
}
