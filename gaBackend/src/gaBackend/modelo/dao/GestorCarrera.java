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

    private static final String INSERTARCARRERA = "{call PRC_INS_CARRERA( ?, ?, ?)}";
    private static final String BORRARCARRERA = "{call PRC_DEL_CARRERA(?)}";
    private static final String ACTUALIZARCARRERA = "{call PRC_UPD_CARRERA(?, ?, ?)}";
    private static final String OBTIENETODASCARRERAS = "{?=call PRC_ObtieneTODOS_CARRERA()}";
    
}
