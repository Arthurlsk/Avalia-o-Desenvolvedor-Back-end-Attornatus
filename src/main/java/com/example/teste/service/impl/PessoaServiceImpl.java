package com.example.teste.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste.entity.Pessoa;
import com.example.teste.repository.PessoaRepository;
import com.example.teste.service.PessoaService;

@Service
public class PessoaServiceImpl 
implements PessoaService{
    @Autowired
    private PessoaRepository repositorio;

    @Override
    public List<Pessoa> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return repositorio.save(pessoa);
    }

    @Override
    public Pessoa findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Pessoa();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Pessoa> findByNome(String nome) {
        return repositorio.findByNomeIgnoreCaseContaining(nome);
    }
    
}
