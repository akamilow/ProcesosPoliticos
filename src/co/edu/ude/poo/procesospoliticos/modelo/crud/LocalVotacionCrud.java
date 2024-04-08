package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.LocalVotacion;
import java.util.ArrayList;

public class LocalVotacionCrud {
            
    private ArrayList<LocalVotacion> localVotaciones = new ArrayList<>();

    public void agregarLocalVotacion(LocalVotacion localVotacion) throws Exception{
        for (LocalVotacion localVotacion1 : localVotaciones) {
            if(localVotacion1.getLocalVotacion().equals(localVotacion.getLocalVotacion())){
                throw new Exception("El local de votación ya existe");
            }
        }
        localVotaciones.add(localVotacion);
    }

    public String buscarLocalVotacion(String ubicacion) throws Exception{
        for (LocalVotacion localVotacion : localVotaciones) {
            if(localVotacion.getLocalVotacion().equals(ubicacion)){
                return localVotacion.getLocalVotacion();
            }
        }
        throw new Exception("El local de votación no existe");
    }

    public void actualizarLocalVotacion(LocalVotacion localVotacion, LocalVotacion nuevolocalVotacion) throws Exception{
        for (LocalVotacion localVotacion1 : localVotaciones) {
            if(localVotacion1.getLocalVotacion().equals(localVotacion.getLocalVotacion())){
                localVotacion1.setLocalVotacion(nuevolocalVotacion.getLocalVotacion());
                return;
            }
        }
        throw new Exception("El local de votación no existe");
    }

    public void eliminarLocalVotacion(String ubicacion) throws Exception{
        for (LocalVotacion localVotacion : localVotaciones) {
            if(localVotacion.getLocalVotacion().equals(ubicacion)){
                localVotaciones.remove(localVotacion);
                return;
            }
        }
        throw new Exception("El local de votación no existe");
    }

    public ArrayList<LocalVotacion> listarLocalVotaciones(){
        return localVotaciones;
    }

    public int contarLocalVotaciones(){
        return localVotaciones.size();
    }
}
