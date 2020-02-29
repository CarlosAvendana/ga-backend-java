package gaBackend.modelo.dao;

import exceptions.GlobalException;
import exceptions.NoDataException;
import gaBackend.modelo.Curso;
import static gaBackend.modelo.dao.Service.connection;
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
    private static final String LISTARCURSOS = "{?=call PRC_ObtieneTODOS_CURSOS()}";

    private static GestorCurso instancia = null;

    public static GestorCurso obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCurso();
        }
        return instancia;
    }

//    `codigo` VARCHAR(10) NOT NULL,
//  `carrera_codigo` VARCHAR(10) NOT NULL,
//  `anio` VARCHAR(15) NULL,
//  `ciclo` VARCHAR(15) NULL,
//  `nombre` VARCHAR(100) NULL,
//  `creditos` INT NULL,
//  `horas_semanales` INT NULL,
    
    public List<Curso> listarCursos() throws NoDataException, GlobalException {
        List<Curso> cursos = new ArrayList<>();
        try {
            connection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(LISTARCURSOS);
            while(rs.next()){
                String codigoB = rs.getString("codigo");
                String carrera_codigoB = rs.getString("carrera_codigo");
                String anioB = rs.getString("anio");
                String cicloB = rs.getString("ciclo");
                String nombreB = rs.getString("nombre");
                int creditosB = rs.getInt("creditos");
                int horasB = rs.getInt("horas_semanales");
                
                cursos.add(new Curso(codigoB,carrera_codigoB,anioB,cicloB,nombreB,creditosB,horasB));
            }    
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        } 
        return cursos;
    }
}
