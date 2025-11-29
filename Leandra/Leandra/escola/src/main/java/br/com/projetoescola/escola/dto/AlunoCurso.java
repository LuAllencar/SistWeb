package br.com.projetoescola.escola.dto;

public class AlunoCurso {
    
    private String nomePessoa;
    private String nomeCurso;

    public AlunoCurso() {
    }

    public AlunoCurso(String nomePessoa, String nomeCurso) {
        this.nomePessoa = nomePessoa;
        this.nomeCurso = nomeCurso;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }
    }
