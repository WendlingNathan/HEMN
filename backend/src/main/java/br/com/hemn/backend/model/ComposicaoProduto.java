package br.com.hemn.backend.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

/**
 * Representa a composição de um produto, relacionando ingredientes
 * e quantidades necessárias para sua produção.
 *
 * <p>Esta entidade estabelece relações ManyToOne com Produto e Ingrediente,
 * definindo os componentes que formam cada item do catálogo.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Entity
@Table(name = "composicaoproduto")
public class ComposicaoProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador único da composição do produto.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comp")
	private Long id_comp;

	/**
	 * Quantidade do ingrediente utilizado no produto.
	 */
	@Column(name = "qtd_ing_comp", nullable = false)
	private double qtd_ing_comp;

	/**
	 * Produto ao qual esta composição pertence.
	 * Relacionamento: muitos registros de composição para um produto.
	 * 
	 * <p>Ignorado na serialização JSON para evitar loops entre Pedido → Item → Pedido.</p>
	 */
	@ManyToOne
	@JoinColumn(name = "id_prod", nullable = false)
	@JsonIgnore
	private Produto id_prod;

	/**
	 * Ingrediente associado à composição.
	 * Relacionamento: muitos registros de composição para um ingrediente.
	 * 
	 * <p>Ignorado na serialização JSON para evitar loops entre Pedido → Item → Pedido.</p>
	 */
	@ManyToOne
	@JoinColumn(name = "id_ing", nullable = false)
	@JsonIgnore
	private Ingrediente ingrediente;

	/**
	 * Obtém o identificador da composição.
	 *
	 * @return id da composição
	 */
	public Long getId_comp() {
		return id_comp;
	}

	/**
	 * Obtém a quantidade do ingrediente.
	 *
	 * @return quantidade utilizada
	 */
	public double getQtd_ing_comp() {
		return qtd_ing_comp;
	}

	/**
	 * Define a quantidade do ingrediente.
	 *
	 * @param qtd_ing_comp quantidade utilizada
	 */
	public void setQtd_ing_comp(double qtd_ing_comp) {
		this.qtd_ing_comp = qtd_ing_comp;
	}

	/**
	 * Obtém o produto associado.
	 *
	 * @return produto
	 */
	public Produto getId_prod() {
		return id_prod;
	}

	/**
	 * Define o produto associado.
	 *
	 * @param id_prod produto
	 */
	public void setId_prod(Produto id_prod) {
		this.id_prod = id_prod;
	}

	/**
	 * Obtém o ingrediente associado.
	 *
	 * @return ingrediente
	 */
	public Ingrediente getId_ing() {
		return ingrediente;
	}

	/**
	 * Define o ingrediente associado.
	 *
	 * @param ingrediente ingrediente
	 */
	public void setId_ing(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public String toString() {
		return "ComposicaoProduto [id_comp=" + id_comp + ", qtd_ing_comp=" + qtd_ing_comp +
				", id_prod=" + id_prod + ", id_ing=" + ingrediente + "]";
	}
}
