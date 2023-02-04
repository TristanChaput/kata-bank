package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @ParameterizedTest(name = "When initial amount is {1}, and deposit amount is {2} the balance should be {0}")
    @CsvSource({"500, 0, 500", "100, 0, 100", "200, 100, 100"})
    void test_should_return_actualized_balance_when_deposit_amount_on_an_account_with_an_initial_amount
            (int expected, int initialAmount, int amount){
        Account account = new Account(initialAmount);

        account.deposit(amount);

        assertEquals(expected, account.getBalance());
    }

    @ParameterizedTest(name = "When initial amount is {1}, and withdraw amount is {2} the balance should be {0}")
    @CsvSource({"0, 500, 500", "0, 100, 100", "200, 400, 200"})
    void test_should_return_actualized_balance_when_withdraw_amount_on_an_account_with_an_initial_amount
            (int expected, int initialAmount, int amount){
        Account account = new Account(initialAmount);

        account.withdraw(amount);

        assertEquals(expected, account.getBalance());
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
}
