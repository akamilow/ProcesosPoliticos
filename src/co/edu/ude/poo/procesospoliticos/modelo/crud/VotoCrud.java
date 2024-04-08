package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Voto;

import java.util.HashMap;


public class VotoCrud {

    private HashMap<Integer, Voto> votos = new HashMap<>();

    public void agregarVoto(Voto voto) throws Exception {
        if (votos.containsKey(voto.getCiudadano().getDNICiudadano())) {
            throw new Exception("El voto ya existe");
        }
        votos.put(voto.getCiudadano().getDNICiudadano(), voto);
    }

    public Voto buscarVoto(Integer DNI) throws Exception {
        if (!votos.containsKey(DNI)) {
            throw new Exception("El voto no existe");
        }
        return votos.get(DNI);
    }

    public void actualizarVoto(Voto voto, Voto nuevoVoto) throws Exception {
        if (!votos.containsKey(voto.getCiudadano().getDNICiudadano())) {
            throw new Exception("El voto no existe");
        }
        votos.replace(voto.getCiudadano().getDNICiudadano(), nuevoVoto);
    }

    public void eliminarVoto(Integer DNI) throws Exception {
        if (!votos.containsKey(DNI)) {
            throw new Exception("El voto no existe");
        }
        votos.remove(DNI);
    }

    public HashMap<Integer, Voto> listarVotos() {
        return votos;
    }

    public int contarVotos() {
        return votos.size();
    }
}
