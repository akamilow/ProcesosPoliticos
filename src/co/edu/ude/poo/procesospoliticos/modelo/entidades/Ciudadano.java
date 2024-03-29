package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class Ciudadano {
    protected Integer DNI;
    protected Integer edad;
    protected String nombreCompleto;
    protected String genero;

    public Ciudadano(Integer DNI, Integer edad, String nombreCompleto, String genero) {
        this.DNI = DNI;
        this.edad = edad;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
    }

    public void setDNICiudadano(Integer DNI) {
        this.DNI = DNI;
    }

    public Integer getDNICiudadano() {
        return DNI;
    }

    public void setEdadCiudadano(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdadCiudadano() {
        return edad;
    }

    public void setNombreCompletoCiudadano(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompletoCiudadano() {
        return nombreCompleto;
    }

    public void setGeneroCiudadano(String genero) {
        this.genero = genero;
    }

    public String getGeneroCiudadano() {
        return genero;
    }

    @Override
    public String toString() {
        return  "\tDatos del CIudadano:" + "\n" +
                "\tIdentificación: " + DNI + "\n" +
                "\tEdad: " + edad + "\n" +
                "\tNombre: " + nombreCompleto + "\n" +
                "\tGénero: " + genero;
    }
}
