package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class Partido {
    protected String nombre;

    public Partido() {
    }

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
        return "Partido politico: " + nombre;
    }
}
