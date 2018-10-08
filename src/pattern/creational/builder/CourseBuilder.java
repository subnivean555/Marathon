package pattern.creational.builder;

public abstract class CourseBuilder {

    public abstract void buildCourseName(String name);
    public abstract void buildCoursePPT(String ppt);
    public abstract void buildCourseVideo(String video);
    public abstract void buildCourseArticle(String article);
    public abstract void buildCourseQA(String qa);
    public abstract Course makeCourse();
}
