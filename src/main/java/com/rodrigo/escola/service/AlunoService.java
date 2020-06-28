package com.rodrigo.escola.service;

import com.rodrigo.escola.document.Aluno;
import com.rodrigo.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void salvar(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public Aluno listarPorId(String id) {
        return alunoRepository.findById(id).get();
    }
}
