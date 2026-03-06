package com.turnos.turnos.Services;

import com.turnos.turnos.Models.Servicio;
import com.turnos.turnos.Repositories.ServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> listar() {
        return servicioRepository.findAll();
    }

    public List<Servicio> porNegocio(Long negocioId) {
        return servicioRepository.findByNegocioId(negocioId);
    }

    public Servicio crear(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Servicio actualizar(Long id, Servicio servicio) {
        servicio.setId(id);
        return servicioRepository.save(servicio);
    }

    public void eliminar(Long id) {
        servicioRepository.deleteById(id);
    }

}