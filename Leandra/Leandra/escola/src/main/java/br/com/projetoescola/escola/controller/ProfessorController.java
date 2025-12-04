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

import br.com.projetoescola.escola.entity.Cidade;
import br.com.projetoescola.escola.entity.Professor;
import br.com.projetoescola.escola.service.CidadeService;
import br.com.projetoescola.escola.service.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
    
    @Autowired
    private ProfessorService professorService;

    @Autowired
    private CidadeService cidadeService;
    
    // Método para salvar um professor
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Professor professor,
                         @RequestParam("cidade.idCidade") Long idCidade,
                         @RequestParam("cidade.nomeCidade") String nomeCidade) {
        
        // Busca ou cria a cidade
        Cidade cidade = cidadeService.buscarOuSalvarCidade(idCidade, nomeCidade);
        
        // Associa a cidade ao professor
        professor.setCidade(cidade);
        
        // Salva o professor
        professorService.save(professor);
        
        return "redirect:/professores/listar";
    }

    // Método para listar todos os professores
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Professor> professores = professorService.findAll();
        model.addAttribute("professores", professores);
        return "professor/listarProfessor";
    }

    // Método para abrir o formulário do professor (criar novo)
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/formularioProfessor";
    }
    
    // Método para excluir um professor
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id) {
        professorService.deleteById(id);
        return "redirect:/professores/listar";
    }

    // Método para abrir o formulário da edição de professores
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") Integer id, Model model) {
        Professor professor = professorService.findById(id);
        model.addAttribute("professor", professor);
        return "professor/formularioProfessor";
    }
}