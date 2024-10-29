package com.upc.tripbundle.repositories;

import com.upc.tripbundle.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    @Query(value="select re.*\n" +
            "from reserva  re\n" +
            "join paquete pa on re.paquete_id=pa.id\n" +
            "join atractivoturistico atr on pa.atractivoturistico_id=atr.id\n" +
            "join departamento de on atr.departamento_id=de.id\n" +
            "where de.nombre=:nombre ", nativeQuery = true)
    public List<String []> obtenerReservasPorDepartamento(@Param("nombre") String nombre);

    @Query(value="select re.*\n" +
            "from reserva re\n" +
            "join administrador ad\n" +
            "on re.administrador_id=ad.id\n" +
            "where ad.id=:id", nativeQuery = true)
    public List<String[]> gestionarReservas(@Param("id") Integer id);

    @Query(value = "select re.*, de.*\n" +
            "from reserva  re\n" +
            "join administrador ad on re.administrador_id=ad.id\n" +
            "join paquete pa on re.paquete_id=pa.id\n" +
            "join atractivoturistico atr on pa.atractivoturistico_id=atr.id\n" +
            "join departamento de on atr.departamento_id=de.id\n" +
            "where ad.id=:id",nativeQuery = true)
    public List<String[]> gestionarReservasDepartamento(@Param("id") Integer id);

    @Query(value = "select re.*\n" +
            "from reserva re\n" +
            "join usuario us on re.usuario_id=us.id\n" +
            "where us.id=:id",nativeQuery = true)
    public List<String[]> reservasUsuario(@Param("id") Integer id);
}
