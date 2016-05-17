/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.facturacion.beans;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author epacheco
 */
public class SessionBean {
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }
 
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }
    
    public static Integer getCodigoUsuario() {
        HttpSession session = getSession();
        if (session != null)
            return Integer.valueOf(session.getAttribute("usucodigo").toString());
        else
            return null;
    }
    
    public static Integer getCodigoPersona() {
        HttpSession session = getSession();
        if (session != null)
            return Integer.valueOf(session.getAttribute("prscodigo").toString());
        else
            return null;
    }
    
    public static Integer getCodigoPerfil() {
        HttpSession session = getSession();
        if (session != null)
            return Integer.valueOf(session.getAttribute("percodigo").toString());
        else
            return null;
    }
    
    public static String getNombreUsuario() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("usunombre").toString();
    }
}
