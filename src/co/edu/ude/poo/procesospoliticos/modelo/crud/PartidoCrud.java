package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Partido;

import java.util.ArrayList;

public class PartidoCrud {

    private ArrayList<Partido> partidos = new ArrayList<>();

    public void agregarPartido(Partido nombrePartido) throws Exception{
        for (Partido partido : partidos) {
            if(partido.getNombrePartido().equals(nombrePartido.getNombrePartido())){
                throw new Exception("El partido ya existe en la lista");
            }
        }
        partidos.add(new Partido(nombrePartido.getNombrePartido()));
    }
    public Partido buscarPartido(String nombre) throws Exception{
        for (Partido partido : partidos) {
            if(partido.getNombrePartido().equals(nombre)){
                return partido;
            }
        }
        throw new Exception("El partido no existe");
    }
    public void actualizarPartido(String nombre, String nuevoNombre) throws Exception{
        for (Partido partido : partidos) {
            if(partido.getNombrePartido().equals(nombre)){
                partido.setNombrePartido(nuevoNombre);
                return;
            }
        }
        throw new Exception("El partido no existe");
    }
    public void eliminarPartido(String nombre) throws Exception{
        for (Partido partido : partidos) {
            if(partido.getNombrePartido().equals(nombre)){
                partidos.remove(partido);
                return;
            }
        }
        throw new Exception("El partido no existe");
    }
    public ArrayList<Partido> listarPartidos(){
        return partidos;
    }
    public int contarPartidos(){
        return partidos.size();
    }
}