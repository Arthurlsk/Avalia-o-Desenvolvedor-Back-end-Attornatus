package com.example.teste.service;

import java.util.List;

import com.example.teste.entity.Pessoa;

public interface PessoaService {
    List<Pessoa> getAll();
    Pessoa save(Pessoa cliente);
    Pessoa findById(long id);
    void delete(long id);
    List<Pessoa> findByNome(String nome);
}
