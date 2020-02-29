package gaBackend.modelo.dao;

/**
 *
 * @author carlos
 */
public class GestorCurso {
    
    private static final String BUSCARCURSO="";
    private static final String INSERTARCURSO="";
    private static final String BORRARCURSO="";
    private static final String ACTUALIZACURSO="";
    private static final String LISTARCURSOS="";
    
    private static GestorCurso instancia = null;

    public static GestorCurso obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCurso();
        }
        return instancia;
    }

}
