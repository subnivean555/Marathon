package pattern.behavioral.template;

public class Test {

    public static void main(String[] args) {

        System.out.println("before design course ......");
        ACourse decour = new DesignCourse();
        decour.makeCourse();
        System.out.println("after design course ......");

        System.out.println("before design course ......");
        ACourse fecour = new FECourse();
        fecour.makeCourse();
        System.out.println("after design course ......");

    }

}
