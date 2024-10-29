package com.upc.tripbundle.repositories;

import com.upc.tripbundle.entities.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {
    @Query(value="SELECT \n" +
            "    p.id AS paquete_id,\n" +
            "    p.descripcion AS descripcion_paquete,\n" +
            "    p.alojamiento,\n" +
            "    d.nombre AS departamento,\n" +
            "    r.cantidad_personas\n" +
            "FROM \n" +
            "    Paquete p\n" +
            "JOIN \n" +
            "    Reserva r ON p.id = r.Paquete_id\n" +
            "JOIN \n" +
            "    Departamento d ON r.Departamento_id = d.id\n" +
            "WHERE \n" +
            "    d.nombre = 'lima' \n" +
            "    AND r.cantidad_personas * (SELECT AVG(monto) FROM Pago WHERE Reserva_id = r.id) <= '1000'\n" +
            "ORDER BY \n" +
            "    r.cantidad_personas * (SELECT AVG(monto) FROM Pago WHERE Reserva_id = r.id)", nativeQuery = true)
    public List<String[]> obtenerAlojamientoPorPrecio();

@Query(value = "select pa.*, de.*\n" +
        "from paquete pa\n" +
        "join atractivoturistico atr on pa.atractivoturistico_id=atr.id\n" +
        "join departamento de on atr.departamento_id=de.id\n" +
        "where pa.categoria=:categoria\n" +
        "order by pa.valoracion desc",nativeQuery = true)
public List<String[]> paqueteDepartamento(@Param("categoria") String categoria);
}
