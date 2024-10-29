package com.upc.tripbundle.services;

import com.upc.tripbundle.entities.Usuario;
import com.upc.tripbundle.repositories.UsuarioRepository;
import com.upc.tripbundle.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario buscarUsuario(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario insertarUsuario(Usuario usuario) {
        Usuario usuarioaux=usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioaux==null) {
            String pass = usuario.getPassword();
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(pass);
            usuario.setPassword(encodedPassword);
            return usuarioRepository.save(usuario);
        }
      return new Usuario();
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        if(usuarioRepository.findById(usuario.getId()).isPresent())
            return usuarioRepository.save(usuario);
        return null;
    }

    @Override
    public void eliminarUsuario(Integer id) {
        if(usuarioRepository.findById(id).isPresent())
            usuarioRepository.deleteById(id);
    }
}
