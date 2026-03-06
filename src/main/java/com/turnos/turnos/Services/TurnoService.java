package com.turnos.turnos.Services;

import com.turnos.turnos.Models.Turno;
import com.turnos.turnos.Repositories.TurnoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public List<Turno> turnosPorEmpleadoYFecha(Long empleadoId, LocalDate fecha) {
        return turnoRepository.findByEmpleadoIdAndFecha(empleadoId, fecha);
    }

    public Turno crear(Turno turno) {
        try {
            return turnoRepository.save(turno);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("El turno ya fue reservado");
        }
    }

    public void cancelar(Long id) {
        turnoRepository.deleteById(id);
    }

}