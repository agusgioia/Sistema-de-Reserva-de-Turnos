package com.turnos.turnos.Services;

import com.turnos.turnos.Models.Negocio;
import com.turnos.turnos.Repositories.NegocioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioService {

    private final NegocioRepository negocioRepository;

    public NegocioService(NegocioRepository negocioRepository) {
        this.negocioRepository = negocioRepository;
    }

    public List<Negocio> listar() {
        return negocioRepository.findAll();
    }

    public Negocio obtener(Long id) {
        return negocioRepository.findById(id).orElseThrow();
    }

    public Negocio crear(Negocio negocio) {
        return negocioRepository.save(negocio);
    }

    public Negocio actualizar(Long id, Negocio negocio) {
        negocio.setId(id);
        return negocioRepository.save(negocio);
    }

    public void eliminar(Long id) {
        negocioRepository.deleteById(id);
    }

}