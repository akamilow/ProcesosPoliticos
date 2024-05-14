package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Candidato;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Ciudadano;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.MesaVotacion;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Voto;

import java.util.HashMap;


public class VotoCrud {

    public HashMap<Integer, Voto> votos = new HashMap<>();

    public void agregarVoto(Integer id, Voto voto) throws Exception {
        if (votos.containsKey(id)) {
            throw new Exception("El voto ya existe");
        }
        votos.put(id, voto);
    }

    public Voto buscarVoto(Integer id) throws Exception {
        if (!votos.containsKey(id)) {
            throw new Exception("El voto no existe");
        }
        return votos.get(id);
    }

    public void actualizarVoto(Integer id, MesaVotacion mesaVotacion, Ciudadano ciudadano, Candidato candidato) throws Exception {
        if (!votos.containsKey(id)) {
            throw new Exception("El voto no existe");
        }
        Voto voto = votos.get(id);
        voto.setMesaVotacion(mesaVotacion);
        voto.setCiudadano(ciudadano);
        voto.setCandidato(candidato);
    }

    public void eliminarVoto(Integer id) throws Exception {
        if (!votos.containsKey(id)) {
            throw new Exception("El voto no existe");
        }
        votos.remove(id);
    }

    public HashMap<Integer, Voto> listarVotos() {
        return votos;
    }

    public int contarVotos() {
        return votos.size();
    }
}
