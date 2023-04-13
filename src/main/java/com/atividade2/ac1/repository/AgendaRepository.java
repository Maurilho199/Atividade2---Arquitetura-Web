package com.atividade2.ac1.repository;

import java.util.Date;
import java.util.List;

import com.atividade2.ac1.model.Agenda;
import com.atividade2.ac1.model.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository <Agenda, Long>{

    List<Agenda> findByProfessorAndDataInicioBetween(Professor professor, Date dataInicio, Date dataFim);

    List<Agenda> findByProfessor(Professor professor);
    
}
