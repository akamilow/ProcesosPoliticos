/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

import java.util.Date;

/**
 *
 * @author camil
 */
public class Voto {
    protected Candidato candidato;
    protected Ciudadano ciudadano;
    protected Date fechaEmision;

    public Voto(Ciudadano ciudadano, Candidato candidato, Date fechaEmision) {
        this.ciudadano = ciudadano;
        this.candidato = candidato;
        this.fechaEmision = fechaEmision;
    }

    @Override
    public String toString() {
        return "\tDatos del voto:" + "\n" + "\n" +
                candidato.toString() + "\n" + "\n" +
                ciudadano.toString() + "\n" + "\n" +
                "\tFecha de emisión: " + fechaEmision;
    }
}
