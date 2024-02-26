import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest{

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    private double initialBalance = 0;
    private double transactionFee = 1;

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Paolo", "Bianchi", 2);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, initialBalance);
    }

    @Test
    void testInitialBalance() {
        assertEquals(initialBalance, bankAccount.getBalance());
    }

    @Test
    void testDeposit(){
        double depositAmount = 100;
        bankAccount.deposit(accountHolder.getId(), depositAmount);
        assertEquals(depositAmount - transactionFee, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        double depositAmount = 100;
        double wrongDepositAmount = 50;
        int wrongUserId = 2;
        bankAccount.deposit(accountHolder.getId(), depositAmount);
        bankAccount.deposit(wrongUserId, wrongDepositAmount);
        assertEquals(depositAmount - transactionFee, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        double depositAmount = 100;
        double withdrawAmount = 70;
        double expectedBalance = (depositAmount - transactionFee) - (withdrawAmount - transactionFee);
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
        assertEquals(depositAmount - transactionFee, bankAccount.getBalance());
    }
}
