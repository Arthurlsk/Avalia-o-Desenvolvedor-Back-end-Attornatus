package com.example.teste.service;

import java.util.List;

import com.example.teste.entity.Endereco;

public interface EnderecoService {
    List<Endereco> getAll();
    Endereco save(Endereco endereco);
    Endereco findById(long id);
}
