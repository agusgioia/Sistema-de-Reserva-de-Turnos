package com.turnos.turnos.Services;

import com.turnos.turnos.Models.Empleado;
import com.turnos.turnos.Repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> listar() {
        return empleadoRepository.findAll();
    }

    public Empleado obtener(Long id) {
        return empleadoRepository.findById(id).orElseThrow();
    }

    public List<Empleado> porNegocio(Long negocioId) {
        return empleadoRepository.findByNegocioId(negocioId);
    }

    public Empleado crear(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado actualizar(Long id, Empleado empleado) {
        empleado.setId(id);
        return empleadoRepository.save(empleado);
    }

    public void eliminar(Long id) {
        empleadoRepository.deleteById(id);
    }

}