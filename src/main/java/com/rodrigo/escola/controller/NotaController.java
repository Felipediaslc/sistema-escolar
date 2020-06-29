package com.rodrigo.escola.controller;

import com.rodrigo.escola.document.Aluno;
import com.rodrigo.escola.document.Nota;
import com.rodrigo.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/cadastrar/{id}")
    public String cadastrar(@PathVariable("id") String id, Model model) {
        model.addAttribute("aluno", alunoService.listarPorId(id));
        model.addAttribute("nota", new Nota());
        return "nota/cadastrar";
    }

    @PostMapping("/salvar/{id}")
    public String salvar(@PathVariable("id") String id, @ModelAttribute Nota nota) {
        Aluno aluno = alunoService.listarPorId(id);
        aluno.adicionaNota(aluno, nota);
        alunoService.salvar(aluno);
        return "redirect:/aluno/listar";
    }
}
