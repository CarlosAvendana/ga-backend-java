/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendga.modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luis Felipe
 */
public class TablaCurso extends AbstractTableModel {

    private ArrayList<Curso> cursos;

    public TablaCurso(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public int getRowCount() {
        return cursos.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    public Curso getRowAt(int row){
        return cursos.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Curso user = cursos.get(rowIndex);
        Object value = null;

        switch (columnIndex) {
            case 0:
                value = user.getCodigo();
                break;
            case 1:
                value = user.getCarrera_codigo();
                break;
            case 2:
                value = user.getAnio();
                break;
            case 3:
                value = user.getCiclo();
                break;
            case 4:
                value = user.getNombre();
                break;
            case 5:
                value = user.getCreditos();
                break;
            case 6:
                value = user.getHoras_semanales();
                break;
        }
        return value;
    }

    @Override
    public String getColumnName(int column) {
        String name = "???";
        switch (column) {
            case 0:
                name = "Codigo";
                break;
            case 1:
                name = "Carrera";
                break;
            case 2:
                name = "Anio";
                break;
            case 3:
                name = "Ciclo";
                break;
            case 4:
                name = "Nombre";
                break;
            case 5:
                name = "Creditos";
                break;
            case 6:
                name = "Horas Semanales";
                break;
        }
        return name;
    }
}
