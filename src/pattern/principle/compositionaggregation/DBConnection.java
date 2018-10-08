package pattern.principle.compositionaggregation;

public abstract class DBConnection {

    /*public void getConnection(){
        System.out.println("使用 Mysql 增加数据库");
    }*/

    public abstract String getConnection();

}
