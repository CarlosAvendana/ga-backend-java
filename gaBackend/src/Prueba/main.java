package Prueba;

import exceptions.GlobalException;
import exceptions.NoDataException;
import gaBackend.modelo.Carrera;
import gaBackend.modelo.dao.GestorCarrera;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author carlos
 */
public class main {
    
    public static void main(String[] args) throws GlobalException, NoDataException, SQLException, ClassNotFoundException {

//        Carrera carrera1 = new Carrera("X", "X", "X");
//        GestorCarrera.obtenerInstancia().insertarCarrera(carrera1);
//        Carrera carrera2 = new Carrera("X", "X", "X2");
//        GestorCarrera.obtenerInstancia().actualizarCarrera(carrera2);
        GestorCarrera.obtenerInstancia().eliminar("X");
        List<Carrera> lista = GestorCarrera.obtenerInstancia().listarCarreras();
        System.out.println(lista.toString());
        
    }
    
}
