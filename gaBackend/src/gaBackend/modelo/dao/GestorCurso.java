package gaBackend.modelo.dao;

import exceptions.GlobalException;
import exceptions.NoDataException;
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
 * @author carlos
 */
public class GestorCurso {

    private static final String INSERTARCURSO = "{call PRC_INS_CURSO(?,?,?)}";
    private static final String BORRARCURSO = "{call PRC_DEL_CURSO(?,?,?)}";
    private static final String ACTUALIZACURSO = "{call PRC_UPD_CURSO(?,?,?)}";
    private static final String LISTARCURSOS = "{call PRC_ObtieneTODOS_CURSOS()}";

    private static GestorCurso instancia = null;

    public static GestorCurso obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCurso();
        }
        return instancia;
    }

    public void insertarCurso(Curso curso) throws GlobalException, NoDataException {
        try {
            connection();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;
        try {
            pstmt = connection.prepareCall(INSERTARCURSO);
            pstmt.setString(1, curso.getCodigo());
            pstmt.setString(2, curso.getCarrera_codigo());
            pstmt.setString(3, curso.getAnio());
            pstmt.setString(4, curso.getCiclo());
            pstmt.setString(5, curso.getNombre());
            pstmt.setInt(6, curso.getCreditos());
            pstmt.setInt(7, curso.getHoras_semanales());

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

    public void actualizarCurso(Curso curso) throws NoDataException, GlobalException, SQLException {
        try {
            connection();
            PreparedStatement stm = connection.prepareStatement(ACTUALIZACURSO);

            stm.clearParameters();

            stm.setString(1, curso.getCodigo());
            stm.setString(2, curso.getCarrera_codigo());
            stm.setString(3, curso.getAnio());
            stm.setString(4, curso.getCiclo());
            stm.setString(5, curso.getNombre());
            stm.setInt(6, curso.getCreditos());
            stm.setInt(7, curso.getHoras_semanales());
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
    
    public void eliminarCurso(String codigo) throws GlobalException, NoDataException{
    try {
            connection();
            PreparedStatement stm = connection.prepareStatement(BORRARCURSO);

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

    public List<Curso> listarCursos() throws GlobalException, NoDataException {
        List<Curso> cursos = new ArrayList<>();
        try {
            connection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(LISTARCURSOS);
            while (rs.next()) {
                String codigoB = rs.getString("codigo");
                String carrera_codigoB = rs.getString("carrera_codigo");
                String anioB = rs.getString("anio");
                String cicloB = rs.getString("ciclo");
                String nombreB = rs.getString("nombre");
                int creditosB = rs.getInt("creditos");
                int horasB = rs.getInt("horas_semanales");

                cursos.add(new Curso(codigoB, carrera_codigoB, anioB, cicloB, nombreB, creditosB, horasB));
            }
            disconnect();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        return cursos;
    }
}
