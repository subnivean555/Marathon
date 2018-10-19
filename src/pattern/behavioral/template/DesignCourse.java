package pattern.behavioral.template;

public class DesignCourse extends ACourse {
    @Override
    void packageCourse() {
        System.out.println("provide source code");
    }

    @Override
    protected boolean needWriteArticle() {
        return true;
    }
}
