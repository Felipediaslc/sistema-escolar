package com.rodrigo.escola.repository;

import com.rodrigo.escola.document.Aluno;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {

    List<Aluno> findByNomeContainingIgnoreCase(String nome, Sort sort);
    List<Aluno> findByNotasValorLessThan(Double nota);
    List<Aluno> findByNotasValorGreaterThanEqual(Double nota);
}
