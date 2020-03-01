package gaBackend.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos Obando & Felipe Piedra
 */
public class GestorBD {
//<editor-fold desc="Atributos" defaultstate="collapsed">

    private static GestorBD instancia = null;

    private static final String PROTOCOLO = "jdbc:mysql:";
    private static final String DIRECCION_SERVIDOR = "localhost";
    private static final String BASE_DATOS = "gaDB";

    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
//</editor-fold>
//<editor-fold desc="Métodos" defaultstate="collapsed">

    private GestorBD()
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException {
        String nombreClase = "com.mysql.jdbc.Driver";
        Class.forName(nombreClase).newInstance();
    }

    public static GestorBD obtenerInstancia()
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorBD();
        }
        return instancia;
    }

    public Connection obtenerConexion() throws SQLException {

        String hileraConexion = String.format(
                "%s//%s/%s",
                PROTOCOLO, DIRECCION_SERVIDOR, BASE_DATOS);
        System.out.printf("Hilera de conexión: '%s'%n", hileraConexion);

        System.out.println("Abriendo conexión..");
        Connection cnx = DriverManager.getConnection(hileraConexion, USUARIO, CLAVE);
        return cnx;
    }
//</editor-fold>
}
