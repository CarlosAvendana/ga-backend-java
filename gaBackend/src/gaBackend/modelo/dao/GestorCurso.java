package gaBackend.modelo.dao;

/**
 *
 * @author carlos
 */
public class GestorCurso {

    private static GestorCurso instancia = null;

    public static GestorCurso obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCurso();
        }
        return instancia;
    }

}
