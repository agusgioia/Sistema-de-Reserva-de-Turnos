package com.turnos.turnos.Controllers;

import com.turnos.turnos.Services.AgendaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping("/disponibles")
    public List<LocalTime> horariosDisponibles(
            @RequestParam Long empleadoId,
            @RequestParam Long servicioId,
            @RequestParam LocalDate fecha) {

        return agendaService.horariosDisponibles(empleadoId, servicioId, fecha);
    }
}