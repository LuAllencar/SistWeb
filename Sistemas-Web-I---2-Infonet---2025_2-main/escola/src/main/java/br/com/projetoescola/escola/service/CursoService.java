package br.com.projetoescola.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoescola.escola.entity.Curso;
import br.com.projetoescola.escola.repository.CursoRepository;

public class CursoService {

    // Injeção de dependência do repositório de cursos
    @Autowired
    private CursoRepository cursoRepository;

    //Método para salvar um curso
    public Curso save(Curso curso){
        return cursoRepository.save(curso);
    }

    //Método para listar todos os cursos
    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    
    
}
