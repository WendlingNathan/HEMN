package br.com.hemn.backend.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Representa um item pertencente a um pedido, contendo informações
 * como quantidade, preço unitário e referências ao produto e ao pedido.
 *
 * <p>Cada item corresponde a um produto específico dentro de um pedido,
 * permitindo o cálculo detalhado dos valores envolvidos na compra.</p>
 *
 * <p>A relação com Pedido é anotada com {@code @JsonIgnore} para evitar
 * problemas de recursão durante a serialização JSON.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador único do item.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ite")
	private Long id_ite;

	/**
	 * Quantidade do produto no pedido.
	 */
	@Column(name = "qtd_ite", nullable = false)
	private int qtd_ite;

	/**
	 * Preço unitário do item no momento do pedido.
	 */
	@Column(name = "preco_unitario_ite", nullable = false)
	private double preco_unitario_ite;

	/**
	 * Produto associado ao item.
	 * 
	 * <p>Ignorado na serialização JSON para evitar loops entre Pedido → Item → Pedido.</p>
	 */
	@ManyToOne
	@JoinColumn(name = "id_prod", nullable = false)
	@JsonIgnore
	private Produto id_prod;

	/**
	 * Pedido ao qual o item pertence.
	 *
	 * <p>Ignorado na serialização JSON para evitar loops entre Pedido → Item → Pedido.</p>
	 */
	@ManyToOne
	@JoinColumn(name = "id_ped", nullable = false)
	@JsonIgnore
	private Pedido id_ped;

	/**
	 * Obtém o identificador do item.
	 *
	 * @return id_ite
	 */
	public Long getId_ite() {
		return id_ite;
	}

	/**
	 * Obtém a quantidade do item.
	 *
	 * @return quantidade
	 */
	public int getQtd_ite() {
		return qtd_ite;
	}

	/**
	 * Define a quantidade do item.
	 *
	 * @param qtd_ite quantidade
	 */
	public void setQtd_ite(int qtd_ite) {
		this.qtd_ite = qtd_ite;
	}

	/**
	 * Obtém o preço unitário do item.
	 *
	 * @return preço unitário
	 */
	public double getPreco_unitario_ite() {
		return preco_unitario_ite;
	}

	/**
	 * Define o preço unitário do item.
	 *
	 * @param preco_unitario_ite preço unitário
	 */
	public void setPreco_unitario_ite(double preco_unitario_ite) {
		this.preco_unitario_ite = preco_unitario_ite;
	}

	/**
	 * Obtém o produto associado ao item.
	 *
	 * @return produto
	 */
	public Produto getId_prod() {
		return id_prod;
	}

	/**
	 * Define o produto associado ao item.
	 *
	 * @param id_prod produto
	 */
	public void setId_prod(Produto id_prod) {
		this.id_prod = id_prod;
	}

	/**
	 * Obtém o pedido ao qual o item pertence.
	 *
	 * @return pedido
	 */
	public Pedido getId_ped() {
		return id_ped;
	}

	/**
	 * Define o pedido ao qual o item pertence.
	 *
	 * @param id_ped pedido
	 */
	public void setId_ped(Pedido id_ped) {
		this.id_ped = id_ped;
	}

	@Override
	public String toString() {
		return "Item [id_ite=" + id_ite + ", qtd_ite=" + qtd_ite +
				", preco_unitario_ite=" + preco_unitario_ite +
				", id_prod=" + id_prod + ", id_ped=" + id_ped + "]";
	}
}
