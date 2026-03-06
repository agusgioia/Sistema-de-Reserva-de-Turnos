package com.turnos.turnos.Controllers;

import com.turnos.turnos.Models.Turno;
import com.turnos.turnos.Services.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping("/empleado/{empleadoId}/fecha/{fecha}")
    public List<Turno> turnosPorEmpleadoYFecha(
            @PathVariable Long empleadoId,
            @PathVariable LocalDate fecha) {

        return turnoService.turnosPorEmpleadoYFecha(empleadoId, fecha);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Turno turno) {

        try {
            Turno nuevo = turnoService.crear(turno);
            return ResponseEntity.ok(nuevo);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void cancelar(@PathVariable Long id) {
        turnoService.cancelar(id);
    }

}