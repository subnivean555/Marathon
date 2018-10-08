package pattern.structural.facade;

public class Test {

    public static void main(String[] args) {

        Gift gift = new Gift();
        gift.setName("jiangpin");
        GiftExchangeService giftExchangeService = new GiftExchangeService();

        giftExchangeService.setPaymentService(new PaymentService());
        giftExchangeService.setQualifyService(new QualifyService());
        giftExchangeService.setShippingService(new ShippingService());

        giftExchangeService.giftExchange(gift);
    }
}
