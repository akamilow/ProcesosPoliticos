package co.edu.ude.poo.procesospoliticos.modelo.entidades;

import java.util.ArrayList;

public class MesaVotacion {
    // Asociancion con LocalVotacion, VocalMesa, ApoderadoMesa, Voto
    protected LocalVotacion localVotacion;
    protected VocalMesa vocalMesa;
    protected ArrayList<ApoderadoMesa> apoderadoMesa;
    //hasmap votosEmitidosMesa

    protected   ArrayList<Voto> votosEmitidosMesa = new ArrayList<Voto>();

    // Atributos
    protected Integer numeroMesa;
    protected String generoMesa;
    protected Integer cantidadVotantes;
    protected Boolean estadoMesa;

    public MesaVotacion() {
    }


    public MesaVotacion(Integer numeroMesa, String generoMesa, Integer cantidadVotantesMesa, Boolean estadoMesa, LocalVotacion localVotacion, VocalMesa vocalMesa, ArrayList<ApoderadoMesa> apoderadoMesa) {
        this.numeroMesa = numeroMesa;
        this.generoMesa = generoMesa;
        this.cantidadVotantes = cantidadVotantesMesa;
        this.estadoMesa = estadoMesa;
        this.localVotacion = localVotacion;
        this.vocalMesa = vocalMesa;
        this.apoderadoMesa = apoderadoMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setGeneroMesa(String generoMesa) {
        this.generoMesa = generoMesa;
    }

    public String getGeneroMesa() {
        return generoMesa;
    }

    public void setCantidadVotantesMesa(Integer cantidadVotantesMesa) {
        this.cantidadVotantes = cantidadVotantesMesa;
    }

    public Integer getCantidadVotantesMesa() {
        return cantidadVotantes;
    }

    public void setEstadoMesa(Boolean estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public Boolean getEstadoMesa() {
        return estadoMesa;
    }

    public void setLocalVotacion(LocalVotacion localVotacion) {
        this.localVotacion = localVotacion;
    }

    public LocalVotacion getLocalVotacion() {
        return localVotacion;
    }

    public void setVocalMesa(VocalMesa vocalMesa) {
        this.vocalMesa = vocalMesa;
    }

    public VocalMesa getVocalMesa() {
        return vocalMesa;
    }

    public void setApoderadoMesa(ArrayList<ApoderadoMesa> apoderadoMesa) {
        this.apoderadoMesa = apoderadoMesa;
    }

    public ArrayList<ApoderadoMesa> getApoderadoMesa() {
        return apoderadoMesa;
    }

    public void setVotosEmitidosMesa(ArrayList<Voto> votosEmitidosMesa) {
        this.votosEmitidosMesa = votosEmitidosMesa;
    }

    public ArrayList<Voto> getVotosEmitidosMesa() {
        return votosEmitidosMesa;
    }

    public void addVocalMesa(VocalMesa vocalMesa) {
        this.vocalMesa = vocalMesa;
    }

    public void removeVocalMesa(VocalMesa vocalMesa) {
        this.vocalMesa = null;
    }

    public void addApoderadoMesa(ApoderadoMesa apoderadoMesa) {
        this.apoderadoMesa.add(apoderadoMesa);
    }

    public void removeApoderadoMesa(ApoderadoMesa apoderadoMesa) {
        this.apoderadoMesa.remove(apoderadoMesa);
    }

    public void addVoto(Voto voto) {
        this.votosEmitidosMesa.add(voto);
    }

    public void removeVoto(Voto voto) {
        this.votosEmitidosMesa.remove(voto);
    }

    @Override
    public String toString() {
        return  "\tDatos de la mesa de votacion:" + "\n" +
                "\tID de mesa: " + numeroMesa + "\n" +
                "\tGénero de mesa: " + generoMesa + "\n" +
                "\tCantidad de votantes: " + cantidadVotantes + "\n" +
                "\tEstado de la mesa: " + estadoMesa + "\n" +
                "\n" +
                localVotacion.toString() + "\n" +
                "\n" +
                vocalMesa.toString() + "\n" +
                "\n" +
                "\tApoderados de mesa: " + apoderadoMesa.toString();
        }
}