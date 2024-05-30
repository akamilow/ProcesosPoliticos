package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Partido;
import co.edu.ude.poo.procesospoliticos.util.config.DBConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class PartidoCrud {

    public HashMap<Integer, Partido> partidos = new HashMap<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public void agregarPartido(Integer id, Partido nombrePartido) throws Exception{
        con = DBConection.ConnectionDB();
        String sql = "INSERT INTO Partido (id, nombre) VALUES (?, ?);";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nombrePartido.getNombrePartido());
            ps.executeUpdate();
        }catch(Exception e){
            throw new Exception("Error al insertar partido: " + e);
        }finally{
            try{
                if(con != null) con.close();
                if(ps != null) ps.close();
            }catch(Exception e){
                throw new Exception("Error al cerrar la conexión: " + e);
            }
        }
        /*if(partidos.containsKey(id) || partidos.containsValue(nombrePartido)) {
            throw new Exception("El partido ya existe");
        }
        partidos.put(id, nombrePartido);*/
    }

    public Partido buscarPartido(Integer id) throws Exception{
        if(partidos.containsKey(id)){
            return partidos.get(id);
        }
        throw new Exception("El partido no existe");
    }
    
    public void actualizarPartido(Integer id, String nuevoNombre) throws Exception{
        if(partidos.containsKey(id)){
            partidos.get(id).setNombrePartido(nuevoNombre);
            return;
        }
        throw new Exception("El partido no existe");
    }

    public void eliminarPartido(Integer id) throws Exception{
        if(partidos.containsKey(id)){
            partidos.remove(id);
            return;
        }
        throw new Exception("El partido no existe");
    }

    public HashMap<Integer, Partido> listarPartidos(){
        return partidos;
    }

    public int numeroPartidos(){
        return partidos.size();
    }
}