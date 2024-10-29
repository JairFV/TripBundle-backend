package com.upc.tripbundle.serviceimplements;


import com.upc.tripbundle.entities.Administrador;
import com.upc.tripbundle.repositories.AdministradorRepository;
import com.upc.tripbundle.repositories.UsuarioRepository;
import com.upc.tripbundle.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private AdministradorRepository administradorRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        Administrador administrador = administradorRepository.findByUsername(username);
        if (usuario != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(usuario.getRol()));
            return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, grantedAuthorities);
        }else if(administrador != null){
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(administrador.getRol()));
            return new org.springframework.security.core.userdetails.User(administrador.getUsername(), administrador.getPassword(), true, true, true, true, grantedAuthorities);
        }
        throw new UsernameNotFoundException("este usuario " + username + " no existe");
    }
}
