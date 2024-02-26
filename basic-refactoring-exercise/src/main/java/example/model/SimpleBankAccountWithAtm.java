package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    private final static double TRANSACTION_FEE = 1; 

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(final int userID, final double amount){
        super.deposit(userID, amount - TRANSACTION_FEE);
    }

    @Override
    public void withdraw(int userID, double amount) {
        super.withdraw(userID, amount - TRANSACTION_FEE);
    }
    
    public static double getTransactionFee() {
        return TRANSACTION_FEE;
    }
}