/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

import java.util.ArrayList;

/**
 *
 * @author camil
 */
public class MesaVotacion {
    // Asociancion con LocalVotacion, VocalMesa, ApoderadoMesa, Voto
    protected LocalVotacion localVotacion;
    protected VocalMesa vocalMesa;
    protected ArrayList<ApoderadoMesa> apoderadoMesa;
    protected ArrayList<Voto> votosEmitidosMesa;

    // Atributos
    protected Integer numeroMesa;
    protected String generoMesa;
    protected Integer cantidadVotantes;
    protected Boolean estadoMesa;


    public MesaVotacion(Integer numeroMesa, String generoMesa, Integer cantidadVotantesMesa, Boolean estadoMesa, LocalVotacion localVotacion, VocalMesa vocalMesa, ArrayList<ApoderadoMesa> apoderadoMesa) {
        this.numeroMesa = numeroMesa;
        this.generoMesa = generoMesa;
        this.cantidadVotantes = cantidadVotantesMesa;
        this.estadoMesa = estadoMesa;
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

    @Override
    public String toString() {
        return "\tID de mesa: " + numeroMesa + "\n" +
                "\tGénero de mesa: " + generoMesa + "\n" +
                "\tCantidad de votantes: " + cantidadVotantes + "\n" +
                "\tEstado de la mesa: " + estadoMesa;
        }

}