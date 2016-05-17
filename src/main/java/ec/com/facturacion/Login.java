/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.facturacion;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import ec.com.facturacion.beans.SessionBean;
 
import ec.com.facturacion.dao.LoginDAO;

/**
 *
 * @author epacheco
 */
@Named(value = "login")
@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;
    private String version = "1.0-SNAPSHOT";
    
    private String pwd;
    private String msg;
    private String user;
 
    public String getPwd() {
        return pwd;
    }
 
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
 
    public String getUser() {
        return user;
    }
 
    public void setUser(String user) {
        this.user = user;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
 
    //validate login
    public String validateUsernamePassword(ActionEvent actionEvent) {
        boolean valid = LoginDAO.validate(user, pwd);
        if (valid) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("principal/principal.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "principal";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Usuario o Clave Incorrectos",
                            "Por favor ingrese su usuario y clave nuevamente"));
            return "login";
        }
    }
 
    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/facturacion-electronica/faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "login";
    }
    
}
