package gaBackend.modelo.dao;

import exceptions.GlobalException;
import exceptions.NoDataException;
import gaBackend.modelo.Usuario;
import static gaBackend.modelo.dao.Service.connection;
import static gaBackend.modelo.dao.Service.disconnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GestorUsuario {

//<editor-fold desc="Atributos" defaultstate="collapsed">
    private static GestorUsuario instancia = null;
    private static final String LISTARUSUARIOS = "{call PRC_ObtieneTODOS_Usuario()}";
    private static final String OBTENERUSUARIO = "{call PRC_OBTIENE_UN_USUARIO( ?)}";
    private static final String VALIDARUSUARIO = "{call PRC_VALIDA_USUARIO( ?, ?)}";

    //</editor-fold>
//<editor-fold desc="métodos" defaultstate="collapsed">
    public static GestorUsuario obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorUsuario();
        }
        return instancia;
    }

    public static Boolean validacionUsuario(int cedula, String contrasena)
            throws GlobalException, NoDataException {
        boolean status = false;
        try {
            connection();
            PreparedStatement stm = connection.prepareStatement(VALIDARUSUARIO);

            stm.clearParameters();

            stm.setInt(1, cedula);
            stm.setString(2, contrasena);

            try (ResultSet rs = stm.executeQuery()) {
                status = rs.next();
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

//R(etrieve)
    public Usuario recuperarUsuario(String codigo)
            throws GlobalException, NoDataException {
        try {
            connection();
            PreparedStatement stm = connection.prepareStatement(OBTENERUSUARIO);

            stm.clearParameters();

            stm.setString(1, codigo);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(rs.getInt("cedula"),
                            rs.getString("contrasena"),
                            rs.getString("nombre"));
                } else {
                    System.err.println(String.format("No se puede localizar el registro: '%s'", codigo));
                }
            }
            disconnect();
            return null;
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
    }

    public List<Usuario> listarUsuarios()
            throws NoDataException, GlobalException {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            connection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(LISTARUSUARIOS);
            while (rs.next()) {
                int cedulaB = rs.getInt("cedula");
                String contrasenaB = rs.getString("contrasena");
                String nombreB = rs.getString("nombre");
                usuarios.add(new Usuario(cedulaB, contrasenaB, nombreB));
            }
            disconnect();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        return usuarios;
    }
//</editor-fold>

}
