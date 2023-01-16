package com.example.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste.entity.Pessoa;

@Repository
public interface PessoaRepository 
extends JpaRepository<Pessoa,Long> {

    List<Pessoa> findByNomeIgnoreCaseContaining(String nome);
    
    
}
