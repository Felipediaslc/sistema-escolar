package com.rodrigo.escola.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Nota {

    private Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
