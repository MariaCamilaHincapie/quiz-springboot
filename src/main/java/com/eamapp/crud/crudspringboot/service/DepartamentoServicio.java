package com.eamapp.crud.crudspringboot.service;

import java.util.List;

import com.eamapp.crud.crudspringboot.entity.Departamento;

public interface DepartamentoServicio {
    public List<Departamento> listarTodosLosDepartamentos();

    public Departamento guardarDepartamento(Departamento departamento);

    public Departamento obtenerDepartamentoPorId(Long id);

    public Departamento actualizarDepartamento(Departamento departamento);

    public void eliminarDepartamento(Long id);
}