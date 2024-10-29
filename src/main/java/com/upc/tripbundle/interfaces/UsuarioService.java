package com.upc.tripbundle.interfaces;

import com.upc.tripbundle.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    public Usuario buscarUsuario(Integer id);
    public List<Usuario> buscarUsuarios();
    public Usuario insertarUsuario(Usuario usuario);
    public Usuario actualizarUsuario(Usuario usuario);
    public void eliminarUsuario(Integer id);
}
