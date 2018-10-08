package pattern.structural.adapter.objectadapter;

public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concretetarget 目标方法...");
    }
}
