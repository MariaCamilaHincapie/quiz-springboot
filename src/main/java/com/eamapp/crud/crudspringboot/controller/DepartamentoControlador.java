package com.eamapp.crud.crudspringboot.controller;

import com.eamapp.crud.crudspringboot.entity.Departamento;
import com.eamapp.crud.crudspringboot.service.DepartamentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartamentoControlador {
    @Autowired
    private DepartamentoServicio servicio;

    @GetMapping({ "/departamentos"})
    public String listarDepartamentos(Model modelo) {
        modelo.addAttribute("departamentos", servicio.listarTodosLosDepartamentos());
        return "departamentos"; // nos retorna al archivo departamentos
    }

    @GetMapping("/departamentos/nuevo")
    public String mostrarFormularioDeRegistrarDepartamento(Model modelo) {
        Departamento departamento = new Departamento();
        modelo.addAttribute("departamento", departamento);
        return "crear_departamento";
    }

    @PostMapping("/departamentos")
    public String guardarDepartamento(@ModelAttribute("departamento") Departamento departamento) {
        servicio.guardarDepartamento(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/departamentos/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("departamento", servicio.obtenerDepartamentoPorId(id));
        return "editar_departamento";
    }

    @PostMapping("/departamentos/{id}")
    public String actualizarDepartamento(@PathVariable Long id, @ModelAttribute("departamento") Departamento departamento,
            Model modelo) {
        Departamento departamentoExistente = servicio.obtenerDepartamentoPorId(id);
        departamentoExistente.setId(id);
        departamentoExistente.setNombre(departamento.getNombre());
        departamentoExistente.setPresupuesto(departamento.getPresupuesto());
        departamentoExistente.setGastos(departamento.getGastos());

        servicio.actualizarDepartamento(departamentoExistente);
        return "redirect:/departamentos";
    }

    @GetMapping("/departamentos/{id}")
    public String eliminarDepartamento(@PathVariable Long id) {
        servicio.eliminarDepartamento(id);
        return "redirect:/departamentos";
    }
}
