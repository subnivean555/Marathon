package pattern.principle.compositionaggregation;

public class SqlServerConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "获取 SqlServer 获取数据库连接";
    }
}
