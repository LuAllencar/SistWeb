package br.com.projetoescola.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projetoescola.escola.entity.Curso;
import br.com.projetoescola.escola.service.CursoService;


@Controller
@RequestMapping("/cursos")
public class CursoController {
    
        // Injeção de dependência da service de cursos
        @Autowired
        private CursoService cursoService;
        
        // Método para salvar um curso
        @PostMapping("/salvar")
        public String salvar(@ModelAttribute Curso curso) {
            cursoService.save(curso);
            return "redirect:/cursos/listar";
        }
    
        // Método para listar todos os cursos
        @GetMapping("/listar")
        public String listar(Model model) {
            List<Curso> cursos = cursoService.findAll();
            model.addAttribute("cursos", cursos);
            return "curso/listarCurso";
        }
    
        // Método para abrir o formulário do curso
        @GetMapping("/criar")
        public String criarForm(Model model) {
            model.addAttribute("curso", new Curso());
            return "curso/formularioAluno";
        }

}
