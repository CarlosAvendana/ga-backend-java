package gaBackend.modelo.dao;

import exceptions.GlobalException;
import exceptions.NoDataException;
import gaBackend.modelo.Carrera;
import gaBackend.modelo.Curso;
import static gaBackend.modelo.dao.Service.connection;
import static gaBackend.modelo.dao.Service.disconnect;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Obando & Felipe Piedra
 */
public class GestorCarrera {

//<editor-fold desc="Atributos" defaultstate="collapsed">
    private static GestorCarrera instancia = null;
    private static final String INSERTARCARRERA = "{call PRC_INS_CARRERA( ?, ?, ?)}";
    private static final String BORRARCARRERA = "{call PRC_DEL_CARRERA(?)}";
    private static final String ACTUALIZARCARRERA = "{call PRC_UPD_CARRERA(?, ?, ?)}";
    private static final String LISTARCARRERAS = "{call PRC_ObtieneTODOS_CARRERA()}";
    private static final String OBTENERCARRERA = "{call PRC_OBTIENE_UNA_CARRERA( ?)}";

    //</editor-fold>
//<editor-fold desc="métodos" defaultstate="collapsed">
    public static GestorCarrera obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCarrera();
        }
        return instancia;
    }

    // C(reate)
    public void insertarCarrera(Carrera carrera) throws GlobalException, NoDataException, SQLException {
        try {
            connection();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = connection.prepareCall(INSERTARCARRERA);
            pstmt.setString(1, carrera.getCodigo());
            pstmt.setString(2, carrera.getTitulo());
            pstmt.setString(3, carrera.getNombre());

            boolean resultado = pstmt.execute();
            if (resultado == true) {
            }
        } catch (SQLException e) {

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                disconnect();
            } catch (SQLException e) {

            }
        }
    }

    //R(etrieve)
    public Carrera recuperarCarrera(String codigo) throws GlobalException, NoDataException {
        try {
            connection();
            PreparedStatement stm = connection.prepareStatement(OBTENERCARRERA);

            stm.clearParameters();

            stm.setString(1, codigo);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new Carrera(rs.getString("codigo"),
                            rs.getString("nombre"),
                            rs.getString("titulo"));
                } else {
                    System.err.println(String.format("No se puede localizar el registro: '%s'", codigo));
                }
            }
            disconnect();
            return null;
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
    }

    //U(pdate)
    public void actualizarCarrera(Carrera actCarrera) throws NoDataException, GlobalException, SQLException, ClassNotFoundException {
        try {
            connection();
            PreparedStatement stm = connection.prepareStatement(ACTUALIZARCARRERA);

            stm.clearParameters();

            stm.setString(1, actCarrera.getCodigo());
            stm.setString(2, actCarrera.getTitulo());
            stm.setString(3, actCarrera.getNombre());
            if (stm.executeUpdate() != 1) {
                throw new SQLException();
            }
            disconnect();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

    }

    //D(elete)
    public void eliminar(String codigo) throws GlobalException, NoDataException {
        try {
            connection();
            PreparedStatement stm = connection.prepareStatement(BORRARCARRERA);

            stm.clearParameters();

            stm.setString(1, codigo);

            if (stm.executeUpdate() != 1) {
                throw new SQLException();
            }
            disconnect();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

    }

    public List<Carrera> listarCarreras() throws NoDataException, GlobalException {
        List<Carrera> carreras = new ArrayList<>();
        try {
            connection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(LISTARCARRERAS);
            while (rs.next()) {
                String codigoB = rs.getString("codigo");
                String tituloB = rs.getString("titulo");
                String nombreB = rs.getString("nombre");
                carreras.add(new Carrera(codigoB, nombreB, tituloB));
            }
            disconnect();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        return carreras;
    }
//</editor-fold>
}
