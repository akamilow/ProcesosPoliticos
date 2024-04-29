package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class LocalVotacion extends Comuna {
    protected String ubicacion;

    public LocalVotacion() {
    }

    public LocalVotacion(Comuna comuna, String ubicacion) {
        super(comuna.getComuna());
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
        return "Ubicación del local de votación: " + ubicacion + ", Comuna: " + super.getComuna();
    }
}
