package com.turnos.turnos.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "negocios")
@Data
public class Negocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn;

}