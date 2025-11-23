package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.hemn.backend.model.Produto;
import br.com.hemn.backend.repository.ProdutoRepository;

@Controller
public class CardapioController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/cardapio")
    public String mostrarCardapio(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "cardapio";
    }
}
