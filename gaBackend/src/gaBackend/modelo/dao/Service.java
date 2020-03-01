package gaBackend.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos Obando & Felipe Piedra
 */
public class Service {
    //<editor-fold desc="Atributos" defaultstate="collapsed">

    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    public static Connection connection;

    protected static final String DATABASE_DRIVER
            = "com.mysql.cj.jdbc.Driver";

    private static final String CONEXION
            = "jdbc:mysql://localhost/gadb";

    //</editor-fold>
    //<editor-fold desc="Métodos" defaultstate="collapsed">
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

    //</editor-fold>
}
