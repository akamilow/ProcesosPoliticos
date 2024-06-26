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
import javax.persistence.Table;

/**
 *
 * @author camil
 */
@Entity
@Table(name = "Voto")
@NamedQueries({
    @NamedQuery(name = "VotoModel.findAll", query = "SELECT v FROM VotoModel v"),
    @NamedQuery(name = "VotoModel.findById", query = "SELECT v FROM VotoModel v WHERE v.id = :id")})
public class VotoModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "candidato", referencedColumnName = "dni")
    @ManyToOne
    private CandidatoModel candidato;
    @JoinColumn(name = "ciudadano", referencedColumnName = "dni")
    @ManyToOne
    private CiudadanoModel ciudadano;
    @JoinColumn(name = "mesa", referencedColumnName = "numero")
    @ManyToOne
    private MesavotacionModel mesa;

    public VotoModel() {
    }

    public VotoModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CandidatoModel getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoModel candidato) {
        this.candidato = candidato;
    }

    public CiudadanoModel getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(CiudadanoModel ciudadano) {
        this.ciudadano = ciudadano;
    }

    public MesavotacionModel getMesa() {
        return mesa;
    }

    public void setMesa(MesavotacionModel mesa) {
        this.mesa = mesa;
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
        if (!(object instanceof VotoModel)) {
            return false;
        }
        VotoModel other = (VotoModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ude.poo.procesospoliticos.modelo.entidades.VotoModel[ id=" + id + " ]";
    }
    
}
