package backendga.modelo.dao;

import backendga.database.managers.DBManager;
import backendga.modelo.Carrera;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorCarrera {

    // <editor-fold defaultstate="collapsed" desc="Atibutos DB">
    private static GestorCarrera instancia = null;
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private String URL_Servidor = "localhost";
    private static final String BASE_DATOS = "gaDB";
    private static final String DATABASE_DRIVER
            = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION
            = "jdbc:mysql://localhost/gaDB";

    // </editor-fold>
    //<editor-fold desc="Procedimientos" defaultstate="collapsed">
    private static final String INSERTARCARRERA = "{call PRC_INS_CARRERA( ?, ?, ?)}";
    private static final String BORRARCARRERA = "{call PRC_DEL_CARRERA(?)}";
    private static final String ACTUALIZARCARRERA = "{call PRC_UPD_CARRERA(?, ?, ?)}";
    private static final String LISTARCARRERAS = "{call PRC_ObtieneTODOS_CARRERA()}";
    private static final String OBTENERCARRERA = "{call PRC_OBTIENE_UNA_CARRERA( ?)}";

    //</editor-fold>
    //<editor-fold desc="métodos" defaultstate="collapsed">
    public GestorCarrera() {
        try {
            Class.forName(DATABASE_DRIVER).newInstance();

        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static GestorCarrera obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCarrera();
        }
        return instancia;
    }

    // C(reate)
    public void insertarCarrera(String cod, String nom, String titu) {
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx
                    = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);
            try (PreparedStatement stm = cnx.prepareStatement(INSERTARCARRERA)) {
                stm.clearParameters();
                stm.setString(1, cod);
                stm.setString(2, titu);
                stm.setString(3, nom);
                stm.executeUpdate();
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
    }

    //R(etrieve)
    public Carrera recuperarCarrera(String codigo) {
        Carrera _carrera = null;
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx
                    = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);

            try (PreparedStatement stm = cnx.prepareStatement(OBTENERCARRERA)) {
                stm.clearParameters();
                stm.setString(1, codigo);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    _carrera = new Carrera(rs.getString("codigo"), rs.getString("titulo"), rs.getString("nombre"));
                }
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
        return _carrera;
    }

    //U(pdate)
    public boolean actualizarCarrera(String cod, String nom, String titu) {
        boolean exito = false;
        int registrosActualizados = 0;
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx
                    = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);
            try (PreparedStatement stm = cnx.prepareStatement(ACTUALIZARCARRERA)) {
                stm.clearParameters();

                stm.setString(1, cod);
                stm.setString(2, titu);
                stm.setString(3, nom);

                registrosActualizados = stm.executeUpdate();

                exito = registrosActualizados == 1;
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
        return exito;
    }

    //D(elete)
    public boolean eliminarCarrera(String codigo) {
        boolean exito = false;
        int registrosActualizados = 0;
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx
                    = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);
            try (PreparedStatement stm = cnx.prepareStatement(BORRARCARRERA)) {
                stm.clearParameters();
                stm.setString(1, codigo);
                registrosActualizados = stm.executeUpdate();
                exito = registrosActualizados == 1;
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
        return exito;
    }

    public List<Carrera> listarCarreras() {
        List<Carrera> array_Carreras = new ArrayList<>();
        try (Connection cnx = DriverManager.getConnection(
                CONEXION, LOGIN, PASSWORD);
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(LISTARCARRERAS)) {
            while (rs.next()) {

                String _cod = rs.getString("codigo");
                String _nom = rs.getString("nombre");
                String _tit = rs.getString("titulo");

                array_Carreras.add(new Carrera(_cod, _nom, _tit));
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return array_Carreras;
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
