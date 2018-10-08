package pattern.structural.adapter.objectadapter;

public class Test {
    public static void main(String[] args) {

        Target target = new ConcreteTarget();
        target.request();

        Target adapter = new Adapter();
        adapter.request();
    }
}
