
package gaBackend.modelo.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlos
 */
public class Service {
    
    //private String URL_Servidor = "localhost";
    //private static final String BASE_DATOS = "gadb";
    protected static final String DATABASE_DRIVER
            = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION
            = "jdbc:mysql://localhost/gadb";

    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static Connection connection;

    public Service() {
        connection = null;
    }

    protected static void connection() throws SQLException, ClassNotFoundException {
        //Class.forName(DATABASE_DRIVER);
        connection = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);
    }

    protected static void disconnect() throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
        }
    }

    
}
