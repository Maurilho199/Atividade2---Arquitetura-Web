package com.atividade2.ac1.repository;

import com.atividade2.ac1.model.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository <Professor, Long> {
    
}
