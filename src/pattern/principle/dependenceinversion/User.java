package pattern.principle.dependenceinversion;

public class User {

    public void studyCourse(ICourse course){
        course.studyCourse();
    }

}
