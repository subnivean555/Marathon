package pattern.creational.abstractfactory;

public class Test {

    public static void main(String[] args) {
        ICourseFactory javaCourse = new JavaCourseFactory();
        Video video = javaCourse.getVideo();
        Article article = javaCourse.getArticle();
        video.produce();
        article.produce();
    }
}
