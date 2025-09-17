package com.vitorprojects.projetocrud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    @GetMapping("/pagina") // Define que este método responde a requisições GET para /pagina
    public String mostrarPagina(@RequestParam(name = "nome", required = false, defaultValue = "Mundo") String nome, Model model) {
        // Adiciona o nome ao modelo, que pode ser acessado na página HTML
        model.addAttribute("mensagem", "Olá, " + nome + "!");
        return "pagina-exemplo"; // Indica qual template HTML deve ser retornado
    }
}
//private final UserService usuarioService;

