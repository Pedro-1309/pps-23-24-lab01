import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    private double initialBalance = 0;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, initialBalance);
    }

    @Test
    void testInitialBalance() {
        assertEquals(initialBalance, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        double depositAmount = 100;
        bankAccount.deposit(accountHolder.getId(), depositAmount);
        assertEquals(depositAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        double depositAmount = 100;
        double wrongDepositAmount = 50;
        int wrongUserId = 2;
        bankAccount.deposit(accountHolder.getId(), depositAmount);
        bankAccount.deposit(wrongUserId, wrongDepositAmount);
        assertEquals(depositAmount, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        double depositAmount = 100;
        double withdrawAmount = 70;
        double expectedBalance = depositAmount - withdrawAmount;
        bankAccount.deposit(accountHolder.getId(), depositAmount);
        bankAccount.withdraw(accountHolder.getId(), withdrawAmount);
        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        double depositAmount = 100;
        double wrongDepositAmount = 70;
        int wrongUserId = 2;
        bankAccount.deposit(accountHolder.getId(), depositAmount);
        bankAccount.withdraw(wrongUserId, wrongDepositAmount);
        assertEquals(depositAmount, bankAccount.getBalance());
    }
}
