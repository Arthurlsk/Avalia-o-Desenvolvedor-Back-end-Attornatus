package com.example.teste.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Campo nome não pode ser em branco")
    private String nome;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Endereco cidadeResidencia;
    
    
   
    public void setId(long id) {
        this.id = id;
    }
    public Endereco getCidadeResidencia() {
        return cidadeResidencia;
    }
    public void setCidadeResidencia(Endereco cidadeResidencia) {
        this.cidadeResidencia = cidadeResidencia;
    }
   
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public long getId() {
        return id;
    }
    
}
