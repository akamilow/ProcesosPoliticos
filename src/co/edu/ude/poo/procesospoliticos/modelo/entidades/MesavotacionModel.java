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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author camil
 */
@Entity
@Table(name = "Mesavotacion")
@NamedQueries({
    @NamedQuery(name = "MesavotacionModel.findAll", query = "SELECT m FROM MesavotacionModel m"),
    @NamedQuery(name = "MesavotacionModel.findByNumero", query = "SELECT m FROM MesavotacionModel m WHERE m.numero = :numero"),
    @NamedQuery(name = "MesavotacionModel.findByGenero", query = "SELECT m FROM MesavotacionModel m WHERE m.genero = :genero"),
    @NamedQuery(name = "MesavotacionModel.findByEstado", query = "SELECT m FROM MesavotacionModel m WHERE m.estado = :estado")})
public class MesavotacionModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "genero")
    private String genero;
    @Column(name = "estado")
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "apoderadoDos", referencedColumnName = "dni"),
        @JoinColumn(name = "apoderadoUno", referencedColumnName = "dni")})
    @ManyToOne
    private ApoderadoModel apoderadoModel;
    @JoinColumn(name = "localvotacion", referencedColumnName = "id")
    @ManyToOne
    private LocalvotacionModel localvotacion;
    @JoinColumn(name = "vocalmesa", referencedColumnName = "dni")
    @ManyToOne
    private VocalmesaModel vocalmesa;
    @OneToMany(mappedBy = "mesa")
    private List<VotoModel> votoModelList;

    public MesavotacionModel() {
    }

    public MesavotacionModel(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ApoderadoModel getApoderadoModel() {
        return apoderadoModel;
    }

    public void setApoderadoModel(ApoderadoModel apoderadoModel) {
        this.apoderadoModel = apoderadoModel;
    }

    public LocalvotacionModel getLocalvotacion() {
        return localvotacion;
    }

    public void setLocalvotacion(LocalvotacionModel localvotacion) {
        this.localvotacion = localvotacion;
    }

    public VocalmesaModel getVocalmesa() {
        return vocalmesa;
    }

    public void setVocalmesa(VocalmesaModel vocalmesa) {
        this.vocalmesa = vocalmesa;
    }

    public List<VotoModel> getVotoModelList() {
        return votoModelList;
    }

    public void setVotoModelList(List<VotoModel> votoModelList) {
        this.votoModelList = votoModelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MesavotacionModel)) {
            return false;
        }
        MesavotacionModel other = (MesavotacionModel) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ude.poo.procesospoliticos.modelo.entidades.MesavotacionModel[ numero=" + numero + " ]";
    }
    
}
