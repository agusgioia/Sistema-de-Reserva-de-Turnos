package com.turnos.turnos.Controllers;

import com.turnos.turnos.Models.Servicio;
import com.turnos.turnos.Services.ServicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public List<Servicio> listar() {
        return servicioService.listar();
    }

    @GetMapping("/negocio/{negocioId}")
    public List<Servicio> porNegocio(@PathVariable Long negocioId) {
        return servicioService.porNegocio(negocioId);
    }

    @PostMapping
    public Servicio crear(@RequestBody Servicio servicio) {
        return servicioService.crear(servicio);
    }

    @PutMapping("/{id}")
    public Servicio actualizar(@PathVariable Long id, @RequestBody Servicio servicio) {
        return servicioService.actualizar(id, servicio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicioService.eliminar(id);
    }

}