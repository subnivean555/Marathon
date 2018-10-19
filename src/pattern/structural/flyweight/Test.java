package pattern.structural.flyweight;

import java.util.Random;

public class Test {

    private static final String[] depts = {"RD", "QA", "PM", "BD"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++){
            String dept = depts[new Random().nextInt(4)];
            Manager manager = (Manager) EmployeeFactory.getManager(dept);
            manager.report();
        }
    }
}
