package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class Voto {
    protected MesaVotacion mesaVotacion;
    protected Candidato candidato;
    protected Ciudadano ciudadano;

    public Voto() {
    }

    public Voto(MesaVotacion mesaVotacion, Ciudadano ciudadano, Candidato candidato) {
        this.mesaVotacion = mesaVotacion;
        this.ciudadano = ciudadano;
        this.candidato = candidato;
    }

    public MesaVotacion getMesaVotacion() {
        return mesaVotacion;
    }

    public void setMesaVotacion(MesaVotacion mesaVotacion) {
        this.mesaVotacion = mesaVotacion;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    @Override
    public String toString() {
        return  candidato.toString() + "\n" + "\n" +
                ciudadano.toString() + "\n" + "\n" +
                mesaVotacion.toString();
    }
}
