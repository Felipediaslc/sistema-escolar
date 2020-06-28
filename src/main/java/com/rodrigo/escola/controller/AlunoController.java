package com.rodrigo.escola.controller;

import com.rodrigo.escola.document.Aluno;
import com.rodrigo.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        alunoRepository.save(aluno);
        return "redirect:/";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alunos", alunoRepository.findAll());
        return "aluno/listar";
    }

}
