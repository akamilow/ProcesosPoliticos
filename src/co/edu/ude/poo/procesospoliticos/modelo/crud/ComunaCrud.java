package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Comuna;

import java.util.HashMap;

public class ComunaCrud {
        
    public HashMap<Integer, Comuna> comunas = new HashMap<>();

    public void agregarComuna(Integer id, Comuna nombreComuna) throws Exception{
        if(comunas.containsKey(id) || comunas.containsValue(nombreComuna)) {
            throw new Exception("La comuna ya existe");
        }
        comunas.put(id, nombreComuna);
    }
    
    public Comuna buscarComuna(Integer id) throws Exception{
        if(comunas.containsKey(id)){
            return comunas.get(id);
        }
        throw new Exception("La comuna no existe");
    }

    public void actualizarComuna(Integer id, String nuevoNombre) throws Exception{
        if(comunas.containsKey(id)){
            comunas.get(id).setComuna(nuevoNombre);
            return;
        }
        throw new Exception("La comuna no existe");
    }

    public void eliminarComuna(Integer id) throws Exception{
        if(comunas.containsKey(id)){
            comunas.remove(id);
            return;
        }
        throw new Exception("La comuna no existe");
    }

    public void mostrarComunas(){
        for (Comuna comuna : comunas.values()) {
            System.out.println(comuna);
        }
    }

    public int numeroComunas(){
        return comunas.size();
    }
}
