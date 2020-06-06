/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendga.modelo;

import backendga.modelo.dao.GestorCarrera;
import backendga.modelo.dao.GestorCurso;
import backendga.modelo.dao.GestorUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Luis Felipe
 */
public class Model extends Observable {

    private Usuario user;
    
    private TablaCarrera tablaCarrera;
    private TablaCurso tablaCurso;
    
    //private ArrayList<Carrera> carreras;
    //private ArrayList<Curso> cursos;
    
    GestorCurso gestorCurso;
    GestorCarrera gestorCarrera;
    
    ComboBoxModel<String> CBCarrera;
    

    public Model() {
        this.user = new Usuario();
        this.gestorCarrera = new GestorCarrera();
        //this.carreras = new ArrayList();
        this.tablaCarrera = new TablaCarrera(new ArrayList());
        this.gestorCurso = new GestorCurso();
        //this.cursos = new ArrayList();
        this.tablaCurso = new TablaCurso(new ArrayList());
        this.CBCarrera = new DefaultComboBoxModel<>();
    }

    public Model(Usuario user) {
        this.user = user;
    }

    //------------------------------------------------------------
    //---------------------- MODEL USUARIO------------------------
    //------------------------------------------------------------
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public boolean validaUsuario(int id, String password) {
        boolean result = false;
        if (GestorUsuario.obtenerInstancia().validacionUsuario(id, password)) {
            result = true;
        }
        return result;
    }

    //------------------------------------------------------------
    //------------------- MODEL CARRERA---------------------------
    //------------------------------------------------------------
    public TablaCarrera getTablaCarrera() {
        return tablaCarrera;
    }

    public void setTablaCarrera(ArrayList<Carrera> tabla) {
        this.tablaCarrera = new TablaCarrera(tabla);
    }
    
    public void setCarreras(ArrayList<Carrera> carreras) {
        this.setTablaCarrera(carreras);
        this.commit();
    }

    public GestorCarrera getGestorCarrera() {
        return gestorCarrera;
    }

    public void setGestorCarrera(GestorCarrera gestorCarrera) {
        this.gestorCarrera = gestorCarrera;
    }

    //------------------------------------------------------------
    //-----------------------MODEL CURSO--------------------------
    //------------------------------------------------------------
    
     public TablaCurso getTablaCurso() {
        return tablaCurso;
    }

    public void setTablaCurso(ArrayList<Curso> tabla) {
        this.tablaCurso = new TablaCurso(tabla);
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.setTablaCurso(cursos);
        this.commit();
    }

    public GestorCurso getGestorCurso() {
        return gestorCurso;
    }

    public void setGestorCurso(GestorCurso gestor) {
        this.gestorCurso = gestor;
    }

    public ComboBoxModel<String> getCBCarrera() {
        return this.CBCarrera;
    }

    public void setCBCarrera(List<String> carreras) {
        this.CBCarrera = new DefaultComboBoxModel(carreras.toArray());
        this.commit();
    }
    
    
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

    public void commit() {
        setChanged();
        notifyObservers();
    }
}
