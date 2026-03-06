package com.turnos.turnos.Repositories;

import com.turnos.turnos.Models.HorarioTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioTrabajoRepository extends JpaRepository<HorarioTrabajo,Long> {
    List<HorarioTrabajo> findByEmpleadoId(Long empleadoId);
    List<HorarioTrabajo> findByEmpleadoIdAndDiaSemana(Long empleadoId, Integer diaSemana);
}
