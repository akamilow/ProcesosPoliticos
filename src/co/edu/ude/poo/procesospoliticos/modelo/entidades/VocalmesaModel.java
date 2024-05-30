/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author camil
 */
@Entity
@Table(name = "Vocalmesa")
@NamedQueries({
    @NamedQuery(name = "VocalmesaModel.findAll", query = "SELECT v FROM VocalmesaModel v"),
    @NamedQuery(name = "VocalmesaModel.findByDni", query = "SELECT v FROM VocalmesaModel v WHERE v.dni = :dni"),
    @NamedQuery(name = "VocalmesaModel.findByRol", query = "SELECT v FROM VocalmesaModel v WHERE v.rol = :rol")})
public class VocalmesaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "dni")
    private Integer dni;
    @Column(name = "rol")
    private String rol;
    @JoinColumn(name = "dni", referencedColumnName = "dni", insertable = false, updatable = false)
    @OneToOne
    private CiudadanoModel ciudadanoModel;

    public VocalmesaModel() {
    }

    public VocalmesaModel(Integer dni) {
        this.dni = dni;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public CiudadanoModel getCiudadanoModel() {
        return ciudadanoModel;
    }

    public void setCiudadanoModel(CiudadanoModel ciudadanoModel) {
        this.ciudadanoModel = ciudadanoModel;
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
        if (!(object instanceof VocalmesaModel)) {
            return false;
        }
        VocalmesaModel other = (VocalmesaModel) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalmesaModel[ dni=" + dni + " ]";
    }
    
}
