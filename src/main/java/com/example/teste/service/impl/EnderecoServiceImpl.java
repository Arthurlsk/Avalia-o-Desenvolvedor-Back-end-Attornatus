package com.example.teste.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste.entity.Endereco;
import com.example.teste.repository.EnderecoRepository;
import com.example.teste.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{
    @Autowired
    private EnderecoRepository repositorio;

    @Override
    public List<Endereco> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Endereco save(Endereco endereco) {
        return repositorio.save(endereco);
    }

    @Override
    public Endereco findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Endereco();
    }

}
