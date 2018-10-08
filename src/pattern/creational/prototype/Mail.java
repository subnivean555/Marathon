package pattern.creational.prototype;

public class Mail implements Cloneable{

    private String name;
    private String emaillAdd;
    private String content;

    public Mail() {
        System.out.println("mail 初始化完成");
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", emaillAdd='" + emaillAdd + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmaillAdd() {
        return emaillAdd;
    }

    public void setEmaillAdd(String emaillAdd) {
        this.emaillAdd = emaillAdd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone mail object");
        return super.clone();
    }
}
