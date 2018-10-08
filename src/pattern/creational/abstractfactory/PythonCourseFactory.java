package pattern.creational.abstractfactory;

public class PythonCourseFactory implements ICourseFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
