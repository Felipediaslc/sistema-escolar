package com.rodrigo.escola.service;

import com.rodrigo.escola.document.Aluno;
import com.rodrigo.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void salvar(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Aluno buscarPorId(String id) {
        return alunoRepository.findById(id).get();
    }

    public List<Aluno> buscaPorNome(String nome) {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        return alunoRepository.findByNomeContainingIgnoreCase(nome, sort);
    }

    public List<Aluno> pesquisarPor(String classificacao, double nota) {
        List<Aluno> alunos = new ArrayList<>();
        if (classificacao.equals("reprovados")) {
            alunos = alunoRepository.findByNotasValorLessThan(nota);
        } else if (classificacao.equals("aprovados")) {
            alunos = alunoRepository.findByNotasValorGreaterThanEqual(nota);
        }
        return alunos;
    }
}
