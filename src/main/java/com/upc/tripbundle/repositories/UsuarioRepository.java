package com.upc.tripbundle.repositories;

import com.upc.tripbundle.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findByNombre(String nombre);
    Usuario findByUsername(String username);
}
