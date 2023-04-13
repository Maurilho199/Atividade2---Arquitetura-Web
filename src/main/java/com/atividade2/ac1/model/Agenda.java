package com.atividade2.ac1.model;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Agenda {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Date dataInicio;
        private Date dataFim;
        private String horarioInicio;
        private String horarioFim;
        private String cidade;
        private String uf;
        private String cep;
        private String resumo;

        @ManyToOne
        @JoinColumn(name = "curso_id")
        private Curso curso;

        @ManyToOne
        @JoinColumn(name = "professor_id")
        private Professor professor;
    
        public Agenda(Date dataInicio, Date dataFim, String horarioInicio, String horarioFim,
                      Professor professor, String cidade, String uf, String cep, Curso curso, String resumo) {
            this.dataInicio = dataInicio;
            this.dataFim = dataFim;
            this.horarioInicio = horarioInicio;
            this.horarioFim = horarioFim;
            this.professor = professor;
            this.cidade = cidade;
            this.uf = uf;
            this.cep = cep;
            this.curso = curso;
            this.resumo = resumo;
        }
    
        public Date getDataInicio() {
            return dataInicio;
        }
    
        public void setDataInicio(Date dataInicio) {
            this.dataInicio = dataInicio;
        }
    
        public Date getDataFim() {
            return dataFim;
        }
    
        public void setDataFim(Date dataFim) {
            this.dataFim = dataFim;
        }
    
        public String getHorarioInicio() {
            return horarioInicio;
        }
    
        public void setHorarioInicio(String horarioInicio) {
            this.horarioInicio = horarioInicio;
        }
    
        public String getHorarioFim() {
            return horarioFim;
        }
    
        public void setHorarioFim(String horarioFim) {
            this.horarioFim = horarioFim;
        }
    
        public Professor getProfessor() {
            return professor;
        }
    
        public void setProfessor(Professor professor) {
            this.professor = professor;
        }
    
        public String getCidade() {
            return cidade;
        }
    
        public void setCidade(String cidade) {
            this.cidade = cidade;
        }
    
        public String getUf() {
            return uf;
        }
    
        public void setUf(String uf) {
            this.uf = uf;
        }
    
        public String getCep() {
            return cep;
        }
    
        public void setCep(String cep) {
            this.cep = cep;
        }
    
        public Curso getCurso() {
            return curso;
        }
    
        public void setCurso(Curso curso) {
            this.curso = curso;
        }
    
        public String getResumo() {
            return resumo;
        }
    
        public void setResumo(String resumo) {
            this.resumo = resumo;
        }
    
    
}
