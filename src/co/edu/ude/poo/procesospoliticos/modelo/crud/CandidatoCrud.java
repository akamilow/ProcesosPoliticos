package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Candidato;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Ciudadano;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Partido;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Comuna;

import java.util.HashMap;

public class CandidatoCrud {

    private HashMap<Integer, Candidato> candidatos = new HashMap<>();

    public void agregarCandidato(Candidato candidato) throws Exception {
        if (candidatos.containsKey(candidato.getDNICiudadano())) {
            throw new Exception("El candidato ya existe en la lista");
        }
        candidatos.put(candidato.getDNICiudadano(), new Candidato(candidato, candidato.getPartidoElectoral(), candidato.getComuna(), candidato.getCategoria()));
    }

    public Candidato buscarCandidato(Integer DNI) throws Exception {
        if (!candidatos.containsKey(DNI)) {
            throw new Exception("El candidato no existe");
        }
        return candidatos.get(DNI);
    }

    public void actualizarCandidato(Ciudadano ciudadano, Partido partido, Comuna comuna, String categoria) throws Exception {
        if (!candidatos.containsKey(ciudadano.getDNICiudadano())) {
            throw new Exception("El candidato no existe");
        }
        candidatos.put(ciudadano.getDNICiudadano(), new Candidato(ciudadano, partido, comuna, categoria));
    }

    public void eliminarCandidato(Integer DNI) throws Exception {
        if (!candidatos.containsKey(DNI)) {
            throw new Exception("El candidato no existe");
        }
        candidatos.remove(DNI);
    }

    public HashMap<Integer, Candidato> listarCandidatos() {
        return candidatos;
    }

    public int contarCandidatos() {
        return candidatos.size();
    }
}
