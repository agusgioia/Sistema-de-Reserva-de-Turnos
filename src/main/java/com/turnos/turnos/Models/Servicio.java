package com.turnos.turnos.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "servicios")
@Data
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "duracion_minutos")
    private Integer duracionMinutos;

    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "negocio_id")
    private Negocio negocio;

}