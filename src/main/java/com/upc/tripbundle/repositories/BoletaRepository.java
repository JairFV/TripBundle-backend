package com.upc.tripbundle.repositories;

import com.upc.tripbundle.entities.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
    @Query(value="select bo.*\n" +
            "from boleta bo\n" +
            "join pago pa on bo.pago_id=pa.id\n" +
            "join reserva re on pa.reserva_id=re.id\n" +
            "join usuario us on re.usuario_id=us.id\n" +
            "where us.id=:id", nativeQuery = true)
    public List<String[]> obtenerBoletaPorUsuario(@Param("id") Integer id);
}
