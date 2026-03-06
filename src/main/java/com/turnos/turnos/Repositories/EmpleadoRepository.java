package com.turnos.turnos.Repositories;

import com.turnos.turnos.Models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
    List<Empleado> findByNegocioId(Long negocioId);
}
