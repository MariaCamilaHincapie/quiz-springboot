package com.eamapp.crud.crudspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControlador {
    @GetMapping("/")
    public String verPaginaDeInicio(){
        return "index";
    }
}
