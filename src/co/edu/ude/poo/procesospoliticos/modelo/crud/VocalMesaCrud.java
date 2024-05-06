package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalMesa;

import java.util.HashMap;

public class VocalMesaCrud {

    public HashMap<Integer, VocalMesa> vocales = new HashMap<>();

    public void agregarVocalMesa(Integer id, VocalMesa vocalMesa) throws Exception {
        if (vocales.containsKey(id)) {
            throw new Exception("El vocal ya existe");
        }
        vocales.put(id, vocalMesa);
    }
    
    public VocalMesa buscarVocalMesa(Integer DNI) throws Exception {
        if (!vocales.containsKey(DNI)) {
            throw new Exception("El vocal no existe");
        }
        return vocales.get(DNI);
    }

    public void actualizarVocalMesa(Integer id, String rol) throws Exception {
        if (!vocales.containsKey(id)) {
            throw new Exception("El vocal no existe");
        }
        vocales.get(id).setRolVocal(rol);
    }

    public void eliminarVocalMesa(Integer DNI) throws Exception {
        if (!vocales.containsKey(DNI)) {
            throw new Exception("El vocal no existe");
        }
        vocales.remove(DNI);
    }

    public HashMap<Integer, VocalMesa> listarVocales() {
        return vocales;
    }

    public int contarVocales() {
        return vocales.size();
    }
}