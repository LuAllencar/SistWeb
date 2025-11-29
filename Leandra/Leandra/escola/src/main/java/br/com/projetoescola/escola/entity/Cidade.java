package br.com.projetoescola.escola.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {
    
    // MUDANÇA IMPORTANTE: Integer -> Long
    // Os IDs do IBGE são números grandes (ex: 3550308 para São Paulo)
    @Id
    private Long idCidade;
    
    @Column(nullable = false, length = 40)
    private String nomeCidade;
}