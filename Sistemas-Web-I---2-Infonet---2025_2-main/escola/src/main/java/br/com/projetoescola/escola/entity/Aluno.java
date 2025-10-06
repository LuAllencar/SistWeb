package br.com.projetoescola.escola.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno{

    //definição dos atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAluno;
    
    @Column(nullable = false, length = 40)
    private String nomeAluno;
    
    @Column(nullable = false, length = 11)
    private String telefoneAluno;
    
    @Column(nullable = false, length = 40)
    private String enderecoAluno;
    
    @Column(nullable = false)
    private Integer rmAluno;
    
    @Column(nullable = false, length = 11)
    private String cpfAluno;

    @ManyToOne
    @JoinColumn(name = "idCurso_fk")
    private Curso curso;

}