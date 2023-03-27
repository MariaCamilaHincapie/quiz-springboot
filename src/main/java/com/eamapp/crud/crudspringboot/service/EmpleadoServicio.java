package com.eamapp.crud.crudspringboot.service;

import java.util.List;

import com.eamapp.crud.crudspringboot.entity.Empleado;

public interface EmpleadoServicio {
    public List<Empleado> listarTodosLosEmpleados();

    public Empleado guardarEmpleado(Empleado empleado);

    public Empleado obtenerEmpleadoPorId(Long id);

    public Empleado actualizarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Long id);
}