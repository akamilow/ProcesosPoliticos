package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class Candidato extends Ciudadano {
    protected Partido partidoElectoral;
    protected Comuna comuna;
    protected String categoria;

    public Candidato() {
    }

    public Candidato(Ciudadano ciudadano, Partido partidoElectoral, Comuna comuna, String categoria) {
        super(ciudadano.DNI, ciudadano.edad, ciudadano.nombreCompleto, ciudadano.genero);
        this.partidoElectoral = partidoElectoral;
        this.comuna = comuna;
        this.categoria = categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setPartidoElectoral(Partido partidoElectoral) {
        this.partidoElectoral = partidoElectoral;
    }

    public Partido getPartidoElectoral() {
        return partidoElectoral;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Comuna getComuna() {
        return comuna;
    }

    

    @Override
    public String toString() {
        return  "\tDatos del Candidato:" + "\n" +
                "\tIdentificación: " + DNI + "\n" +
                "\tEdad: " + edad + "\n" +
                "\tNombre: " + nombreCompleto + "\n" +
                "\tGénero: " + genero + "\n" +
                "\tCategoría: " + categoria + "\n" +
                partidoElectoral.toString() + "\n" +
                comuna.toString();
    }
}
