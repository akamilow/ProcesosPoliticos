package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class VocalMesa extends Ciudadano {
    protected String rol;

    public VocalMesa() {
    }

    public VocalMesa(Ciudadano ciudadano, String rol) {
        super(ciudadano.DNI, ciudadano.edad, ciudadano.nombreCompleto, ciudadano.genero);
        this.rol = rol;
    }

    public void setRolVocal(String rol) {
        this.rol = rol;
    }

    public String getRolVocal() {
        return rol;
    }

    // get ciudadano
    public Ciudadano getCiudadano() {
        return new Ciudadano(DNI, edad, nombreCompleto, genero);
    }

    @Override 
    public String toString() {
        return  "Identificación: " + DNI + "\n" +
                "Nombre: " + nombreCompleto + "\n" +
                "Edad: " + edad + "\n" +
                "Género: " + genero + "\n" +
                "Rol: " + rol;
    }
}