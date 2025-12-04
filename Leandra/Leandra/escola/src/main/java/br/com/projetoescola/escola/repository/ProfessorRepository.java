package br.com.projetoescola.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoescola.escola.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    
}
