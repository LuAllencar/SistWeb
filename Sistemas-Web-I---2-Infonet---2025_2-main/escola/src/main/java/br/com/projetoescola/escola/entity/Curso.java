package br.com.projetoescola.escola.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCurso;

    @Column(nullable = false, length = 30)
    private String nomeCurso;

    @Column(nullable = false, length = 10)
    private String siglaCurso;

    @Column(nullable = false)
    private Integer chCurso;

    @Column(nullable = false, length = 20)
    private String periodoCurso;

    //Métodos Construtores
    public Curso() {
    }

    public Curso(Integer idCurso, String nomeCurso, String siglaCurso, Integer chCurso, String periodoCurso) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.siglaCurso = siglaCurso;
        this.chCurso = chCurso;
        this.periodoCurso = periodoCurso;
    }

    //Métodos acessores(Set´s e Get´s)
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getSiglaCurso() {
        return siglaCurso;
    }

    public void setSiglaCurso(String siglaCurso) {
        this.siglaCurso = siglaCurso;
    }

    public Integer getChCurso() {
        return chCurso;
    }

    public void setChCurso(Integer chCurso) {
        this.chCurso = chCurso;
    }

    public String getPeriodoCurso() {
        return periodoCurso;
    }

    public void setPeriodoCurso(String periodoCurso) {
        this.periodoCurso = periodoCurso;
    }
}
