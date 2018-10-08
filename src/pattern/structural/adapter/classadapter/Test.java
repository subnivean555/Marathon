package pattern.structural.adapter.classadapter;

public class Test {

    public static void main(String[] args) {

        Target target = new ConcreteTarget();
        target.request();

        Target adapter = new Adapter();
        adapter.request();
    }
}
