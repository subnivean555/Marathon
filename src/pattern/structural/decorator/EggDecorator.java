package pattern.structural.decorator;

public class EggDecorator extends ABstractDecorator{

    public EggDecorator(ABatterCake cake) {
        super(cake);
    }

    @Override
    protected String desc() {
        return super.desc() + " add an egg";
    }

    @Override
    protected int price() {
        return super.price() + 1;
    }
}
