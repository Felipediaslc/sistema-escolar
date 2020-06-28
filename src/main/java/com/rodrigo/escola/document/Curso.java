package com.rodrigo.escola.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Curso {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
