package nproyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLUsuarios extends Conexion {

    public boolean registrar(usuarios urs) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuarios (USUARIO, PASSWORD, NOMBREU, CORREO, ID_TIPO) VALUE (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, urs.getUSUARIO());
            ps.setString(2, urs.getPASSWORD());
            ps.setString(3, urs.getNOMBREU());
            ps.setString(4, urs.getCORREO());
            ps.setInt(5, urs.getID_TIPO());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public boolean login( usuarios usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT u.USUARIOSID, u.USUARIO ,u.PASSWORD, u.NOMBREU, u.ID_TIPO, t.NOMBRET FROM usuarios AS u INNER JOIN tipo_usuarios AS t ON u.ID_TIPO=t.ID WHERE USUARIO = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUSUARIO());
            rs = ps.executeQuery();
            
            if(rs.next()){
                 if(usr.getPASSWORD().equals(rs.getString(3))){
                     
                     String sqlUpdate = "UPDATE usuarios SET LAST_SESSION = ? WHERE USUARIOSID=?";
                     
                     ps = con.prepareStatement(sqlUpdate);
                     ps.setString(1, usr.getLAST_SESSION());
                     ps.setInt(2, rs.getInt(1));
                     ps.execute();
                     
                     usr.setUSUARIOSID(rs.getInt(1));
                     usr.setNOMBREU(rs.getString(4));
                     usr.setID_TIPO(rs.getInt(5));
                     usr.setNOMBRET(rs.getString(6));
                     return true;
                      
                 }else{
                     return false;
                 }
               
            }
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(SQLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public int existeusuario(String USUARIO) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT count(USUARIOSID) FROM usuarios WHERE USUARIO = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, USUARIO);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(SQLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }

    }
    
    public boolean esEmail(String correo) {
		
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		
        Matcher mather = pattern.matcher(correo);
		
        return mather.find();
		
}

}
