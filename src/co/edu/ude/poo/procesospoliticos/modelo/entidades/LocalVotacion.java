package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class LocalVotacion extends Comuna {
    protected String ubicacion;

    public LocalVotacion(String comuna, String ubicacion) {
        super(comuna);
        this.ubicacion = ubicacion;
    }

    public void setLocalVotacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLocalVotacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return  "\tComuna: " + nombreComuna + "\n" +
                "\tUbicación: " + ubicacion;
    }
}
