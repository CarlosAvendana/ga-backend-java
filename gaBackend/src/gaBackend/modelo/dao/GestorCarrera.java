package gaBackend.modelo.dao;

import exceptions.GlobalException;
import exceptions.NoDataException;
import gaBackend.modelo.Carrera;
import gaBackend.modelo.Curso;
import static gaBackend.modelo.dao.Service.connection;
import static gaBackend.modelo.dao.Service.disconnect;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class GestorCarrera {

    private static GestorCarrera instancia = null;

    public static GestorCarrera obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCarrera();
        }
        return instancia;
    }

    private static final String INSERTARCARRERA = "{call PRC_INS_CARRERA( ?, ?, ?)}";
    private static final String BORRARCARRERA = "{call PRC_DEL_CARRERA(?)}";
    private static final String ACTUALIZARCARRERA = "{call PRC_UPD_CARRERA(?, ?, ?)}";
    private static final String LISTARCARRERAS = "{call PRC_ObtieneTODOS_CARRERA()}";
    //Falta el buscar Carrera

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
            pstmt.setString(2, carrera.getNombre());
            pstmt.setString(3, carrera.getTitulo());

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
                carreras.add(new Carrera(codigoB, tituloB, nombreB));
            }
            disconnect();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        return carreras;
    }
}
