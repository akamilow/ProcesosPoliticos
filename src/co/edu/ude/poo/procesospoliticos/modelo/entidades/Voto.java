package co.edu.ude.poo.procesospoliticos.modelo.entidades;

import java.util.Date;

public class Voto {
    protected Candidato candidato;
    protected Ciudadano ciudadano;
    protected Date fechaEmision;

    public Voto() {
    }

    public Voto(Ciudadano ciudadano, Candidato candidato, Date fechaEmision) {
        this.ciudadano = ciudadano;
        this.candidato = candidato;
        this.fechaEmision = fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    @Override
    public String toString() {
        return "\tDatos del voto:" + "\n" + "\n" +
                candidato.toString() + "\n" + "\n" +
                ciudadano.toString() + "\n" + "\n" +
                "\tFecha de emisión: " + fechaEmision;
    }
}
