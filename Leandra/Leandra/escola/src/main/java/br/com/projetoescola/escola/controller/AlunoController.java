package br.com.projetoescola.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projetoescola.escola.dto.AlunoCurso;
import br.com.projetoescola.escola.dto.AlunoTelefone;
import br.com.projetoescola.escola.entity.Aluno;
import br.com.projetoescola.escola.entity.Cidade;
import br.com.projetoescola.escola.entity.Curso;
import br.com.projetoescola.escola.service.AlunoService;
import br.com.projetoescola.escola.service.CidadeService;
import br.com.projetoescola.escola.service.CursoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    
    // Injeção de dependência da service de alunos, cursos e cidades
    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CidadeService cidadeService;
    
    /**
     * MÉTODO CORRIGIDO - Agora recebe os dados da cidade do formulário
     * 
     * O @RequestParam pega os campos ocultos do HTML:
     * - cidade.idCidade (Long) - vem da API do IBGE
     * - cidade.nomeCidade (String) - vem da API do IBGE
     * 
     * O método buscarOuSalvarCidade verifica se a cidade já existe no banco.
     * Se não existir, cria uma nova. Isso evita duplicatas.
     */
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno,
                         @RequestParam("cidade.idCidade") Long idCidade,
                         @RequestParam("cidade.nomeCidade") String nomeCidade) {
        
        // Busca ou cria a cidade
        Cidade cidade = cidadeService.buscarOuSalvarCidade(idCidade, nomeCidade);
        
        // Associa a cidade ao aluno
        aluno.setCidade(cidade);
        
        // Salva o aluno
        alunoService.save(aluno);
        
        return "redirect:/alunos/listar";
    }

    // Método para listar todos os alunos
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Aluno> alunos = alunoService.findAll();
        model.addAttribute("alunos", alunos);
        return "aluno/listarAluno";
    }

    // Método para abrir o formulário do aluno (criar novo)
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        // Não precisa enviar lista de cidades porque agora vem do IBGE
        return "aluno/formularioAluno";
    }
    
    // Método para excluir um aluno
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id) {
        alunoService.deleteById(id);
        return "redirect:/alunos/listar";
    }

    // Método para abrir o formulário da edição de alunos
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") Integer id, Model model) {
        Aluno aluno = alunoService.findById(id);
        model.addAttribute("aluno", aluno);
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        // Não precisa enviar lista de cidades porque agora vem do IBGE
        return "aluno/formularioAluno";
    }

    // Método para listar nome e telefone dos alunos (DTO customizado)
    @GetMapping("/listar-nome-telefone")
    public String listarNomeTelefone(Model model) {
        List<AlunoTelefone> alunos = alunoService.buscarNomeTelefone();
        model.addAttribute("alunos", alunos);
        return "aluno/listaNomeTelefone";
    }

    // Método para listar aluno e curso (DTO customizado)
    @GetMapping("/listar-aluno-curso")
    public String listarAlunoCurso(Model model) {
        List<AlunoCurso> alunos = alunoService.buscarNomeCurso();
        model.addAttribute("alunos", alunos);
        return "aluno/listaAlunoCurso";
    }
}