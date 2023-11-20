package com.example.appgaseta.model;

public class Curso {

    private String nomeCursoDesejado;

    public Curso(String nomeCursoDesejado) {
        this.nomeCursoDesejado = nomeCursoDesejado;
    }


    public String getNomeCursoDesejado() {//direito > generate > getters and setters
        return nomeCursoDesejado;
    }

    public void setNomeCursoDesejado(String nomeCursoDesejado) {
        this.nomeCursoDesejado = nomeCursoDesejado;
    }
}
