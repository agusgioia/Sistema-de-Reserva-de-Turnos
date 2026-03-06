package com.turnos.turnos.Repositories;

import com.turnos.turnos.Models.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TurnoRepository extends JpaRepository<Turno,Long> {

    List<Turno> findByEmpleadoIdAndFecha(Long empleadoId, LocalDate fecha);
}
