package pattern.behavioral.template;

public class FECourse extends ACourse {

    private boolean needArticle = false;

    @Override
    void packageCourse() {
        System.out.println("provide source code");
        System.out.println("provide img source");
    }

    public void setNeedArticle(boolean needArticle) {
        this.needArticle = needArticle;
    }

    @Override
    protected boolean needWriteArticle() {
        return needArticle;
    }
}
