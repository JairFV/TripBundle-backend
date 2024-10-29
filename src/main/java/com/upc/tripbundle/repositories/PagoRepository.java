package com.upc.tripbundle.repositories;

import com.upc.tripbundle.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    @Query(value = "SELECT p.*\n" +
            "FROM pago p\n" +
            "JOIN reserva r ON p.reserva_id = r.id\n" +
            "WHERE r.paquete_id = 1\n" +
            "  AND p.monto < 500", nativeQuery = true)
    public List<String[]> buscarPaqueteSegunPrecio();

    @Query(value="select pa.*\n" +
            "from pago pa\n" +
            "join reserva re on pa.reserva_id=re.id\n" +
            "join administrador ad on re.administrador_id=ad.id\n" +
            "where ad.id=1", nativeQuery = true)
    public List<String[]> listarPagos();
}
