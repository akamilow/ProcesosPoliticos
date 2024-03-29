/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

/**
 *
 * @author camil
 */
public class LocalVotacion extends Comuna {
    protected String ubicacion;

    public LocalVotacion(String comuna, String ubicacion) {
        super(comuna);
        this.ubicacion = ubicacion;
    }

    public void setLocalVotacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLocalVotacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return  "\tComuna: " + nombreComuna + "\n" +
                "\tUbicación: " + ubicacion;
    }
}
