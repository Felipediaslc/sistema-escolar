package com.rodrigo.escola.controller;

import com.rodrigo.escola.document.Aluno;
import com.rodrigo.escola.repository.AlunoRepository;
import com.rodrigo.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.listar());
        return "aluno/listar";
    }

    @GetMapping("/visualizar/{id}")
    public String visualizar(@PathVariable("id") String id, Model model) {
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        return "aluno/visualizar";
    }

    @GetMapping("/pesquisarnome")
    public String pesquisarNome() {
        return "aluno/pesquisarnome";
    }

    @GetMapping("/pesquisar")
    public String pesquisar(@RequestParam("nome") String nome, Model model) {
        model.addAttribute("alunos", alunoService.buscaPorNome(nome));
        return "aluno/pesquisarnome";
    }

}
