package com.atividade2.ac1.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Professor {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String cpf;
        private String rg;
        private String endereco;
        private String celular;

        @ManyToMany
        @JoinTable(
            name = "especializacao",
            joinColumns = @JoinColumn(name="professor_id"),
            inverseJoinColumns = @JoinColumn(name="curso_id")
        )
        private List<Curso> cursos;

        @OneToMany(mappedBy = "professor")
        private List<Agenda> agendas;

    
        public Professor() {
        }

        public Professor(Long id, String nome, String cpf, String rg, String endereco, String celular) {
            this.id = id;
            this.nome = nome;
            this.cpf = cpf;
            this.rg = rg;
            this.endereco = endereco;
            this.celular = celular;
        }
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public String getCpf() {
            return cpf;
        }
    
        public void setCpf(String cpf) {
            this.cpf = cpf;
        }
    
        public String getRg() {
            return rg;
        }
    
        public void setRg(String rg) {
            this.rg = rg;
        }
    
        public String getEndereco() {
            return endereco;
        }
    
        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
    
        public String getCelular() {
            return celular;
        }
    
        public void setCelular(String celular) {
            this.celular = celular;
        }
    
    
}
