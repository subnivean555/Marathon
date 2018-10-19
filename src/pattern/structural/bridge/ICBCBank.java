package pattern.structural.bridge;

public class ICBCBank extends Bank {
    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("open icbc account");
        account.openAccount();
        return account;
    }
}
