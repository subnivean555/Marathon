package pattern.creational.simplefactory;

public class Test {

    public static void main(String[] args) {
        VideoFactory factory = new VideoFactory();
        Video video = factory.getVideo(JavaVideo.class);
        if (video != null){
            video.produce();
        }
    }
}
