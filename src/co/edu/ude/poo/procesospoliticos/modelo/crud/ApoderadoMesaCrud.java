package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.ApoderadoMesa;

import java.util.HashMap;

public class ApoderadoMesaCrud {
    
private HashMap<Integer, ApoderadoMesa> apoderados = new HashMap<>();

    public void agregarApoderadoMesa(ApoderadoMesa apoderadoMesa) throws Exception {
        if (apoderados.containsKey(apoderadoMesa.getCiudadano().getDNICiudadano())) {
            throw new Exception("El apoderado ya existe en la lista");
        }
        apoderados.put(apoderadoMesa.getCiudadano().getDNICiudadano(), new ApoderadoMesa(apoderadoMesa.getCiudadano(), apoderadoMesa.getRUTApoderado()));
    }

    public ApoderadoMesa buscarApoderadoMesa(Integer DNI) throws Exception {
        if (!apoderados.containsKey(DNI)) {
            throw new Exception("El apoderado no existe");
        }
        return apoderados.get(DNI);
    }

    public void actualizarApoderadoMesa(ApoderadoMesa apoderadoMesa, ApoderadoMesa nuevoApoderadoMesa) throws Exception {
        if (!apoderados.containsKey(apoderadoMesa.getCiudadano().getDNICiudadano())) {
            throw new Exception("El apoderado no existe");
        }
        apoderados.put(apoderadoMesa.getCiudadano().getDNICiudadano(), nuevoApoderadoMesa);
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
