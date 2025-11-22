package br.com.hemn.backend.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

/**
 * Representa um produto cadastrado no sistema.
 * 
 * <p>Armazena informações como nome, descrição, preço e tipo,
 * além de sua composição por ingredientes.<p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único do produto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prod")
    private Long id_prod;

    /**
     * Nome do produto.
     */
    @Column(name = "nome_prod", nullable = false, length = 40)
    private String nomeProd;

    /**
     * Descrição do produto.
     */
    @Column(name = "descricao_prod", nullable = false, length = 100)
    private String descricao_prod;

    /**
     * Preço unitário do produto.
     */
    @Column(name = "preco_prod", nullable = false)
    private double preco_prod;

    /**
     * Tipo do produto.
     * Exemplo: "B" (bebida), "L" (lanche), "S" (sobremesa).
     */
    @Column(name = "tipo_prod", nullable = false, length = 1)
    private String tipo_prod;

    /**
     * Lista de ingredientes que compõem o produto.
     */
    @OneToMany(mappedBy = "id_prod")
    private List<ComposicaoProduto> composicao_produto;

    /**
     * Retorna o identificador do produto.
     */
    public Long getId_prod() {
        return id_prod;
    }

    /**
     * Retorna o nome do produto.
     */
    public String getNome_prod() {
        return nomeProd;
    }

    /**
     * Define o nome do produto.
     */
    public void setNome_prod(String nome_prod) {
        this.nomeProd = nome_prod;
    }

    /**
     * Retorna a descrição do produto.
     */
    public String getDescricao_prod() {
        return descricao_prod;
    }

    /**
     * Define a descrição do produto.
     */
    public void setDescricao_prod(String descricao_prod) {
        this.descricao_prod = descricao_prod;
    }

    /**
     * Retorna o preço do produto.
     */
    public double getPreco_prod() {
        return preco_prod;
    }

    /**
     * Define o preço do produto.
     */
    public void setPreco_prod(double preco_prod) {
        this.preco_prod = preco_prod;
    }

    /**
     * Retorna o tipo do produto.
     */
    public String getTipo_prod() {
        return tipo_prod;
    }

    /**
     * Define o tipo do produto.
     */
    public void setTipo_prod(String tipo_prod) {
        this.tipo_prod = tipo_prod;
    }

    /**
     * Retorna a lista de composições do produto.
     */
    public List<ComposicaoProduto> getComposicao_produto() {
        return composicao_produto;
    }

    /**
     * Define a lista de composições do produto.
     */
    public void setComposicao_produto(List<ComposicaoProduto> composicao_produto) {
        this.composicao_produto = composicao_produto;
    }

    @Override
    public String toString() {
        return "Produto [id_prod=" + id_prod + ", nome_prod=" + nomeProd 
                + ", descricao_prod=" + descricao_prod + ", preco_prod=" 
                + preco_prod + ", tipo_prod=" + tipo_prod + "]";
    }
}
