public class BankTest {
    public static void main(String[] args) {
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();

        // Deposit Test
        account1.deposit("checking", 1000);
        account1.deposit("savings", 500);
        account2.deposit("checking", 2000);
        account3.deposit("savings", 1500);

        // Display balances after deposits
        account1.getBalance();
        account2.getBalance();
        account3.getBalance();

        // Withdrawal Test
        account1.withdraw("checking", 200);
        account2.withdraw("savings", 300);
        account3.withdraw("checking", 500);

        // Display balances after withdrawals
        account1.getBalance();
        account2.getBalance();
        account3.getBalance();

        // Static Test
        System.out.println("Total Accounts: " + BankAccount.getAccounts());
        System.out.println("Total Money in Bank: $" + BankAccount.getTotalMoney());
    }
}
