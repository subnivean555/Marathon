package pattern.principle.compositionaggregation;

public class Test {

    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        dao.setDbConnection(new MysqlConnection());
        dao.addProduct();
    }

}
