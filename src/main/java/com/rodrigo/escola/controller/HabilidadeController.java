package com.rodrigo.escola.controller;

import com.rodrigo.escola.document.Aluno;
import com.rodrigo.escola.document.Habilidade;
import com.rodrigo.escola.repository.AlunoRepository;
import com.rodrigo.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/habilidade")
public class HabilidadeController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/cadastrar/{id}")
    public String cadastrar(@PathVariable("id") String id, Model model) {
        model.addAttribute("aluno", alunoService.listarPorId(id));
        model.addAttribute("habilidade", new Habilidade());
        return "habilidade/cadastrar";
    }

    @PostMapping("/salvar/{id}")
    public String salvar(@PathVariable String id, @ModelAttribute Habilidade habilidade) {
        Aluno aluno = alunoService.listarPorId(id);
        aluno.adicionaHabilidade(aluno, habilidade);
        alunoService.salvar(aluno);
        return "redirect:/aluno/listar";
    }




}
