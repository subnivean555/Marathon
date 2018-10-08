package pattern.principle.compositionaggregation;

public class ProductDao {

    DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct(){
        System.out.println(dbConnection.getConnection()+"增加一个产品");
    }
}
