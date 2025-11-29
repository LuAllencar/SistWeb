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

import br.com.projetoescola.escola.entity.Cidade;
import br.com.projetoescola.escola.service.CidadeService;


@Controller
@RequestMapping("/cidades")
public class CidadeController {

    // Injeção de dependência da service de cursos
    @Autowired
    private CidadeService cidadeService;
    
    // Método para salvar um curso
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cidade cidade) {
        cidadeService.save(cidade);
        return "redirect:/cidades/listar";
    }

    // Método para listar todos os cursos
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Cidade> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);
        return "cidade/listarCidade";
    }

    // Método para abrir o formulário do curso
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("cidade", new Cidade());
        return "cidade/formularioCidade";
    }

     //Método para excluir um curso
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        cidadeService.deleteById(id);
        return "redirect:/cidades/listar";
}

    //Método para abrir o formulário da edição de cursos
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") Long id, Model model) {
        Cidade cidade = cidadeService.findById(id);
        model.addAttribute("cidade", cidade);
        return "cidade/formularioCidade";
}
    
}
