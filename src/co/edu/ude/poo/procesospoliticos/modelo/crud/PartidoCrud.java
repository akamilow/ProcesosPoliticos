package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Partido;

import java.util.HashMap;

public class PartidoCrud {

    public HashMap<Integer, Partido> partidos = new HashMap<>();

    public void agregarPartido(Integer id, Partido nombrePartido) throws Exception{
        if(partidos.containsKey(id) || partidos.containsValue(nombrePartido)) {
            throw new Exception("El partido ya existe");
        }
        partidos.put(id, nombrePartido);
    }

    public Partido buscarPartido(Integer id) throws Exception{
        if(partidos.containsKey(id)){
            return partidos.get(id);
        }
        throw new Exception("El partido no existe");
    }
    
    public void actualizarPartido(Integer id, String nuevoNombre) throws Exception{
        if(partidos.containsKey(id)){
            partidos.get(id).setNombrePartido(nuevoNombre);
            return;
        }
        throw new Exception("El partido no existe");
    }

    public void eliminarPartido(Integer id) throws Exception{
        if(partidos.containsKey(id)){
            partidos.remove(id);
            return;
        }
        throw new Exception("El partido no existe");
    }

    public HashMap<Integer, Partido> listarPartidos(){
        return partidos;
    }

    public int numeroPartidos(){
        return partidos.size();
    }
}