package pattern.principle.demeter;

public class Boss {

    public void commandCheckNumber(TeamLeader leader){
        /*List<Course> courses = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            courses.add(new Course());
        }*/

        leader.checkNumberOfCourses();
    }
}
