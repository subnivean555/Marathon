package pattern.principle.singleresponsibility;

public class Course implements ICourseContent, ICourseManager {
    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public String getCourseInfo() {
        return null;
    }

    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }
}
