package com.example.validacao_formularios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.validacao_formularios.models.Estudante;


@Controller
public class EstudanteController {

    @GetMapping("/estudante")
    public String cadastro() {
        return "estudante-cadastro";
    }

    @PostMapping("/estudante")
    public String processarCadastro(Estudante estudante, Model model) {



        //processamento (na camada de servico)
        
        model.addAttribute("estudante", estudante);

        return "sucesso";
    }
    
    
    
}
