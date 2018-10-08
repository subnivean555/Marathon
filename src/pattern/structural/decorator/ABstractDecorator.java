package pattern.structural.decorator;

public class ABstractDecorator extends ABatterCake {

    private ABatterCake cake;

    public ABstractDecorator(ABatterCake cake){
        this.cake = cake;
    }

    @Override
    protected String desc() {
        return this.cake.desc();
    }

    @Override
    protected int price() {
        return this.cake.price();
    }
}
