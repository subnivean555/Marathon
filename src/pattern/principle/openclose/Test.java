package pattern.principle.openclose;

public class Test {

    public static void main(String[] args) {
        ICourse javaCourse = new JavaDiscountCourse(1, "java course", 20.0);
        JavaDiscountCourse course = (JavaDiscountCourse) javaCourse;
        System.out.println("id : " + course.getId() + " 名称 : " + course.getName() + " 折后价 : " + course.getDiscountPrice() + " 原价 : " + course.getPrice());

    }
}
