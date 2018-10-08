package pattern.principle.dependenceinversion;

public class HtmlCourse implements ICourse{

    @Override
    public void studyCourse() {
        System.out.println("user is learning html course");
    }

}
