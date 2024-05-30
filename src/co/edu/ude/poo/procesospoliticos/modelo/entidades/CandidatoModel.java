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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author camil
 */
@Entity
@Table(name = "Candidato")
@NamedQueries({
    @NamedQuery(name = "CandidatoModel.findAll", query = "SELECT c FROM CandidatoModel c"),
    @NamedQuery(name = "CandidatoModel.findByDni", query = "SELECT c FROM CandidatoModel c WHERE c.dni = :dni"),
    @NamedQuery(name = "CandidatoModel.findByCategoria", query = "SELECT c FROM CandidatoModel c WHERE c.categoria = :categoria")})
public class CandidatoModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "dni")
    private Integer dni;
    @Column(name = "categoria")
    private String categoria;
    @JoinColumn(name = "dni", referencedColumnName = "dni", insertable = false, updatable = false)
    @OneToOne
    private CiudadanoModel ciudadanoModel;
    @JoinColumn(name = "comuna", referencedColumnName = "id")
    @ManyToOne
    private ComunaModel comuna;
    @JoinColumn(name = "partido", referencedColumnName = "id")
    @ManyToOne
    private PartidoModel partido;

    public CandidatoModel() {
    }

    public CandidatoModel(Integer dni) {
        this.dni = dni;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public CiudadanoModel getCiudadanoModel() {
        return ciudadanoModel;
    }

    public void setCiudadanoModel(CiudadanoModel ciudadanoModel) {
        this.ciudadanoModel = ciudadanoModel;
    }

    public ComunaModel getComuna() {
        return comuna;
    }

    public void setComuna(ComunaModel comuna) {
        this.comuna = comuna;
    }

    public PartidoModel getPartido() {
        return partido;
    }

    public void setPartido(PartidoModel partido) {
        this.partido = partido;
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
        if (!(object instanceof CandidatoModel)) {
            return false;
        }
        CandidatoModel other = (CandidatoModel) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ude.poo.procesospoliticos.modelo.entidades.CandidatoModel[ dni=" + dni + " ]";
    }
    
}
