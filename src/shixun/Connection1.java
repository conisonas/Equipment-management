package shixun;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connection1 {
    private static Connection con = null;
    public static Connection getcon() {
        try {
            //注册JDBC驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功1");
            //建立连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dorm1?&useSSL=false&serverTimezone=UTC", "root", "root");
            System.out.println("数据库加载成功1");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void main(String[] args) {
        getcon();
    }
}
