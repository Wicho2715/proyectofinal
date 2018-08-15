 
package nproyecto;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    private final String base = "base_de_datos";
    private final String user = "wicho";
    private final String password = "12345";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    Connection con = null;
    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con =  (Connection) DriverManager.getConnection(url, user, password);
                System.out.println("CONEXION ESTABLECIDA A LA BASE DE DATOS");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERROR AL CONECTAR A LA BASE DE DATOS"+ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
