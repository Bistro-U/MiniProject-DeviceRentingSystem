
package quanghung.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.NamingException;

public class DBUtils {

    public static Connection getConnection() throws SQLException, NamingException, ClassNotFoundException {
        Connection cn = null;
        String IP = "localhost";
        String instanceName = "LAPTOP-OCN63M1C\\MSSQLSERVERMS";
        String port = "1433";
        String uid = "sa";
        String pwd = "123456";
        String db = "ITDeviceManagementSystem";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + IP + "\\" + instanceName + ":" + port
                + ";databasename=" + db + ";user=" + uid + ";password=" + pwd;
        Class.forName(driver);
        cn = DriverManager.getConnection(url);
        return cn;
    }
}