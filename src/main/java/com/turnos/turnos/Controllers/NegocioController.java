package com.turnos.turnos.Controllers;

import com.turnos.turnos.Models.Negocio;
import com.turnos.turnos.Services.NegocioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/negocios")
public class NegocioController {

    private final NegocioService negocioService;

    public NegocioController(NegocioService negocioService) {
        this.negocioService = negocioService;
    }

    @GetMapping
    public List<Negocio> listar() {
        return negocioService.listar();
    }

    @GetMapping("/{id}")
    public Negocio obtener(@PathVariable Long id) {
        return negocioService.obtener(id);
    }

    @PostMapping
    public Negocio crear(@RequestBody Negocio negocio) {
        return negocioService.crear(negocio);
    }

    @PutMapping("/{id}")
    public Negocio actualizar(@PathVariable Long id, @RequestBody Negocio negocio) {
        return negocioService.actualizar(id, negocio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        negocioService.eliminar(id);
    }

}