package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    void test_should_return_500_when_deposit_500_on_the_new_account(){
        Account account = new Account(0);

        account.deposit(500);

        assertEquals(500, account.balance);
    }
}
