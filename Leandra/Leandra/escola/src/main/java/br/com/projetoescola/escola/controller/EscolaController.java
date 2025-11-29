package br.com.projetoescola.escola.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/escola")
public class EscolaController {

    @GetMapping
    public String index(Model model) {
        return "index";
    }
}