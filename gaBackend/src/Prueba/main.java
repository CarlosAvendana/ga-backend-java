package Prueba;

import exceptions.GlobalException;
import exceptions.NoDataException;
import gaBackend.modelo.Carrera;
import gaBackend.modelo.dao.GestorCarrera;
import java.sql.SQLException;

/**
 *
 * @author Carlos Obando & Felipe Piedra
 */
public class main {

    public static void main(String[] args) throws GlobalException, NoDataException, SQLException, ClassNotFoundException {

//        Carrera carrera1 = new Carrera("X", "X", "X");
//        GestorCarrera.obtenerInstancia().insertarCarrera(carrera1);
//        Carrera carrera2 = new Carrera("X", "X", "X2");
//        GestorCarrera.obtenerInstancia().actualizarCarrera(carrera2);
        Carrera carreraNueva = GestorCarrera.obtenerInstancia().recuperarCarrera("EIF");
        System.out.println(carreraNueva.toString());
    }

}
