/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.facturacion.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import ec.com.facturacion.beans.SessionBean;
 
import ec.com.facturacion.util.DataConnect;

/**
 *
 * @author epacheco
 */
public class LoginDAO {
    public static boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        HttpSession session = SessionBean.getSession();
        
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select usucodigo, percodigo, prscodigo, usunombre from facturacionelectronica.faceusuario where usunombre = ? and usuclave = MD5(?)");
            ps.setString(1, user);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                
                Integer usuCodigo = rs.getInt("usucodigo");
                Integer perCodigo = rs.getInt("percodigo");
                Integer prsCodigo = rs.getInt("prscodigo");
                String usuNombre = rs.getString("usunombre");
                
                session.setAttribute("usucodigo", usuCodigo);
                session.setAttribute("percodigo", perCodigo);
                session.setAttribute("prscodigo", prsCodigo);
                session.setAttribute("usunombre", usuNombre);
                
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return false;
    }
}
