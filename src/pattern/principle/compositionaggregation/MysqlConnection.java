package pattern.principle.compositionaggregation;

public class MysqlConnection extends DBConnection {
    @Override
    public String getConnection() {
        return " 获取Mysql数据库连接";
    }
}
