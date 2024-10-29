package com.upc.tripbundle.repositories;

import com.upc.tripbundle.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
}
