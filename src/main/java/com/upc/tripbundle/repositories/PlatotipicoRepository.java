package com.upc.tripbundle.repositories;

import com.upc.tripbundle.entities.Platotipico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlatotipicoRepository extends JpaRepository<Platotipico, Integer> {
    @Query(value="SELECT \n" +
            "    p.nombre AS nombre_plato,\n" +
            "    p.descripcion AS descripcion_plato,\n" +
            "    d.nombre AS departamento\n" +
            "FROM \n" +
            "    Platotipico p\n" +
            "JOIN \n" +
            "    Departamento d ON p.Departamento_id = d.id\n" +
            "WHERE \n" +
            "    d.nombre = :nombre", nativeQuery = true)
    public List<String[]> obtenerPlatoDescripcion(@Param("nombre") String nombre);
}
