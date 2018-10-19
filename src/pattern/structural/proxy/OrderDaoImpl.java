package pattern.structural.proxy;

public class OrderDaoImpl implements OrderMapper {
    @Override
    public int insert(Order order) {
        System.out.println("add order success ......");
        return 0;
    }
}
