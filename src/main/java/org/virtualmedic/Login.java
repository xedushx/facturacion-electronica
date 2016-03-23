/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.virtualmedic;

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
import org.virtualmedic.beans.SessionBean;
 
import org.virtualmedic.dao.LoginDAO;

/**
 *
 * @author epacheco
 */
@Named(value = "login")
@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;
     
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
 
    //validate login
    public void validateUsernamePassword(ActionEvent actionEvent) {
        boolean valid = LoginDAO.validate(user, pwd);
        if (valid) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("principal/principal.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
//            return "principal";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Usuario o Clave Incorrectos",
                            "Por favor ingrese su usuario y clave nuevamente"));
//            return "login";
        }
    }
 
    //logout event, invalidate session
    public void logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/virtualmedic/faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return "login";
    }
    
}
