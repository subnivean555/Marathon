package pattern.creational.simplefactory;

public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制 Python 视频");
    }
}
