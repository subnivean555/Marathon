package pattern.structural.bridge;

public class ABCBank extends Bank{

    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("open abc account...");
        account.openAccount();
        return account;
    }
}
