package pattern.structural.decorator;

public class Test {

    public static void main(String[] args) {
        ABatterCake cake;
        cake = new BatterCake();
        cake = new EggDecorator(cake);
        cake = new EggDecorator(cake);
        cake = new SausageDecorator(cake);
        System.out.println(cake.desc());
    }
}
