/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Ciudadano")
@NamedQueries({
    @NamedQuery(name = "CiudadanoModel.findAll", query = "SELECT c FROM CiudadanoModel c"),
    @NamedQuery(name = "CiudadanoModel.findByDni", query = "SELECT c FROM CiudadanoModel c WHERE c.dni = :dni"),
    @NamedQuery(name = "CiudadanoModel.findByEdad", query = "SELECT c FROM CiudadanoModel c WHERE c.edad = :edad"),
    @NamedQuery(name = "CiudadanoModel.findByNombre", query = "SELECT c FROM CiudadanoModel c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CiudadanoModel.findByGenero", query = "SELECT c FROM CiudadanoModel c WHERE c.genero = :genero")})
public class CiudadanoModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dni")
    private Integer dni;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "genero")
    private String genero;
    @OneToOne(mappedBy = "ciudadanoModel")
    private VocalmesaModel vocalmesaModel;
    @OneToOne(mappedBy = "ciudadanoModel")
    private ApoderadoModel apoderadoModel;
    @OneToMany(mappedBy = "ciudadano")
    private List<VotoModel> votoModelList;
    @OneToOne(mappedBy = "ciudadanoModel")
    private CandidatoModel candidatoModel;

    public CiudadanoModel() {
    }

    public CiudadanoModel(Integer dni) {
        this.dni = dni;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public VocalmesaModel getVocalmesaModel() {
        return vocalmesaModel;
    }

    public void setVocalmesaModel(VocalmesaModel vocalmesaModel) {
        this.vocalmesaModel = vocalmesaModel;
    }

    public ApoderadoModel getApoderadoModel() {
        return apoderadoModel;
    }

    public void setApoderadoModel(ApoderadoModel apoderadoModel) {
        this.apoderadoModel = apoderadoModel;
    }

    public List<VotoModel> getVotoModelList() {
        return votoModelList;
    }

    public void setVotoModelList(List<VotoModel> votoModelList) {
        this.votoModelList = votoModelList;
    }

    public CandidatoModel getCandidatoModel() {
        return candidatoModel;
    }

    public void setCandidatoModel(CandidatoModel candidatoModel) {
        this.candidatoModel = candidatoModel;
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
        if (!(object instanceof CiudadanoModel)) {
            return false;
        }
        CiudadanoModel other = (CiudadanoModel) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ude.poo.procesospoliticos.modelo.entidades.CiudadanoModel[ dni=" + dni + " ]";
    }
    
}
