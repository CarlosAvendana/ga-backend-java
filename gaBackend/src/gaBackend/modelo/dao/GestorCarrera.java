package gaBackend.modelo.dao;

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

}
