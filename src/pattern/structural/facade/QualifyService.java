package pattern.structural.facade;

public class QualifyService {

    public boolean isAvaliable(Gift gift){
        System.out.println("校验 : "+gift.getName()+", 积分资格通过");
        return true;
    }
}
