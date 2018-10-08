package pattern.creational.abstractfactory;

public class PythonArticle extends Article{
    @Override
    public void produce() {
        System.out.println("编写 Python 手记");
    }
}
