package backendga.modelo.dao;

import backendga.database.managers.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorUsuario {
    //<editor-fold desc="Procedimientos" defaultstate="collapsed">

    private static final String LISTARUSUARIOS = "{call PRC_ObtieneTODOS_Usuario()}";
    private static final String OBTENERUSUARIO = "{call PRC_OBTIENE_UN_USUARIO( ?)}";
    private static final String VALIDARUSUARIO = "{call PRC_VALIDA_USUARIO( ?, ?)}";
//</editor-fold>
    //<editor-fold desc="Atributos DB" defaultstate="collapsed">
    private static GestorUsuario instancia = null;
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private String URL_Servidor = "localhost";
    private static final String BASE_DATOS = "gaDB";
    private static final String DATABASE_DRIVER
            = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION
            = "jdbc:mysql://localhost/gaDB";

    //</editor-fold>
    //<editor-fold desc="Métodos" defaultstate="collapsed">
    public GestorUsuario() {
        try {
            Class.forName(DATABASE_DRIVER).newInstance();
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

    }

    public static GestorUsuario obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorUsuario();
        }
        return instancia;
    }

    public boolean validacionUsuario(int cedula, String contrasena) {
        boolean encontrado = false;
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx
                    = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);

            try (PreparedStatement stm = cnx.prepareStatement(VALIDARUSUARIO)) {
                stm.clearParameters();
                stm.setInt(1, cedula);
                stm.setString(2, contrasena);
                ResultSet rs = stm.executeQuery();
                encontrado = rs.next();

            }

        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            if (bd != null) {
                bd.closeConnection();
            }
        }
        return encontrado;

    }

    public void setUrlServidor(String nuevoURL) { // urlServidor
        URL_Servidor = nuevoURL;
    }

    @Override
    public String toString() {
        return super.toString();
    }

//</editor-fold>
}
