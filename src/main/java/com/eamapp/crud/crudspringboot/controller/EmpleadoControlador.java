package com.eamapp.crud.crudspringboot.controller;

import com.eamapp.crud.crudspringboot.entity.Departamento;
import com.eamapp.crud.crudspringboot.entity.Empleado;
import com.eamapp.crud.crudspringboot.service.DepartamentoServicio;
import com.eamapp.crud.crudspringboot.service.EmpleadoServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServicio servicio;

    @Autowired
    private DepartamentoServicio servicio2;

    @GetMapping({ "/empleados"})
    public String listarEmpleados(Model modelo) {
        modelo.addAttribute("empleados", servicio.listarTodosLosEmpleados());
        return "empleados"; // nos retorna al archivo empleados
    }

    @GetMapping("/empleados/nuevo")
    public String mostrarFormularioDeRegistrarEmpleado(Model modelo) {
        Empleado empleado = new Empleado();
        modelo.addAttribute("empleado", empleado);
        modelo.addAttribute("listaDepartamentos", servicio2.listarTodosLosDepartamentos());
        return "crear_empleado";
    }

    @PostMapping("/empleados")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        servicio.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("empleado", servicio.obtenerEmpleadoPorId(id));
        return "editar_empleado";
    }

    @PostMapping("/empleados/{id}")
    public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute("empleado") Empleado empleado,
            Model modelo) {
        Empleado empleadoExistente = servicio.obtenerEmpleadoPorId(id);
        empleadoExistente.setId(id);
        empleadoExistente.setNif(empleado.getNif());
        empleadoExistente.setNombre(empleado.getNombre());
        empleadoExistente.setApellido1(empleado.getApellido1());
        empleadoExistente.setApellido2(empleado.getApellido2());
        empleadoExistente.setDepartamento(empleado.getDepartamento());

        servicio.actualizarEmpleado(empleadoExistente);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        servicio.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
}
