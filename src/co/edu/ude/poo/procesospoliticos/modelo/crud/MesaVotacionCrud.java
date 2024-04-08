package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.MesaVotacion;

import java.util.HashMap;

public class MesaVotacionCrud {
    
    private HashMap<Integer, MesaVotacion> mesas = new HashMap<>();
    
    public void agregarMesaVotacion(MesaVotacion mesaVotacion) throws Exception {
        if (mesas.containsKey(mesaVotacion.getNumeroMesa())) {
            throw new Exception("La mesa ya existe");
        }
        mesas.put(mesaVotacion.getNumeroMesa(), mesaVotacion);
    }

    public MesaVotacion buscarMesaVotacion(Integer numeroMesa) throws Exception {
        if (!mesas.containsKey(numeroMesa)) {
            throw new Exception("La mesa no existe");
        }
        return mesas.get(numeroMesa);
    }

    public void actualizarMesaVotacion(Integer numeroMesa, MesaVotacion nuevaMesaVotacion) throws Exception {
        if (!mesas.containsKey(numeroMesa)) {
            throw new Exception("La mesa no existe");
        }
        mesas.put(numeroMesa, nuevaMesaVotacion);
    }

    public void eliminarMesaVotacion(Integer numeroMesa) throws Exception {
        if (!mesas.containsKey(numeroMesa)) {
            throw new Exception("La mesa no existe");
        }
        mesas.remove(numeroMesa);
    }

    public HashMap<Integer, MesaVotacion> listarMesas() {
        return mesas;
    }

    public int contarMesas() {
        return mesas.size();
    }
}
