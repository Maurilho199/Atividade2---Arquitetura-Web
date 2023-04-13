package com.atividade2.ac1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.atividade2.ac1.model.Agenda;
import com.atividade2.ac1.model.Professor;
import com.atividade2.ac1.repository.AgendaRepository;
import com.atividade2.ac1.repository.CursoRepository;
import com.atividade2.ac1.repository.ProfessorRepository;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping("/criar-agenda")
    public Agenda criarAgenda(@RequestBody Agenda agenda) {
    return agendaRepository.save(agenda);
}

    @GetMapping("/listar/{professorId}")
    public List<Agenda> listarAgendasPorProfessor(@PathVariable("professorId") Long professorId) {
        
        Optional<Professor> professorOptional = professorRepository.findById(professorId);

        if (professorOptional.isPresent()) {
            Professor professor = professorOptional.get();
            List<Agenda> agendas = agendaRepository.findByProfessor(professor);
            return agendas;
        } else {
            throw new RuntimeException("Professor não encontrado.");
        }
    }

    @PostMapping("/cadastrar-resumo/{agendaId}")
    public Agenda cadastrarResumoTreinamento(@PathVariable("agendaId") Long agendaId, @RequestBody String resumo) {
        // Busca a agenda
        Optional<Agenda> agendaOptional = agendaRepository.findById(agendaId);

        if (agendaOptional.isPresent()) {
            Agenda agenda = agendaOptional.get();
            
            return agendaRepository.save(agenda);
        } else {
            throw new RuntimeException("Agenda não encontrada.");
        }
    }
}
