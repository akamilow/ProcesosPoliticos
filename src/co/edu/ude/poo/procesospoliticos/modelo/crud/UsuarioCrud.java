package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Usuario;

import java.util.HashMap;

public class UsuarioCrud {
    
    public HashMap<Integer, Usuario> usuarios = new HashMap<>();

    public void agregarUsuario(Integer dni, Usuario usuario) throws Exception{
        if(usuarios.containsKey(dni) || usuarios.containsValue(usuario)) {
            throw new Exception("El usuario ya existe");
        }
        usuarios.put(dni, usuario);
    }

    public Usuario buscarUsuario(Integer dni) throws Exception{
        if(usuarios.containsKey(dni)){
            return usuarios.get(dni);
        }
        throw new Exception("El usuario no existe");
    }

    public void actualizarUsuario(Integer dni, String nuevaContrasena) throws Exception{
        if(usuarios.containsKey(dni)){
            usuarios.get(dni).setContrasena(nuevaContrasena);
            return;
        }
        throw new Exception("El usuario no existe");
    }

    public void eliminarUsuario(Integer dni) throws Exception{
        if(usuarios.containsKey(dni)){
            usuarios.remove(dni);
            return;
        }
        throw new Exception("El usuario no existe");
    }

    public HashMap<Integer, Usuario> listarUsuarios(){
        return usuarios;
    }

    public int numeroUsuarios(){
        return usuarios.size();
    }
}
