package co.edu.ude.poo.procesospoliticos.modelo.entidades;

public class Usuario {
    private Integer dni;
    private String contrasena;

    public Usuario(Integer dni, String contrasena) {
        this.dni = dni;
        this.contrasena = contrasena;
    }

    public Integer getDni() {
        return dni;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" + "dni=" + dni + ", contrasena=" + contrasena + '}';
    }
}
