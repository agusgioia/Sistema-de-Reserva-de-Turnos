package com.turnos.turnos.Repositories;

import com.turnos.turnos.Models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio,Long> {
    List<Servicio> findByNegocioId(Long negocioId);
}
