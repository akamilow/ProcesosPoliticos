package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalMesa;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Ciudadano;

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

    public void actualizarVocalMesa(Ciudadano ciudadano, Integer id, String rol) throws Exception {
        if (!vocales.containsKey(ciudadano.getDNICiudadano())) {
            throw new Exception("El vocal no existe");
        }
        vocales.put(ciudadano.getDNICiudadano(), new VocalMesa(ciudadano, id, rol));
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