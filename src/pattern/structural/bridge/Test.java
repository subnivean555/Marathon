package pattern.structural.bridge;

public class Test {

    public static void main(String[] args) {
        Bank abc = new ABCBank(new DepositAccount());
        Account ABCaccount = abc.openAccount();
        ABCaccount.showAccountType();

        Bank icbc = new ICBCBank(new SavingAccount());
        Account ICBCaccount = icbc.openAccount();
        ICBCaccount.showAccountType();
    }
}
