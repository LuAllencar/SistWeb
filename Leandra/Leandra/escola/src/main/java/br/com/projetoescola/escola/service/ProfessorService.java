package br.com.projetoescola.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoescola.escola.entity.Professor;
import br.com.projetoescola.escola.repository.ProfessorRepository;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;

    // Método para salvar um professor
    public Professor save(Professor professor){
        return professorRepository.save(professor);
    }

    // Método para listar todos os professores
    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    //Método para excluir professor pelo ID
    public void deleteById(Integer id){
        professorRepository.deleteById(id);
    }

    //Método para buscar um professor pelo ID
    public Professor findById (Integer id){
        return professorRepository.findById(id).orElse(null);
    }

}
