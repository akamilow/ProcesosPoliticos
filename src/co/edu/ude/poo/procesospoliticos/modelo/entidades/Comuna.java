package co.edu.ude.poo.procesospoliticos.modelo.entidades;

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
        return  "\tDatos de la comuna:" + "\n" +
                "\tNombre: " + nombreComuna;
    }
}
