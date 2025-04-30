package com.example.validacao_formularios.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.validacao_formularios.models.Estudante;

import jakarta.validation.Valid;


@Controller
public class EstudanteController {

    @GetMapping("/estudante")
    public String cadastro(Estudante estudante) {
        return "estudante-cadastro";
    }

    @PostMapping("/estudante")
    public String processarCadastro(@Valid Estudante estudante, BindingResult fields, Model model) throws IOException {

        //Deveria estar em um lugar compartilhado
        String UPLOAD_DIR = "src/main/resources/static/uploads/";

        if (fields.hasErrors()) {
            return "estudante-cadastro";
        }

        if (estudante.getAvatar() != null && !estudante.getAvatar().isEmpty()) {
            
            String fileName = estudante.getAvatar().getOriginalFilename();

            Path path = Paths.get(UPLOAD_DIR + fileName);

            Files.createDirectories(path.getParent());
            Files.copy(estudante.getAvatar().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        }



        //processamento (na camada de servico)
        
        model.addAttribute("estudante", estudante);

        return "sucesso";
    }
    
    
    
}
