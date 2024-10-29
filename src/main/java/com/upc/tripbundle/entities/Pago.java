package com.upc.tripbundle.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "estado", nullable = false, length = 30)
    private String estado;

    @NotNull
    @Column(name = "monto", nullable = false, precision = 5, scale = 2)
    private BigDecimal monto;

    @Size(max = 30)
    @NotNull
    @Column(name = "metodo_pago", nullable = false, length = 30)
    private String metodoPago;

    @NotNull
    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;

    @OneToMany(mappedBy = "pago")
    private Set<Boleta> boletas = new LinkedHashSet<>();

}