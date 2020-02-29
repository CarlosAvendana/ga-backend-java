package gaBackend.modelo.dao;

import exceptions.GlobalException;
import exceptions.NoDataException;
import gaBackend.modelo.Curso;
import static gaBackend.modelo.dao.Service.connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class GestorCurso {
    
    
    private static final String INSERTARCURSO="{call PRC_INS_CURSO(?,?,?)}";
    private static final String BORRARCURSO="{call PRC_DEL_CURSO(?,?,?)}";
    private static final String ACTUALIZACURSO="{call PRC_UPD_CURSO(?,?,?)}";
    private static final String LISTARCURSOS="{?=call PRC_ObtieneTODOS_CURSO()}";
    
    private static GestorCurso instancia = null;

    public static GestorCurso obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCurso();
        }
        return instancia;
    }

    public List<Curso> listarCursos() throws NoDataException, GlobalException{
        List<Curso> cursos= new ArrayList<>();
                try {
            connection();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        
        return cursos;
    }
}
