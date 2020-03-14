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
public class TablaCarrera extends AbstractTableModel {

    private ArrayList<Carrera> carreras;
    private ArrayList<String> codigos;

    public TablaCarrera(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public ArrayList<String> getCodigos() {
        return codigos;
    }

    public void setCodigos(ArrayList<String> codigos) {
        this.codigos = codigos;
    }
    

    @Override
    public int getRowCount() {
        return this.carreras.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carrera carrera = carreras.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = carrera.getCodigo();
                break;
            case 1:
                value = carrera.getNombre();
                break;
            case 2:
                value = carrera.getTitulo();
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
                name = "Nombre";
                break;
            case 2:
                name = "Titulo";
                break;
        }
        return name;
    }

    public Carrera getRowAt(int row) {
        return carreras.get(row);
    }
    public void listarCodigosCarrera(){
        codigos = new ArrayList();
        for(int i=0;i<carreras.size();i++)
            codigos.add(carreras.get(i).getCodigo());
    }
}
