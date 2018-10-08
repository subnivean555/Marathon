package pattern.structural.adapter.objectadapter;

public class Adapter implements Target {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.request();
    }
}
