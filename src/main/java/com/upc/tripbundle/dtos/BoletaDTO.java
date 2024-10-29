package com.upc.tripbundle.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoletaDTO {
    private Integer id;
    private LocalDate fechaBoleta;
    private Integer idPago;
}
