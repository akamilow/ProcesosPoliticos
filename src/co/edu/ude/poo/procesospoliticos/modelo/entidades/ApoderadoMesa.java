package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class ApoderadoMesa extends Ciudadano {
    protected Integer RUT;

    public ApoderadoMesa() {
    }

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
        return  "\n" +"\tDatos del apoderado de mesa:" + "\n" +
                "\tIdentificación: " + DNI + "\n" +
                "\tEdad: " + edad + "\n" +
                "\tNombre: " + nombreCompleto + "\n" +
                "\tGénero: " + genero + "\n" +
                "\tRUT: " + RUT + "\n";
    }
}