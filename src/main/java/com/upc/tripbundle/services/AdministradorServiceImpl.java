package com.upc.tripbundle.services;

import com.upc.tripbundle.entities.Administrador;
import com.upc.tripbundle.interfaces.AdministradorService;
import com.upc.tripbundle.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;
    @Override
    public Administrador buscarAdministrador(Integer id) {
        return administradorRepository.findById(id).get();
    }

    @Override
    public List<Administrador> buscarAdministrador() {
        return administradorRepository.findAll();
    }

    @Override
    public Administrador insertarAdministrador(Administrador administrador) {
        Administrador admin = administradorRepository.findByUsername(administrador.getUsername());
        if (admin == null) {
        String pass = administrador.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(pass);
        administrador.setPassword(encodedPassword);
        return administradorRepository.save(administrador);
        }
        return new Administrador();
    }

    @Override
    public Administrador actualizarAdministrador(Administrador administrador) {
        return null;
    }

    @Override
    public void eliminarAdministrador(Integer id) {

    }
}
