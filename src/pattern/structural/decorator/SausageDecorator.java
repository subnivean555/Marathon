package pattern.structural.decorator;

public class SausageDecorator extends ABstractDecorator {
    public SausageDecorator(ABatterCake cake) {
        super(cake);
    }

    @Override
    protected String desc() {
        return super.desc() + "add sausage";
    }

    @Override
    protected int price() {
        return super.price() + 2;
    }
}
