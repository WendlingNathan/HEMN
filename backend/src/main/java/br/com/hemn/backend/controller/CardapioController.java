package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.hemn.backend.model.Cliente;
import br.com.hemn.backend.model.Produto;
import br.com.hemn.backend.repository.ProdutoRepository;

/**
 * Controlador responsável por gerenciar a operação relacionada à exibição do cardápio no frontend {@link Cliente}.
 * <p>
 * Disponibiliza um endpoint para listagem e consulta dos produtos registrados no sistema, mostrando-os no frontend.
 * </p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Controller
public class CardapioController {

	/** Repositório da entidade Produto. */
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Faz uma checagem e gera uma lista com todos os produtos cadastrados.
     *
     * @return Aciona a página do cardápio, listando todos os {@link Produtos} presentes no banco de dados.
     */
    @GetMapping("/cardapio")
    public String mostrarCardapio(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "cardapio";
    }
}
