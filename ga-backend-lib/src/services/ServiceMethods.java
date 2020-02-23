/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luis Felipe
 */
public class ServiceMethods extends Service {

    private static ServiceMethods instancia = null;

    public ServiceMethods() {
        try {
            Class.forName(DATABASE_DRIVER).newInstance();
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static ServiceMethods getInstance() {
        if (instancia == null) {
            instancia = new ServiceMethods();
        }
        return instancia;
    }

}
