package br.com.projetoescola.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projetoescola.escola.entity.Usuario;
import br.com.projetoescola.escola.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    // ABRE O FORMULÁRIO PARA CRIAR
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/formularioUsuario";
    }

    // SALVA O USUÁRIO NO BANCO
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "/login";
    }
}
