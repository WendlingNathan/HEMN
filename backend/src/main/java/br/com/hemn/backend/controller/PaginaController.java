package br.com.hemn.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaginaController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String fazerLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {

        if (username.equals("admin")
                && password.equals("123")) {

            return "redirect:/pedido";
        }

        model.addAttribute(
                "erro",
                "Usuário ou senha inválidos."
        );

        return "login";
    }

    @GetMapping("/pedido")
    public String pedido() {
        return "pedido";
    }
}