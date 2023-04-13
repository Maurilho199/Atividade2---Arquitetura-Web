package com.atividade2.ac1.repository;

import com.atividade2.ac1.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository <Curso, Long> {
    
}
