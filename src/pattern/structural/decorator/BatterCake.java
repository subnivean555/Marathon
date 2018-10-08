package pattern.structural.decorator;

public class BatterCake extends ABatterCake{

    @Override
    protected String desc() {
        return "煎饼";
    }

    @Override
    protected int price() {
        return 4;
    }
}
