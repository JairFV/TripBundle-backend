package com.upc.tripbundle.repositories;

import com.upc.tripbundle.entities.Flora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FloraRepository extends JpaRepository<Flora, Integer> {
    @Query(value = "SELECT \n" +
            "    f.nombre AS nombre_flora,\n" +
            "    f.descripcion AS descripcion_flora,\n" +
            "    d.nombre AS departamento\n" +
            "FROM \n" +
            "    Flora f\n" +
            "JOIN \n" +
            "    Departamento d ON f.Departamento_id = d.id\n" +
            "WHERE \n" +
            "    d.nombre = :nombre", nativeQuery = true)
    public List<String[]> obtenerFloraDescripcion(@Param("nombre") String nombre);
}
