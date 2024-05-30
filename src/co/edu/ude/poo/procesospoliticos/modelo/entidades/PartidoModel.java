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
@Table(name = "Partido")
@NamedQueries({
    @NamedQuery(name = "PartidoModel.findAll", query = "SELECT p FROM PartidoModel p"),
    @NamedQuery(name = "PartidoModel.findById", query = "SELECT p FROM PartidoModel p WHERE p.id = :id"),
    @NamedQuery(name = "PartidoModel.findByNombre", query = "SELECT p FROM PartidoModel p WHERE p.nombre = :nombre")})
public class PartidoModel implements Serializable {

    @OneToMany(mappedBy = "partido")
    private List<CandidatoModel> candidatoModelList;

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;

    public PartidoModel() {
    }

    public PartidoModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof PartidoModel)) {
            return false;
        }
        PartidoModel other = (PartidoModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ude.poo.procesospoliticos.modelo.entidades.PartidoModel[ id=" + id + " ]";
    }

    public List<CandidatoModel> getCandidatoModelList() {
        return candidatoModelList;
    }

    public void setCandidatoModelList(List<CandidatoModel> candidatoModelList) {
        this.candidatoModelList = candidatoModelList;
    }
    
}
