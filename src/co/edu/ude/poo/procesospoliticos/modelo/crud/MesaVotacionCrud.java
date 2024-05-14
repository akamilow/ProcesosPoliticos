package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.ApoderadoMesa;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.LocalVotacion;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.MesaVotacion;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalMesa;

import java.util.HashMap;

public class MesaVotacionCrud {
    
    public HashMap<Integer, MesaVotacion> mesas = new HashMap<>();
    
    public void agregarMesaVotacion(Integer numeroMesa, MesaVotacion mesaVotacion) throws Exception {
        if (mesas.containsKey(numeroMesa)) {
            throw new Exception("La mesa ya existe");
        }
        mesas.put(numeroMesa, mesaVotacion);
    }

    public MesaVotacion buscarMesaVotacion(Integer numeroMesa) throws Exception {
        if (!mesas.containsKey(numeroMesa)) {
            throw new Exception("La mesa no existe");
        }
        return mesas.get(numeroMesa);
    }

    public void actualizarMesaVotacion(Integer numeroMesa, String generoMesa, String estadoMesa, LocalVotacion localVotacion, VocalMesa vocalMesa, ApoderadoMesa apoderadoMesaUno, ApoderadoMesa apoderadoMesaDos) throws Exception {
        if (!mesas.containsKey(numeroMesa)) {
            throw new Exception("La mesa no existe");
        }
        MesaVotacion mesaVotacion = mesas.get(numeroMesa);
        mesaVotacion.setGeneroMesa(generoMesa);
        mesaVotacion.setEstadoMesa(estadoMesa);
        mesaVotacion.setLocalVotacion(localVotacion);
        mesaVotacion.setVocalMesa(vocalMesa);
        mesaVotacion.setApoderadoMesaUno(apoderadoMesaUno);
        mesaVotacion.setApoderadoMesaDos(apoderadoMesaDos);
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
