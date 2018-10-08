package pattern.principle.dependenceinversion;

public class Test {

    public static void main(String[] args) {
        /**
         * 此时如果需要扩展, 需要去修改 user 类, 不利于扩展和维护
         */
        /*
        User user = new User();
        user.userHtml();
        user.userJava();
        */

        /**
         *  可以通过继续实现接口去扩展
         */
        User user = new User();
        user.studyCourse(new JavaCourse());
        user.studyCourse(new HtmlCourse());

    }
}
