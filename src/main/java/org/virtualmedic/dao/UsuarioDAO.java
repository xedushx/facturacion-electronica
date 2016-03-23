/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.virtualmedic.dao;

import org.virtualmedic.dto.UsuarioDTO;

/**
 *
 * @author epacheco
 */
public class UsuarioDAO {
    
    public static Integer crearUsuario(UsuarioDTO usuarioDTO) throws Exception{
        Integer usuCodigoN = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO ").append(UsuarioDTO.NOMBRE_TABLA).append(" ("+UsuarioDTO.CAMPOS_INSERT+") ");
            sql.append("VALUES (").append("nextval('" + UsuarioDTO.SECUENCIA + "')");
            sql.append(",").append(usuarioDTO.getPrsCodigo());
            sql.append(",").append(usuarioDTO.getPerCodigo());
            sql.append(",'").append(usuarioDTO.getUsuNombre()).append("'");
            sql.append(",MD5('").append(usuarioDTO.getUsuClave()).append("')");
            sql.append(",").append(usuarioDTO.getUsuEstado());
            sql.append(",'").append(usuarioDTO.getUsuFechaRegistro()).append("'");
            sql.append(",'").append(usuarioDTO.getUsuTema()).append("');");
        } catch (Exception e) {
            throw new Exception(e);
        }
        
        return usuCodigoN;
    }
    
}
