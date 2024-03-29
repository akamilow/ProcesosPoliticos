/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

/**
 *
 * @author camil
 */
public class ApoderadoMesa extends Ciudadano {
    protected Integer RUT;

    public ApoderadoMesa(Ciudadano ciudadano, Integer RUT) {
        super(ciudadano.DNI, ciudadano.edad, ciudadano.nombreCompleto, ciudadano.genero);
        this.RUT = RUT;
    }

    public void setRUTApoderado(Integer RUT) {
        this.RUT = RUT;
    }

    public Integer getRUTApoderado() {
        return RUT;
    }

    @Override
    public String toString() {
        return "\tIdentificación: " + DNI + "\n" +
                "\tEdad: " + edad + "\n" +
                "\tNombre: " + nombreCompleto + "\n" +
                "\tGénero: " + genero + "\n" +
                "\tRUT: " + RUT;
    }
}