package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.ApoderadoMesa;

import java.util.HashMap;

public class ApoderadoMesaCrud {
    
public HashMap<Integer, ApoderadoMesa> apoderados = new HashMap<>();

    public void agregarApoderadoMesa(Integer id, ApoderadoMesa apoderadoMesa) throws Exception {
        if (apoderados.containsKey(id)) {
            throw new Exception("El apoderado ya existe");
        }
        apoderados.put(id, apoderadoMesa);
    }

    public ApoderadoMesa buscarApoderadoMesa(Integer DNI) throws Exception {
        if (!apoderados.containsKey(DNI)) {
            throw new Exception("El apoderado no existe");
        }
        return apoderados.get(DNI);
    }

    public void actualizarApoderadoMesa(Integer id, Integer RUT) throws Exception {
        if (!apoderados.containsKey(id)) {
            throw new Exception("El apoderado no existe");
        }
        apoderados.get(id).setRUTApoderado(RUT);
    }

    public void eliminarApoderadoMesa(Integer DNI) throws Exception {
        if (!apoderados.containsKey(DNI)) {
            throw new Exception("El apoderado no existe");
        }
        apoderados.remove(DNI);
    }

    public HashMap<Integer, ApoderadoMesa> listarApoderados() {
        return apoderados;
    }
    
    public int contarApoderados() {
        return apoderados.size();
    }
}
