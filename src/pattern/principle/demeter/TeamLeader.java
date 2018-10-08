package pattern.principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {

    public void checkNumberOfCourses(){
        List<Course> courses = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            courses.add(new Course());
        }
        System.out.println(courses.size());
    }
}
