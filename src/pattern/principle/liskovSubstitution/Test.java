package pattern.principle.liskovSubstitution;

public class Test {

    /**
     * 当入参变为 Square时, 会出现异常, 违背了里氏替换原则
     * @param rectangle
     */
    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getLength()+1);
            System.out.println("width : "+ rectangle.getWidth() + " length : " + rectangle.getLength());
        }
        System.out.println("resize 方法结束, width : " + rectangle.getWidth() + " length :" + rectangle.getLength());
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(11);
        rectangle.setLength(20);
        resize(rectangle);

        Square square = new Square();
        square.setSideLength(20);
        resize(square);
    }
}
