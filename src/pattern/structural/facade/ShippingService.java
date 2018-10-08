package pattern.structural.facade;

public class ShippingService {

    public String shipGift(Gift gift){

        System.out.println(gift.getName() + " 进入物流系统");
        return "666";
    }
}
