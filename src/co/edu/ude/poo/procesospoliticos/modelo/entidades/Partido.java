/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

/**
 *
 * @author camil
 */
public class Partido {
    protected String nombre;

    public Partido(String nombre) {
        this.nombre = nombre;
    }

    public void setNombrePartido(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePartido() {
        return nombre;
    }

    @Override
    public String toString() {
        return "\tPartido politico: " + nombre;
    }
}
