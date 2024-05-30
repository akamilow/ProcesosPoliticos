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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author camil
 */
@Entity
@Table(name = "Comuna")
@NamedQueries({
    @NamedQuery(name = "ComunaModel.findAll", query = "SELECT c FROM ComunaModel c"),
    @NamedQuery(name = "ComunaModel.findById", query = "SELECT c FROM ComunaModel c WHERE c.id = :id"),
    @NamedQuery(name = "ComunaModel.findByNombre", query = "SELECT c FROM ComunaModel c WHERE c.nombre = :nombre")})
public class ComunaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "comuna")
    private List<LocalvotacionModel> localvotacionModelList;
    @OneToMany(mappedBy = "comuna")
    private List<CandidatoModel> candidatoModelList;

    public ComunaModel() {
    }

    public ComunaModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<LocalvotacionModel> getLocalvotacionModelList() {
        return localvotacionModelList;
    }

    public void setLocalvotacionModelList(List<LocalvotacionModel> localvotacionModelList) {
        this.localvotacionModelList = localvotacionModelList;
    }

    public List<CandidatoModel> getCandidatoModelList() {
        return candidatoModelList;
    }

    public void setCandidatoModelList(List<CandidatoModel> candidatoModelList) {
        this.candidatoModelList = candidatoModelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComunaModel)) {
            return false;
        }
        ComunaModel other = (ComunaModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ude.poo.procesospoliticos.modelo.entidades.ComunaModel[ id=" + id + " ]";
    }
    
}
