package pattern.structural.facade;

public class GiftExchangeService {
    private QualifyService qualifyService;
    private PaymentService paymentService;
    private ShippingService shippingService;

    public void setQualifyService(QualifyService qualifyService) {
        this.qualifyService = qualifyService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setShippingService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void giftExchange(Gift gift){
        if (qualifyService.isAvaliable(gift)){
            if (paymentService.pay(gift)) {
                String number = shippingService.shipGift(gift);
                System.out.println("下单成功, 物流编号为 " + number);
            }
        }
    }

}
