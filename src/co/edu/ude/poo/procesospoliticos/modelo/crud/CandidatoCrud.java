package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Candidato;

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

    public void actualizarCandidato(Candidato candidato, Candidato nuevoCandidato) throws Exception {
        if (!candidatos.containsKey(candidato.getDNICiudadano())) {
            throw new Exception("El candidato no existe");
        }
        candidatos.put(candidato.getDNICiudadano(), nuevoCandidato);
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
