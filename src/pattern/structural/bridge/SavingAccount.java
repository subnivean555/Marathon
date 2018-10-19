package pattern.structural.bridge;

public class SavingAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("open saving account...");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("saving account...");
    }
}
