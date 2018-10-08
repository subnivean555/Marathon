package pattern.structural.adapter.classadapter;

public class ConcreteTarget implements Target{
    @Override
    public void request() {
        System.out.println(" concretetarget 目标方法...");
    }
}
