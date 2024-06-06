/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author camil
 */
@Entity
@Table(name = "Usuario")
@NamedQueries({
    @NamedQuery(name = "UsuarioModel.findAll", query = "SELECT u FROM UsuarioModel u"),
    @NamedQuery(name = "UsuarioModel.findByDni", query = "SELECT u FROM UsuarioModel u WHERE u.dni = :dni"),
    @NamedQuery(name = "UsuarioModel.findByContrasena", query = "SELECT u FROM UsuarioModel u WHERE u.contrasena = :contrasena")})
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "dni")
    private Integer dni;
    @Column(name = "contrasena")
    private String contrasena;

    public UsuarioModel() {
    }

    public UsuarioModel(Integer dni) {
        this.dni = dni;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioModel)) {
            return false;
        }
        UsuarioModel other = (UsuarioModel) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ude.poo.procesospoliticos.modelo.entidades.UsuarioModel[ dni=" + dni + " ]";
    }
    
}
