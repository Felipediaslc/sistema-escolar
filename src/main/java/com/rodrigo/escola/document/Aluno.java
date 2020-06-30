package com.rodrigo.escola.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class Aluno {

    @Id
    private String id;

    private String nome;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    private Curso curso;

    private List<Nota> notas;

    private List<Habilidade> habilidades;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public Aluno adicionaHabilidade(Aluno aluno, Habilidade habilidade) {
        List<Habilidade> habilidades = new ArrayList<>();
        if(aluno.getHabilidades() != null) {
            habilidades = aluno.getHabilidades();
        }
        habilidades.add(habilidade);
        aluno.setHabilidades(habilidades);
        return aluno;
    }

    public Aluno adicionaNota(Aluno aluno, Nota nota) {
        List<Nota> notas = new ArrayList<>();
        if(aluno.getNotas() != null) {
            notas = aluno.getNotas();
        }
        notas.add(nota);
        aluno.setNotas(notas);
        return aluno;
    }
}
