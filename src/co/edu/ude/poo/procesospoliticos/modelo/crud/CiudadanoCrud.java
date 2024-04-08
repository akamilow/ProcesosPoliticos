package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Ciudadano;
import java.util.HashMap;

public class CiudadanoCrud {
               
    private HashMap<Integer, Ciudadano> ciudadanos = new HashMap<>();
    
    public void agregarCiudadano(Ciudadano ciudadano) throws Exception{
        if(ciudadanos.containsKey(ciudadano.getDNICiudadano())){
            throw new Exception("El ciudadano ya existe en la lista");
        }
        ciudadanos.put(ciudadano.getDNICiudadano(), new Ciudadano(ciudadano.getDNICiudadano(), ciudadano.getEdadCiudadano(), ciudadano.getNombreCompletoCiudadano(), ciudadano.getGeneroCiudadano()));
    }
    
    public Ciudadano buscarCiudadano(Integer DNI) throws Exception{
        if(ciudadanos.containsKey(DNI)){
            return ciudadanos.get(DNI);
        }
        throw new Exception("El ciudadano no existe");
    }
    
    public void actualizarCiudadano(Ciudadano ciudadano, Ciudadano nuevoCiudadano) throws Exception{
        if(ciudadanos.containsKey(ciudadano.getDNICiudadano())){
            ciudadanos.put(ciudadano.getDNICiudadano(), new Ciudadano(nuevoCiudadano.getDNICiudadano(), nuevoCiudadano.getEdadCiudadano(), nuevoCiudadano.getNombreCompletoCiudadano(), nuevoCiudadano.getGeneroCiudadano()));
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
    
    public HashMap<Integer, Ciudadano> listarCiudadanos(){
        return ciudadanos;
    }
    
    public int contarCiudadanos(){
        return ciudadanos.size();
    }
}
