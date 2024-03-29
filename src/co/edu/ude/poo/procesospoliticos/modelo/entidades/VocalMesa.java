/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

/**
 *
 * @author camil
 */
public class VocalMesa extends Ciudadano {
    protected Integer id;
    protected String rol;

    public VocalMesa(Ciudadano ciudadano, Integer id, String rol) {
        super(ciudadano.DNI, ciudadano.edad, ciudadano.nombreCompleto, ciudadano.genero);
        this.id = id;
        this.rol = rol;
    }

    public void setIdVocal(Integer id) {
        this.id = id;
    }

    public Integer getVocal() {
        return id;
    }

    public void setRolVocal(String rol) {
        this.rol = rol;
    }

    public String getRolVocal() {
        return rol;
    }

    @Override 
    public String toString() {
        return "\tIdentificación: " + DNI + "\n" +
                "\tEdad: " + edad + "\n" +
                "\tNombre: " + nombreCompleto + "\n" +
                "\tGénero: " + genero + "\n" +
                "\tID: " + id + "\n" +
                "\tRol: " + rol;
    }
}