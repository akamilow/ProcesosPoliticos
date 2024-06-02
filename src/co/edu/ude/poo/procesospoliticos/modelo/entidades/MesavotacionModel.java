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
@Table(name = "Mesavotacion")
@NamedQueries({
    @NamedQuery(name = "MesavotacionModel.findAll", query = "SELECT m FROM MesavotacionModel m"),
    @NamedQuery(name = "MesavotacionModel.findByNumero", query = "SELECT m FROM MesavotacionModel m WHERE m.numero = :numero"),
    @NamedQuery(name = "MesavotacionModel.findByGenero", query = "SELECT m FROM MesavotacionModel m WHERE m.genero = :genero"),
    @NamedQuery(name = "MesavotacionModel.findByEstado", query = "SELECT m FROM MesavotacionModel m WHERE m.estado = :estado"),
    @NamedQuery(name = "MesavotacionModel.findByLocalvotacion", query = "SELECT m FROM MesavotacionModel m WHERE m.localvotacion = :localvotacion"),
    @NamedQuery(name = "MesavotacionModel.findByVocalmesa", query = "SELECT m FROM MesavotacionModel m WHERE m.vocalmesa = :vocalmesa"),
    @NamedQuery(name = "MesavotacionModel.findByApoderadoUno", query = "SELECT m FROM MesavotacionModel m WHERE m.apoderadoUno = :apoderadoUno"),
    @NamedQuery(name = "MesavotacionModel.findByApoderadoDos", query = "SELECT m FROM MesavotacionModel m WHERE m.apoderadoDos = :apoderadoDos")})
public class MesavotacionModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "genero")
    private String genero;
    @Column(name = "estado")
    private String estado;
    @Column(name = "localvotacion")
    private Integer localvotacion;
    @Column(name = "vocalmesa")
    private Integer vocalmesa;
    @Column(name = "apoderadoUno")
    private Integer apoderadoUno;
    @Column(name = "apoderadoDos")
    private Integer apoderadoDos;

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

    public Integer getLocalvotacion() {
        return localvotacion;
    }

    public void setLocalvotacion(Integer localvotacion) {
        this.localvotacion = localvotacion;
    }

    public Integer getVocalmesa() {
        return vocalmesa;
    }

    public void setVocalmesa(Integer vocalmesa) {
        this.vocalmesa = vocalmesa;
    }

    public Integer getApoderadoUno() {
        return apoderadoUno;
    }

    public void setApoderadoUno(Integer apoderadoUno) {
        this.apoderadoUno = apoderadoUno;
    }

    public Integer getApoderadoDos() {
        return apoderadoDos;
    }

    public void setApoderadoDos(Integer apoderadoDos) {
        this.apoderadoDos = apoderadoDos;
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
