package pattern.structural.facade;

public class PaymentService {
    public boolean pay(Gift gift){

        System.out.println("支付" + gift.getName() + " 积分成功");
        return true;
    }
}
