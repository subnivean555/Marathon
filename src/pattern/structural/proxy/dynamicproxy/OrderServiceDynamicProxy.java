package pattern.structural.proxy.dynamicproxy;

import pattern.structural.proxy.Order;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    public Object bind(){
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this::invoke);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object arg = args[0];
        before(arg);
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    private void before(Object obj){
        System.out.println("dynamic proxy before code ...");
        int userId = 0;

        if (obj instanceof Order){
            Order order = (Order) obj;
            userId = order.getUserId();
        }
        int dbRouter = userId % 2;
        System.out.println("dynamic proxy assign " + dbRouter + " process data ....");

    }

    private void after(){
        System.out.println("dynamic proxy after method ....");
    }
}
