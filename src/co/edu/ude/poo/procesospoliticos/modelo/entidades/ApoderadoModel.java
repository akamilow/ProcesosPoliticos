/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author camil
 */
@Entity
@Table(name = "Apoderado")
@NamedQueries({
    @NamedQuery(name = "ApoderadoModel.findAll", query = "SELECT a FROM ApoderadoModel a"),
    @NamedQuery(name = "ApoderadoModel.findByDni", query = "SELECT a FROM ApoderadoModel a WHERE a.dni = :dni"),
    @NamedQuery(name = "ApoderadoModel.findByRut", query = "SELECT a FROM ApoderadoModel a WHERE a.rut = :rut")})
public class ApoderadoModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "dni")
    private Integer dni;
    @Column(name = "RUT")
    private Integer rut;
    @OneToMany(mappedBy = "apoderadoModel")
    private List<MesavotacionModel> mesavotacionModelList;
    @JoinColumn(name = "dni", referencedColumnName = "dni", insertable = false, updatable = false)
    @OneToOne
    private CiudadanoModel ciudadanoModel;

    public ApoderadoModel() {
    }

    public ApoderadoModel(Integer dni) {
        this.dni = dni;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public List<MesavotacionModel> getMesavotacionModelList() {
        return mesavotacionModelList;
    }

    public void setMesavotacionModelList(List<MesavotacionModel> mesavotacionModelList) {
        this.mesavotacionModelList = mesavotacionModelList;
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
        if (!(object instanceof ApoderadoModel)) {
            return false;
        }
        ApoderadoModel other = (ApoderadoModel) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ude.poo.procesospoliticos.modelo.entidades.ApoderadoModel[ dni=" + dni + " ]";
    }
    
}
