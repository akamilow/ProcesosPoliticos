package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.LocalVotacion;

import java.util.HashMap;

public class LocalVotacionCrud {
            
    public HashMap<Integer, LocalVotacion> localVotaciones = new HashMap<>();

    public void agregarLocalVotacion(Integer id, LocalVotacion localVotacion) throws Exception{
        if(localVotaciones.containsKey(id) || localVotaciones.containsValue(localVotacion)) {
            throw new Exception("El local de votación ya existe");
        }
        localVotaciones.put(id, localVotacion);
    }

    public String buscarLocalVotacion(Integer id) throws Exception{
        if(localVotaciones.containsKey(id)){
            return localVotaciones.get(id).toString();
        }
        throw new Exception("El local de votación no existe");
    }

    public void actualizarLocalVotacion(Integer id, String nuevaUbicacion) throws Exception{
        if(localVotaciones.containsKey(id)){
            localVotaciones.get(id).setLocalVotacion(nuevaUbicacion);
            return;
        }
        throw new Exception("El local de votación no existe");
    }

    public void eliminarLocalVotacion(Integer id) throws Exception{
        if(localVotaciones.containsKey(id)){
            localVotaciones.remove(id);
            return;
        }
        throw new Exception("El local de votación no existe");
    }

    public void mostrarLocalVotaciones(){
        for (LocalVotacion localVotacion : localVotaciones.values()) {
            System.out.println(localVotacion);
        }
    }

    public int numeroLocalVotaciones(){
        return localVotaciones.size();
    }
}
