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
    
    // ID do IBGE (ex: 3550308 para São Paulo)
    @Id
    private Long idCidade;
    
    @Column(nullable = false, length = 100)
    private String nomeCidade;
    
    // Informações do Estado
    @Column
    private Long estadoId;
    
    @Column(length = 100)
    private String estadoNome;
    
    @Column(length = 2)
    private String estadoSigla;
}