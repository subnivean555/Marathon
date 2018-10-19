package pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class EmployeeFactory {

    private static final Map<String, Employee> EMPLOYEE_MAP = new HashMap<>();

    public static Employee getManager(String dept){
        Manager manager = (Manager) EMPLOYEE_MAP.get(dept);

        if (manager == null){
            manager = new Manager(dept);
            manager.setReportContent(dept + "start report .......");
            EMPLOYEE_MAP.put(dept, manager);
            System.out.println("创建" + dept + " manager");
        }

        return manager;
    }


}
