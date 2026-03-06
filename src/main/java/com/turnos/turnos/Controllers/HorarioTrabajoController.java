package com.turnos.turnos.Controllers;

import com.turnos.turnos.Models.HorarioTrabajo;
import com.turnos.turnos.Services.HorarioTrabajoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioTrabajoController {

    private final HorarioTrabajoService horarioService;

    public HorarioTrabajoController(HorarioTrabajoService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping("/empleado/{empleadoId}")
    public List<HorarioTrabajo> porEmpleado(@PathVariable Long empleadoId) {
        return horarioService.porEmpleado(empleadoId);
    }

    @PostMapping
    public HorarioTrabajo crear(@RequestBody HorarioTrabajo horario) {
        return horarioService.crear(horario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        horarioService.eliminar(id);
    }

}