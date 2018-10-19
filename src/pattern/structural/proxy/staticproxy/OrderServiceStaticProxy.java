package pattern.structural.proxy.staticproxy;

import pattern.structural.proxy.IOrderService;
import pattern.structural.proxy.Order;
import pattern.structural.proxy.OrderServiceImpl;

public class OrderServiceStaticProxy {

    private IOrderService orderService;

    public int saveOrder(Order order){
        before(order);
        orderService = new OrderServiceImpl();
        int res = orderService.saveOrder(order);
        after();
        return res;
    }

    private void before(Order order){
        int userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("static proxy assign " + dbRouter + " process data ....");
        System.out.println("static proxy before code ...");
    }

    private void after(){
        System.out.println("static proxy after code ...");
    }
}
