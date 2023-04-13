package com.atividade2.ac1.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Curso {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String descricao;
        private int cargaHoraria;
        private String objetivos;
        private String ementa;

        @ManyToMany (mappedBy = "cursos")
        private List<Professor> professores;

        @ManyToMany (mappedBy = "curso")
        private List<Agenda> agendas;
    
        
        public Curso() {
        }


        public Curso(Long id, String descricao, int cargaHoraria, String objetivos, String ementa) {
            this.id = id;
            this.descricao = descricao;
            this.cargaHoraria = cargaHoraria;
            this.objetivos = objetivos;
            this.ementa = ementa;
        }
    
        
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getDescricao() {
            return descricao;
        }
    
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    
        public int getCargaHoraria() {
            return cargaHoraria;
        }
    
        public void setCargaHoraria(int cargaHoraria) {
            this.cargaHoraria = cargaHoraria;
        }
    
        public String getObjetivos() {
            return objetivos;
        }
    
        public void setObjetivos(String objetivos) {
            this.objetivos = objetivos;
        }
    
        public String getEmenta() {
            return ementa;
        }
    
        public void setEmenta(String ementa) {
            this.ementa = ementa;
        }


        public List<Professor> getProfessores() {
            return professores;
        }


        public void setProfessores(List<Professor> professores) {
            this.professores = professores;
        }


        public List<Agenda> getAgendas() {
            return agendas;
        }


        public void setAgendas(List<Agenda> agendas) {
            this.agendas = agendas;
        }
    
    
}
