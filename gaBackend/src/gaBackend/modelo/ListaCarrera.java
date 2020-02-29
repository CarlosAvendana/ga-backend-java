package gaBackend.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class ListaCarrera {

    private final List<Carrera> listaCarrera;

    public ListaCarrera() {
        listaCarrera = new ArrayList<>();
    }

    public void agregar(Carrera nuevaCarrera) {
        listaCarrera.add(nuevaCarrera);
    }
    
//    public void actualizar (GestorCarrera gestor){
//    for(Carrera c:listaCarrera){
//    try{}
//    }
//    }

}
