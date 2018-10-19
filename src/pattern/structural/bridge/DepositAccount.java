package pattern.structural.bridge;

public class DepositAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("open deposit account ...");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("deposit account ... ");
    }
}
