package br.com.projetoescola.escola.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Professor extends Pessoa {

    @Column(nullable = false, length = 11)
    private String cpfProfessor;
    
    @Column(nullable = false, length = 11)
    private String telefoneProfessor;
    
    @Column(nullable = false)
    private LocalDate dataAdmissao;
    
    @Column(nullable = false, length = 100)
    private String formacao; // Ex: "Licenciatura em Matemática"
    
    @Column(nullable = false, length = 20)
    private String status; // "ATIVO" ou "INATIVO"
    
    @ManyToOne
    @JoinColumn(name = "idCidade_fk")
    private Cidade cidade;
    
}
