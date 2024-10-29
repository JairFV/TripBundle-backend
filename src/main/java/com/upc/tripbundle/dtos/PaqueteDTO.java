package com.upc.tripbundle.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaqueteDTO {
    private Integer id;
    private String categoria;
    private String descripcion;
    private String alojamiento;
    private String transporte;
    private Integer valoracion;
   private Integer idAtractivo;

}
