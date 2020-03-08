package backendga.modelo.dao;

import backendga.database.managers.DBManager;
import backendga.modelo.Curso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorCurso {

    // <editor-fold defaultstate="collapsed" desc="Atibutos DB">
    private static GestorCurso instancia = null;
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
    private static final String INSERTARCURSO = "{call PRC_INS_CURSO(?,?,?,?,?,?,?)}";
    private static final String BORRARCURSO = "{call PRC_DEL_CURSO(?)}";
    private static final String ACTUALIZACURSO = "{call PRC_UPD_CURSO(?,?,?,?,?,?,?)}";
    private static final String LISTARCURSOS = "{call PRC_ObtieneTODOS_CURSOS()}";
    private static final String OBTENERCURSO = "{call PRC_OBTIENE_UN_CURSO(?)}";

    //</editor-fold>
    //<editor-fold desc="métodos" defaultstate="collapsed">
    public GestorCurso() {
        try {
            Class.forName(DATABASE_DRIVER).newInstance();

        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static GestorCurso obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCurso();
        }
        return instancia;
    }

    // C(reate)
    public void insertarCurso(String codigo_, String carrera_codigo_, String anio_, String ciclo_,
            String nombre_, int creditos_, int horas_semanales_) {
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx
                    = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);
            try (PreparedStatement stm = cnx.prepareStatement(INSERTARCURSO)) {
                stm.clearParameters();
                stm.setString(1, codigo_);
                stm.setString(2, carrera_codigo_);
                stm.setString(3, anio_);
                stm.setString(4, ciclo_);
                stm.setString(5, nombre_);
                stm.setInt(6, creditos_);
                stm.setInt(7, horas_semanales_);

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
    public Curso recuperarCurso(String codigo) {
        Curso _curso = null;
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx
                    = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);

            try (PreparedStatement stm = cnx.prepareStatement(OBTENERCURSO)) {
                stm.clearParameters();
                stm.setString(1, codigo);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    _curso = new Curso(rs.getString("codigo"), rs.getString("carrera_codigo"), rs.getString("anio"),
                            rs.getString("ciclo"), rs.getString("nombre"),
                            rs.getInt("creditos"), rs.getInt("horas_semanales"));
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
        return _curso;
    }

    //U(pdate)
    public boolean actualizarCurso(String codigo_, String carrera_codigo_, String anio_, String ciclo_,
            String nombre_, int creditos_, int horas_semanales_) {
        boolean exito = false;
        int registrosActualizados = 0;
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx
                    = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);
            try (PreparedStatement stm = cnx.prepareStatement(ACTUALIZACURSO)) {
                stm.clearParameters();

                stm.setString(1, codigo_);
                stm.setString(2, carrera_codigo_);
                stm.setString(3, anio_);
                stm.setString(4, ciclo_);
                stm.setString(5, nombre_);
                stm.setInt(6, creditos_);
                stm.setInt(7, horas_semanales_);

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
    public boolean eliminarCurso(String codigo) {
        boolean exito = false;
        int registrosActualizados = 0;
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx
                    = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);
            try (PreparedStatement stm = cnx.prepareStatement(BORRARCURSO)) {
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

    public List<Curso> listarCurso() {
        List<Curso> array_cursos = new ArrayList<>();
        try (Connection cnx = DriverManager.getConnection(
                CONEXION, LOGIN, PASSWORD);
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(LISTARCURSOS)) {
            while (rs.next()) {

                String codigo = rs.getString("codigo");
                String carrera_codigo = rs.getString("carrera_codigo");
                String anio = rs.getString("anio");
                String ciclo = rs.getString("ciclo");
                String nombre = rs.getString("nombre");
                int creditos = rs.getInt("creditos");
                int horas_semanales = rs.getInt("horas_semanales");

                array_cursos.add(new Curso(codigo, carrera_codigo, anio,
                        ciclo, nombre,
                        creditos, horas_semanales));
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return array_cursos;
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
