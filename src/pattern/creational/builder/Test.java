package pattern.creational.builder;

public class Test {

    public static void main(String[] args) {
        CourseBuilder builder = new ActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(builder);
        Course course = coach.makeCourse("firstCourse", "ppt", "videos", "artcles", "qa");
        System.out.println(course);
    }
}
