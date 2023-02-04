package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @ParameterizedTest
    @CsvSource({"500, 0, 500", "100, 0, 100", "200, 100, 100"})
    void test_should_return_actualized_balance_when_deposit_amount_on_an_account_with_an_initial_amount
            (int expected, int initialAmount, int amount){
        Account account = new Account(initialAmount);

        account.deposit(amount);

        assertEquals(expected, account.balance);
    }
}
