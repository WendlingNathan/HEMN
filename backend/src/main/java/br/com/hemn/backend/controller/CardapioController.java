package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.hemn.backend.model.Produto;
import br.com.hemn.backend.service.ProdutoService;

/**
 * Controlador responsável por gerenciar a exibição do cardápio no frontend.
 *
 * <p>
 * Disponibiliza um endpoint para listagem dos produtos registrados no sistema,
 * repassando-os à camada de visualização.
 * </p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Controller
public class CardapioController {

    /** Serviço responsável pelas operações relacionadas a {@link Produto}. */
    @Autowired
    private ProdutoService produtoService;

    /**
     * Obtém todos os produtos cadastrados e envia a lista ao modelo para exibição
     * na página de cardápio.
     *
     * @param model modelo utilizado para repassar atributos à view
     * @return nome da página de cardápio a ser renderizada
     */
    @GetMapping("/cardapio")
    public String mostrarCardapio(Model model) {
        List<Produto> produtos = produtoService.listarTodos();
        model.addAttribute("produtos", produtos);
        return "cardapio";
    }
}
