/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

/**
 *
 * @author camil
 */
public class Comuna {
    protected String nombreComuna;

    public Comuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }

    public void setComuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }

    public String getComuna() {
        return nombreComuna;
    }

    @Override
    public String toString() {
        return "\tNombre de la comuna: " + nombreComuna;
    }
}
