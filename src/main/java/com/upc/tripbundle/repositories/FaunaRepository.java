package com.upc.tripbundle.repositories;

import com.upc.tripbundle.entities.Fauna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FaunaRepository extends JpaRepository<Fauna, Integer> {
    @Query(value="SELECT \n" +
            "    f.nombre AS nombre_fauna,\n" +
            "    f.descripcion AS descripcion_fauna,\n" +
            "    d.nombre AS departamento\n" +
            "FROM \n" +
            "    Fauna f\n" +
            "JOIN \n" +
            "    Departamento d ON f.Departamento_id = d.id\n" +
            "WHERE \n" +
            "    d.nombre = :nombre", nativeQuery = true)
    public List<String[]> obtenerFaunaDescripcion(@Param("nombre") String nombre);
}
