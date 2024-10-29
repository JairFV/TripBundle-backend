package com.upc.tripbundle.dtos;

import com.upc.tripbundle.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private Integer id;
    private String detalleReserva;
    private LocalDate fechaReserva;
    private Integer cantidadPersonas;
    private Integer idUsuario;
    private Integer idAdministrador;
    private Integer idPaquete;
    //private Set<Pago> pagos = new LinkedHashSet<>();
}
