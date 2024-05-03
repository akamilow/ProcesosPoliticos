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

    @Override
    public String toString() {
        return  "Identificación: " + DNI + "\n" +
                "Edad: " + edad + "\n" +
                "Nombre: " + nombreCompleto + "\n" +
                "Género: " + genero + "\n" +
                "RUT: " + RUT + "\n";
    }
}