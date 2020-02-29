package Prueba;

import exceptions.GlobalException;
import exceptions.NoDataException;
import gaBackend.modelo.Carrera;
import gaBackend.modelo.Curso;
import gaBackend.modelo.dao.GestorCarrera;
import gaBackend.modelo.dao.GestorCurso;
import java.util.List;

/**
 *
 * @author carlos
 */
public class main {

    public static void main(String[] args) throws GlobalException, NoDataException {

        Carrera carrera1 = new Carrera("X", "X", "X");
        List<Carrera> lista = GestorCarrera.obtenerInstancia().listarCarreras();
        System.out.println(lista.toString());
        
        List<Curso> listC = GestorCurso.obtenerInstancia().listarCursos();
        System.out.println(listC.toString());
    }

}
