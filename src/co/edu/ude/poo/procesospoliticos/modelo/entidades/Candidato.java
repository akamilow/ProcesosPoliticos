/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.entidades;

/**
 *
 * @author camil
 */
public class Candidato extends Ciudadano {
    protected String categoria;
    protected Partido partidoElectoral;
    protected Comuna comuna;

    public Candidato(Ciudadano ciudadano, Partido partidoElectoral, Comuna comuna, String categoria) {
        super(ciudadano.DNI, ciudadano.edad, ciudadano.nombreCompleto, ciudadano.genero);
        this.partidoElectoral = partidoElectoral;
        this.comuna = comuna;
        this.categoria = categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return  "\tDatos del Candidato:" + "\n" +
                "\tIdentificación: " + DNI + "\n" +
                "\tEdad: " + edad + "\n" +
                "\tNombre: " + nombreCompleto + "\n" +
                "\tGénero: " + genero + "\n" +
                "\tCategoría: " + categoria + "\n" +
                partidoElectoral.toString() + "\n" +
                comuna.toString();
    }
}
