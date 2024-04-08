package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Comuna;

import java.util.ArrayList;

public class ComunaCrud {
        
    private ArrayList<Comuna> comunas = new ArrayList<>();

    public void agregarComuna(Comuna nombreComuna) throws Exception{
        for (Comuna comuna : comunas) {
            if(comuna.getComuna().equals(nombreComuna.getComuna())){
                throw new Exception("La comuna ya existe en la lista");
            }
        }
        comunas.add(new Comuna(nombreComuna.getComuna()));
    }
    
    public Comuna buscarComuna(String nombre) throws Exception{
        for (Comuna comuna : comunas) {
            if(comuna.getComuna().equals(nombre)){
                return comuna;
            }
        }
        throw new Exception("La comuna no existe");
    }

    public void actualizarComuna(String nombre, String nuevoNombre) throws Exception{
        for (Comuna comuna : comunas) {
            if(comuna.getComuna().equals(nombre)){
                comuna.setComuna(nuevoNombre);
                return;
            }
        }
        throw new Exception("La comuna no existe");
    }

    public void eliminarComuna(String nombre) throws Exception{
        for (Comuna comuna : comunas) {
            if(comuna.getComuna().equals(nombre)){
                comunas.remove(comuna);
                return;
            }
        }
        throw new Exception("La comuna no existe");
    }

    public ArrayList<Comuna> listarComunas(){
        return comunas;
    }

    public int contarComunas(){
        return comunas.size();
    }
}
