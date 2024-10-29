package com.upc.tripbundle.repositories;

import com.upc.tripbundle.entities.Atractivoturistico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtractivoRepository extends JpaRepository <Atractivoturistico, Integer>  {

    @Query(value="select atr.nombre, de.nombre, sum(re.cantidad_personas)\n" +
            "from atractivoturistico atr\n" +
            "join departamento de on atr.departamento_id=de.id\n" +
            "join paquete pa on pa.atractivoturistico_id=atr.id\n" +
            "join reserva re on re.paquete_id=pa.id\n" +
            "group by atr.nombre, de.nombre \n" +
            "order by  sum(re.cantidad_personas)",nativeQuery = true)
    public List<String[]> AtrativoPorCantiddadPersonasVisitadas();

    @Query(value="SELECT \n" +
            "    nombre,\n" +
            "    descripcion,\n" +
            "    valoracion\n" +
            "FROM \n" +
            "    AtractivoTuristico\n" +
            "ORDER BY \n" +
            "    valoracion DESC", nativeQuery = true)
    public List<String[]> MejoresAtrativos();
}
