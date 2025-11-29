package br.com.projetoescola.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projetoescola.escola.dto.AlunoCurso;
import br.com.projetoescola.escola.dto.AlunoTelefone;
import br.com.projetoescola.escola.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    @Query("SELECT new br.com.projetoescola.escola.dto.AlunoTelefone(p.nomePessoa, a.telefoneAluno) FROM Aluno a, Pessoa p where p.idPessoa = a.idPessoa") List<AlunoTelefone> buscarNomeTelefone();

    @Query("SELECT new br.com.projetoescola.escola.dto.AlunoCurso(p.nomePessoa, a.curso.nomeCurso) FROM Aluno a, Pessoa p where p.idPessoa = a.idPessoa") List<AlunoCurso> buscarNomeCurso();
    
}
    