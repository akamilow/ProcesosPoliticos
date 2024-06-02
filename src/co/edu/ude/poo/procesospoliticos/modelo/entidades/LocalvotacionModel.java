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
@Table(name = "Localvotacion")
@NamedQueries({
    @NamedQuery(name = "LocalvotacionModel.findAll", query = "SELECT l FROM LocalvotacionModel l"),
    @NamedQuery(name = "LocalvotacionModel.findById", query = "SELECT l FROM LocalvotacionModel l WHERE l.id = :id"),
    @NamedQuery(name = "LocalvotacionModel.findByUbicacion", query = "SELECT l FROM LocalvotacionModel l WHERE l.ubicacion = :ubicacion")})
public class LocalvotacionModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "ubicacion")
    private String ubicacion;
    @JoinColumn(name = "comuna", referencedColumnName = "id")
    @ManyToOne
    private ComunaModel comuna;

    public LocalvotacionModel() {
    }

    public LocalvotacionModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ComunaModel getComuna() {
        return comuna;
    }

    public void setComuna(ComunaModel comuna) {
        this.comuna = comuna;
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
        if (!(object instanceof LocalvotacionModel)) {
            return false;
        }
        LocalvotacionModel other = (LocalvotacionModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ude.poo.procesospoliticos.modelo.entidades.LocalvotacionModel[ id=" + id + " ]";
    }
    
}
