package com.rodrigo.escola.repository;

import com.rodrigo.escola.document.Aluno;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
