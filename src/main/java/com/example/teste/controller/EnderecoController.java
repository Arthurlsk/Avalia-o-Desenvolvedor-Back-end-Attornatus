
package com.example.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.teste.entity.Endereco;
import com.example.teste.service.EnderecoService;

@Controller
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ModelAndView index(){

        var listaEnderecos = service.getAll();

        return new ModelAndView("endereco/index","listaEnderecos",listaEnderecos);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var novoEndereco = new Endereco();
        return new ModelAndView("endereco/form","endereco",novoEndereco);
    }
    @PostMapping(params = "form")
    public ModelAndView save(Endereco endereco){

        service.save(endereco);
        
        return new ModelAndView("redirect:/enderecos");
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        
        var umEndereco = service.findById(id);
        return new ModelAndView("endereco/form",
                                "endereco", umEndereco);
    }
}
