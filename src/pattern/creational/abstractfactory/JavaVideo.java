package pattern.creational.abstractfactory;

public class JavaVideo extends Video{
    @Override
    public void produce() {
        System.out.println("录制 java 视频课");
    }
}
