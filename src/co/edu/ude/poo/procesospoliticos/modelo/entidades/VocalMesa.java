package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class VocalMesa extends Ciudadano {
    protected Integer id;
    protected String rol;

    public VocalMesa() {
    }

    public VocalMesa(Ciudadano ciudadano, Integer id, String rol) {
        super(ciudadano.DNI, ciudadano.edad, ciudadano.nombreCompleto, ciudadano.genero);
        this.id = id;
        this.rol = rol;
    }

    public void setIdVocal(Integer id) {
        this.id = id;
    }

    public Integer getIdVocal() {
        return id;
    }

    public void setRolVocal(String rol) {
        this.rol = rol;
    }

    public String getRolVocal() {
        return rol;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.DNI = ciudadano.DNI;
        this.edad = ciudadano.edad;
        this.nombreCompleto = ciudadano.nombreCompleto;
        this.genero = ciudadano.genero;
    }

    public Ciudadano getCiudadano() {
        return new Ciudadano(DNI, edad, nombreCompleto, genero);
    }

    @Override 
    public String toString() {
        return  "\tDatos del vocal de mesa:" + "\n" +
                "\tIdentificación: " + DNI + "\n" +
                "\tEdad: " + edad + "\n" +
                "\tNombre: " + nombreCompleto + "\n" +
                "\tGénero: " + genero + "\n" +
                "\tID: " + id + "\n" +
                "\tRol: " + rol;
    }
}