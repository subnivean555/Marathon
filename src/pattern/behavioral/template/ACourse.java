package pattern.behavioral.template;

public abstract class ACourse {

    protected final void makeCourse(){
        this.makeVideo();
        this.makePPT();
        if (needWriteArticle()){
            this.writeArticle();
        }
        this.packageCourse();
    }

    final void makePPT(){
        System.out.println("make a ppt");
    }

    final void makeVideo(){
        System.out.println("make videos");
    }

    final void writeArticle(){
        System.out.println("write article");
    }

    protected boolean needWriteArticle(){
        return false;
    }

    abstract void packageCourse();
}
