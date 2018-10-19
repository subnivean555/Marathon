package pattern.structural.proxy;

public class OrderServiceImpl implements IOrderService{

    private OrderMapper orderMapper;

    @Override
    public int saveOrder(Order order) {
        orderMapper = new OrderDaoImpl();
        System.out.println("service operation completed ...... ");
        return orderMapper.insert(order);
    }
}
