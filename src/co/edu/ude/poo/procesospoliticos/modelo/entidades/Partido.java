package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class Partido {
    protected Integer id;
    protected String nombre;

    public Partido() {
    }

    public Partido(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void setIdPartido(Integer id) {
        this.id = id;
    }

    public Integer getIdPartido() {
        return id;
    }

    public void setNombrePartido(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePartido() {
        return nombre;
    }

    @Override
    public String toString() {
        return  "\tID: " + id + "\n" +
                "\tPartido politico: " + nombre;
        
                
    }
}
