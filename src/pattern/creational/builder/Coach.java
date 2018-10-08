package pattern.creational.builder;

public class Coach {

    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

    public Course makeCourse(String name, String ppt, String video, String article, String qa){
        this.courseBuilder.buildCourseArticle(article);
        this.courseBuilder.buildCourseName(name);
        this.courseBuilder.buildCoursePPT(ppt);
        this.courseBuilder.buildCourseQA(qa);
        this.courseBuilder.buildCourseVideo(video);
        return this.courseBuilder.makeCourse();
    }
}
