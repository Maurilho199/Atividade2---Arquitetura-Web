package com.atividade2.ac1.controller;

import java.util.List;
import java.util.Optional;

import com.atividade2.ac1.model.Curso;
import com.atividade2.ac1.repository.CursoRepository;

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
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping(value = "/criacurso")
    public Curso criaCurso(@RequestBody Curso curso){
        return this.cursoRepository.save(curso);
    }

    @GetMapping(value = "/listacursos")
    public List<Curso> listaCursos(){
        return this.cursoRepository.findAll();
    }

    @GetMapping(value = "/buscacurso/{id}")
    public Curso buscaCurso(@PathVariable("id") Long id){
        Optional<Curso> optionalCurso = this.cursoRepository.findById(id);

        if(optionalCurso.isPresent()){
            return optionalCurso.get();
        } else {
            return null;
        }
    }

    @PutMapping("/atualizacurso/{id}")
    public Curso atualizaCurso(@PathVariable("id") Long id, @RequestBody Curso curso){
    Optional<Curso> optionalCurso = this.cursoRepository.findById(id);

    if(optionalCurso.isPresent()){
        Curso cursoExistente = optionalCurso.get();
        cursoExistente.setDescricao(curso.getDescricao());
        cursoExistente.setCargaHoraria(curso.getCargaHoraria());
        cursoExistente.setObjetivos(curso.getObjetivos());
        cursoExistente.setEmenta(curso.getEmenta());

        return this.cursoRepository.save(cursoExistente);
    } else {
        return null;
    }
}


    @DeleteMapping("/deletacurso/{id}")
    public void deletaCurso(@PathVariable("id") Long id){
        this.cursoRepository.deleteById(id);
    }

}
