package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Ciudadano;

import java.util.HashMap;

public class CiudadanoCrud {
               
    public HashMap<Integer, Ciudadano> ciudadanos = new HashMap<>();
    
    public void agregarCiudadano(Integer id, Ciudadano ciudadano) throws Exception{
        if(ciudadanos.containsKey(id) || ciudadanos.containsValue(ciudadano)) {
            throw new Exception("El ciudadano ya existe");
        }
        ciudadanos.put(id, ciudadano);
    }
    
    public Ciudadano buscarCiudadano(Integer DNI) throws Exception{
        if(ciudadanos.containsKey(DNI)){
            return ciudadanos.get(DNI);
        }
        throw new Exception("El ciudadano no existe");
    }
    
    public void actualizarCiudadano(Integer DNI, String nombreCompleto, Integer edad, String genero) throws Exception{
        if(ciudadanos.containsKey(DNI)){
            Ciudadano ciudadano = ciudadanos.get(DNI);
            ciudadano.setNombreCompletoCiudadano(nombreCompleto);
            ciudadano.setEdadCiudadano(edad);
            ciudadano.setGeneroCiudadano(genero);
            return;
        }
        throw new Exception("El ciudadano no existe");
    }
    
    public void eliminarCiudadano(Integer DNI) throws Exception{
        if(ciudadanos.containsKey(DNI)){
            ciudadanos.remove(DNI);
            return;
        }
        throw new Exception("El ciudadano no existe");
    }
    
    public void mostrarCiudadanos(){
        for (Ciudadano ciudadano : ciudadanos.values()) {
            System.out.println(ciudadano);
        }
    }
    
    public int contarCiudadanos(){
        return ciudadanos.size();
    }
}
