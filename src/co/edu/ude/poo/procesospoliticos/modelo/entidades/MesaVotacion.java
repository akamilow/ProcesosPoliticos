package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class MesaVotacion {
    // Asociancion con LocalVotacion, VocalMesa, ApoderadoMesa, Voto
    protected LocalVotacion localVotacion;
    protected VocalMesa vocalMesa;
    protected ApoderadoMesa apoderadoMesaUno;
    protected ApoderadoMesa apoderadoMesaDos;
    //hasmap votosEmitidosMesa
    // Atributos
    protected Integer numeroMesa;
    protected String generoMesa;
    protected String estadoMesa;

    public MesaVotacion() {
    }

    public MesaVotacion(Integer numeroMesa, String generoMesa, String estadoMesa, LocalVotacion localVotacion, VocalMesa vocalMesa, ApoderadoMesa apoderadoMesaUno, ApoderadoMesa apoderadoMesaDos) {
        this.numeroMesa = numeroMesa;
        this.generoMesa = generoMesa;
        this.estadoMesa = estadoMesa;
        this.localVotacion = localVotacion;
        this.vocalMesa = vocalMesa;
        this.apoderadoMesaUno = apoderadoMesaUno;
        this.apoderadoMesaDos = apoderadoMesaDos;
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

    public void setEstadoMesa(String estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public String getEstadoMesa() {
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

    public void setApoderadoMesaUno(ApoderadoMesa apoderadoMesaUno) {
        this.apoderadoMesaUno = apoderadoMesaUno;
    }

    public ApoderadoMesa getApoderadoMesaUno() {
        return apoderadoMesaUno;
    }

    public void setApoderadoMesaDos(ApoderadoMesa apoderadoMesaDos) {
        this.apoderadoMesaDos = apoderadoMesaDos;
    }

    public ApoderadoMesa getApoderadoMesaDos() {
        return apoderadoMesaDos;
    }

    @Override
    public String toString() {
        return  "Numero de mesa: " + numeroMesa + "\n" +
                "Género de mesa: " + generoMesa + "\n" +
                "Estado de la mesa: " + estadoMesa + "\n" +
                "\n" +
                localVotacion.toString() + "\n" +
                "\n" +
                vocalMesa.toString() + "\n" +
                "\n" +
                "Apoderado 1: " + apoderadoMesaUno.toString() + "\n" +
                "Apoderado 2: " + apoderadoMesaDos.toString();
        }
}