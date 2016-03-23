/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.virtualmedic.dao;

/**
 *
 * @author epacheco
 */
public class UsuarioDAO {
    private static final String NOMBRE_TABLA = "virtualmedic.vimeusuario";
    private Integer usuCodigo;
    private Integer prsCodigo;
    private Integer perCodigo;
    private String usuNombre;
    private String usuClave;
    private Boolean usuEstado;
    private String usuFechaRegistro;
    private String usuTema;

    public Integer getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public Integer getPrsCodigo() {
        return prsCodigo;
    }

    public void setPrsCodigo(Integer prsCodigo) {
        this.prsCodigo = prsCodigo;
    }

    public Integer getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Integer perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public Boolean getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Boolean usuEstado) {
        this.usuEstado = usuEstado;
    }

    public String getUsuFechaRegistro() {
        return usuFechaRegistro;
    }

    public void setUsuFechaRegistro(String usuFechaRegistro) {
        this.usuFechaRegistro = usuFechaRegistro;
    }

    public String getUsuTema() {
        return usuTema;
    }

    public void setUsuTema(String usuTema) {
        this.usuTema = usuTema;
    }

    public UsuarioDAO() {
    }

    public UsuarioDAO(Integer usuCodigo, Integer prsCodigo, Integer perCodigo, String usuNombre, String usuClave, Boolean usuEstado, String usuFechaRegistro, String usuTema) {
        this.usuCodigo = usuCodigo;
        this.prsCodigo = prsCodigo;
        this.perCodigo = perCodigo;
        this.usuNombre = usuNombre;
        this.usuClave = usuClave;
        this.usuEstado = usuEstado;
        this.usuFechaRegistro = usuFechaRegistro;
        this.usuTema = usuTema;
    }
    
    public Integer crearUsuario(UsuarioDAO usuarioDAO) throws Exception{
        Integer usuCodigoN = null;
        try {
                        
        } catch (Exception e) {
            throw new Exception(e);
        }
        
        return usuCodigoN;
    }
    
}
