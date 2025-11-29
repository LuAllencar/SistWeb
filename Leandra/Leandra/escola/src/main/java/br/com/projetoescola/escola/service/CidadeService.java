package br.com.projetoescola.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoescola.escola.entity.Cidade;
import br.com.projetoescola.escola.repository.CidadeRepository;

@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;

    // Método para salvar uma cidade
    public Cidade save(Cidade cidade){
        return cidadeRepository.save(cidade);
    }

    // Método para listar todas as cidades
    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }

    // Método para excluir cidade pelo ID
    // MUDANÇA: Integer -> Long
    public void deleteById(Long id){
        cidadeRepository.deleteById(id);
    }

    // Método para buscar cidade pelo ID
    // MUDANÇA: Integer -> Long
    public Cidade findById(Long id){
        return cidadeRepository.findById(id).orElse(null);
    }

    /**
     * Método que busca a cidade no banco.
     * Se não existir, cria e salva automaticamente.
     * Isso é útil porque o IBGE retorna IDs únicos para cada cidade.
     */
    public Cidade buscarOuSalvarCidade(Long idCidade, String nomeCidade) {
        return cidadeRepository.findById(idCidade).orElseGet(() -> {
            Cidade novaCidade = new Cidade();
            novaCidade.setIdCidade(idCidade);
            novaCidade.setNomeCidade(nomeCidade);
            return cidadeRepository.save(novaCidade);
        });
    }
}