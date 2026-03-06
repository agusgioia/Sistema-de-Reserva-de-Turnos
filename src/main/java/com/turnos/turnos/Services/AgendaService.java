package com.turnos.turnos.Services;

import com.turnos.turnos.Models.HorarioTrabajo;
import com.turnos.turnos.Models.Servicio;
import com.turnos.turnos.Models.Turno;
import com.turnos.turnos.Repositories.HorarioTrabajoRepository;
import com.turnos.turnos.Repositories.ServicioRepository;
import com.turnos.turnos.Repositories.TurnoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaService {

    private final TurnoRepository turnoRepository;
    private final HorarioTrabajoRepository horarioRepository;
    private final ServicioRepository servicioRepository;

    public AgendaService(
            TurnoRepository turnoRepository,
            HorarioTrabajoRepository horarioRepository,
            ServicioRepository servicioRepository) {

        this.turnoRepository = turnoRepository;
        this.horarioRepository = horarioRepository;
        this.servicioRepository = servicioRepository;
    }

    public List<LocalTime> horariosDisponibles(
            Long empleadoId,
            Long servicioId,
            LocalDate fecha) {

        int diaSemana = fecha.getDayOfWeek().getValue();

        HorarioTrabajo horario = horarioRepository
                .findByEmpleadoIdAndDiaSemana(empleadoId, diaSemana)
                .stream()
                .findFirst()
                .orElseThrow();

        Servicio servicio = servicioRepository.findById(servicioId).orElseThrow();

        List<Turno> turnos = turnoRepository.findByEmpleadoIdAndFecha(empleadoId, fecha);

        List<LocalTime> disponibles = new ArrayList<>();

        LocalTime inicio = horario.getHoraInicio();
        LocalTime fin = horario.getHoraFin();

        int duracion = servicio.getDuracionMinutos();

        while (inicio.plusMinutes(duracion).isBefore(fin) || inicio.plusMinutes(duracion).equals(fin)) {

            LocalTime posibleFin = inicio.plusMinutes(duracion);

            LocalTime finalInicio = inicio;

            boolean ocupado = turnos.stream().anyMatch(t ->
                    finalInicio.isBefore(t.getHoraFin()) &&
                            posibleFin.isAfter(t.getHoraInicio())
            );

            if (!ocupado) {
                disponibles.add(inicio);
            }

            inicio = inicio.plusMinutes(duracion);
        }

        return disponibles;
    }
}