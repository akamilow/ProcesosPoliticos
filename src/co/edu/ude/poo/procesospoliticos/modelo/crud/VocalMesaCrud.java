package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalMesa;

import java.util.HashMap;

public class VocalMesaCrud {

    private HashMap<Integer, VocalMesa> vocales = new HashMap<>();

    public void agregarVocalMesa(VocalMesa vocalMesa) throws Exception {
        if (vocales.containsKey(vocalMesa.getCiudadano().getDNICiudadano())) {
            throw new Exception("El vocal ya existe en la lista");
        }
        vocales.put(vocalMesa.getCiudadano().getDNICiudadano(), new VocalMesa(vocalMesa.getCiudadano(), vocalMesa.getIdVocal(), vocalMesa.getRolVocal()));
    }
    
    public VocalMesa buscarVocalMesa(Integer DNI) throws Exception {
        if (!vocales.containsKey(DNI)) {
            throw new Exception("El vocal no existe");
        }
        return vocales.get(DNI);
    }

    public void actualizarVocalMesa(VocalMesa vocalMesa, VocalMesa nuevoVocalMesa) throws Exception {
        if (!vocales.containsKey(vocalMesa.getCiudadano().getDNICiudadano())) {
            throw new Exception("El vocal no existe");
        }
        vocales.put(vocalMesa.getCiudadano().getDNICiudadano(), nuevoVocalMesa);
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