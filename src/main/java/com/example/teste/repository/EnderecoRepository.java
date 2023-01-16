package com.example.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste.entity.Endereco;


@Repository
public interface EnderecoRepository 
extends JpaRepository<Endereco,Long>{
    
}
