package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Candidato;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Partido;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Comuna;

import java.util.HashMap;

public class CandidatoCrud {

    public HashMap<Integer, Candidato> candidatos = new HashMap<>();

    public void agregarCandidato(Integer id, Candidato candidato) throws Exception {
        if (candidatos.containsKey(id)) {
            throw new Exception("El candidato ya existe");
        }
        candidatos.put(id, candidato);
    }

    public Candidato buscarCandidato(Integer DNI) throws Exception {
        if (!candidatos.containsKey(DNI)) {
            throw new Exception("El candidato no existe");
        }
        return candidatos.get(DNI);
    }

    public void actualizarCandidato(Integer id, Partido nombrePartido, Comuna comuna, String categoria) throws Exception {
        if (!candidatos.containsKey(id)) {
            throw new Exception("El candidato no existe");
        }
        Candidato candidato = candidatos.get(id);
        candidato.setPartidoElectoral(nombrePartido);
        candidato.setComuna(comuna);
        candidato.setCategoria(categoria);
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
