package com.turnos.turnos.Services;

import com.turnos.turnos.Models.HorarioTrabajo;
import com.turnos.turnos.Repositories.HorarioTrabajoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioTrabajoService {

    private final HorarioTrabajoRepository horarioRepository;

    public HorarioTrabajoService(HorarioTrabajoRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public List<HorarioTrabajo> porEmpleado(Long empleadoId) {
        return horarioRepository.findByEmpleadoId(empleadoId);
    }

    public HorarioTrabajo crear(HorarioTrabajo horario) {
        return horarioRepository.save(horario);
    }

    public void eliminar(Long id) {
        horarioRepository.deleteById(id);
    }

}