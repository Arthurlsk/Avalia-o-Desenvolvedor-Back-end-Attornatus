package com.example.teste.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.teste.entity.Pessoa;
import com.example.teste.service.EnderecoService;
import com.example.teste.service.PessoaService;



@Controller
@RequestMapping("/pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaService service;
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ModelAndView index(){
        var listaPessoas = service.getAll();
        return new ModelAndView("pessoa/index","listaPessoas",listaPessoas);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var pessoa = new Pessoa();
        var listaEnderecos = enderecoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pessoa",pessoa);
        dados.put("listaEnderecos",listaEnderecos);
        return new ModelAndView("pessoa/form", dados);
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umaPessoa = service.findById(id);
        var listaEnderecos = enderecoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pessoa",umaPessoa);
        dados.put("listaEnderecos",listaEnderecos);
        return new ModelAndView("pessoa/form",dados);
    }
    @PostMapping(params = "form")
    public ModelAndView save(@Valid Pessoa pessoa,
                            BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            var listaEnderecos = enderecoService.getAll();
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("pessoa",pessoa);
            dados.put("listaEnderecos",listaEnderecos);
            return new ModelAndView("pessoa/form",dados);
        }
        service.save(pessoa);

        return new ModelAndView("redirect:/pessoas");
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){

        service.delete(id);

        return new ModelAndView("redirect:/pessoas");
    }


}

