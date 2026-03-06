package com.turnos.turnos.Repositories;
import com.turnos.turnos.Models.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NegocioRepository extends JpaRepository<Negocio, Long> {
}