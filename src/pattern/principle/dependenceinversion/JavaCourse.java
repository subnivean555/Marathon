package pattern.principle.dependenceinversion;

public class JavaCourse implements ICourse{
    @Override
    public void studyCourse() {
        System.out.println("user is learning java course");
    }
}
