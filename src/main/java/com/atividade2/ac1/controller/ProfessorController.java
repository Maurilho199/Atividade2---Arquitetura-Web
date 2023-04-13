package com.atividade2.ac1.controller;

import java.util.List;
import java.util.Optional;

import com.atividade2.ac1.model.Professor;
import com.atividade2.ac1.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProfessorController {
    
    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping(value = "/criaprofessor")
    public Professor criaCurso(@RequestBody Professor professor){
        return this.professorRepository.save(professor);
    }
    @GetMapping(value = "/listaprofessores")
    public List<Professor> listarProfessores(){
        return this.professorRepository.findAll();
    }

    @GetMapping("/buscaprofessor/{id}")
    public Optional<Professor> buscarProfessor(@PathVariable("id") Long id){
        return this.professorRepository.findById(id);
    }

    @PutMapping("/atualizaprofessor/{id}")
    public Professor atualizarProfessor(@PathVariable("id") Long id, @RequestBody Professor professor){
    Optional<Professor> optionalProfessor = this.professorRepository.findById(id);

    if(optionalProfessor.isPresent()){
        Professor professorExistente = optionalProfessor.get();
        professorExistente.setNome(professor.getNome());
        professorExistente.setCpf(professor.getCpf());
        professorExistente.setRg(professor.getRg());
        professorExistente.setEndereco(professor.getEndereco());
        professorExistente.setCelular(professor.getCelular());

        return this.professorRepository.save(professorExistente);
    } else {
        return null;
    }
}
    @DeleteMapping("/deletaprofessor/{id}")
    public void deletarProfessor(@PathVariable("id") Long id){
        this.professorRepository.deleteById(id);
    }
}
