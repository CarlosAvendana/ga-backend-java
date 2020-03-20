/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendga.modelo;

import java.util.Observable;

/**
 *
 * @author Luis Felipe
 */
public class Model extends Observable {

    private Usuario user;

    public Model() {
        this.user = new Usuario();
    }

    public Model(Usuario user) {
        this.user = user;
    }
    
    

}
