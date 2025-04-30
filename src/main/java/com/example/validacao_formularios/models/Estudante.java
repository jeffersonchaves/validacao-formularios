package com.example.validacao_formularios.models;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Estudante {

    @NotNull(message = "o nome não pode estar vazio")
    @Size(min = 1, max = 5, message = "o tamanho nome deve ser entre 1 e 5 caracteres")
    private String nome;

    private LocalDate dataNascimento;

    @Size(min = 1, max = 5, message = "o tamanho de matricula deve ser entre 1 e 5 caracteres")
    private String matricula;

    private MultipartFile avatar;
    
    public Estudante(){}

    public Estudante(String nome, LocalDate dataNascimento, String matricula) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    
    


}
