package pattern.structural.proxy.staticproxy;

import pattern.structural.proxy.Order;

public class Test {

    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy proxy = new OrderServiceStaticProxy();
        proxy.saveOrder(order);

    }
}
