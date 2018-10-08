package pattern.creational.builder;

public class ActualBuilder extends CourseBuilder {

    private Course course = new Course();

    @Override
    public void buildCourseName(String name) {
        course.setCourseName(name);
    }

    @Override
    public void buildCoursePPT(String ppt) {
        course.setCoursePPT(ppt);
    }

    @Override
    public void buildCourseVideo(String video) {
        course.setCourseVideo(video);
    }

    @Override
    public void buildCourseArticle(String article) {
        course.setCourseArticle(article);
    }

    @Override
    public void buildCourseQA(String qa) {
        course.setCourseQA(qa);
    }

    @Override
    public Course makeCourse() {
        return course;
    }
}
