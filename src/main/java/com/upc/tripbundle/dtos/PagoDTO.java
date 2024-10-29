package com.upc.tripbundle.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagoDTO {
    private Integer id;
    private String estado;
    private BigDecimal monto;
    private String metodoPago;
    private LocalDate fechaPago;
    private Integer idReserva;
    //private Set<Boleta> boletas = new LinkedHashSet<>();
}
