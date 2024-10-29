package com.upc.tripbundle.repositories;

import com.upc.tripbundle.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
Administrador findByUsername(String username);
}


