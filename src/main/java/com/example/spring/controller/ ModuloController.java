package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.modelo.estadoModelo;
import com.example.spring.repositorios.ModuloRepositorio;


@Controller
public class ModuloController {
    
    @Autowired
    private ModuloRepositorio estadoModelo;

    @GetMapping("/Administrativo/home/cadastro")
    public ModelAndView cadastrar(estadoModelo estado) {
        ModelAndView mv = new ModelAndView("/Administrativo/home/cadastro");
        mv.addObject("estado", estado);
            return mv;
        }
    
    }
