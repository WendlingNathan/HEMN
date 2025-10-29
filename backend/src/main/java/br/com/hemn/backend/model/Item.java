package br.com.hemn.backend.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ite")
	private Long id_ite;

	@Column(name = "qtd_ite", nullable = false)
	private int qtd_ite;

	@Column(name = "preco_unitario_ite", nullable = false)
	private double preco_unitario_ite;

	@ManyToOne
	@JoinColumn(name = "id_prod", nullable = false)
	private Produto id_prod;

	@ManyToOne
	@JoinColumn(name = "id_ped", nullable = false)
	private Pedido id_ped;

	public Long getId_ite() {
		return id_ite;
	}

	public int getQtd_ite() {
		return qtd_ite;
	}

	public void setQtd_ite(int qtd_ite) {
		this.qtd_ite = qtd_ite;
	}

	public double getPreco_unitario_ite() {
		return preco_unitario_ite;
	}

	public void setPreco_unitario_ite(double preco_unitario_ite) {
		this.preco_unitario_ite = preco_unitario_ite;
	}

	public Produto getId_prod() {
		return id_prod;
	}

	public void setId_prod(Produto id_prod) {
		this.id_prod = id_prod;
	}

	public Pedido getId_ped() {
		return id_ped;
	}

	public void setId_ped(Pedido id_ped) {
		this.id_ped = id_ped;
	}

	@Override
	public String toString() {
		return "Item [id_ite=" + id_ite + ", qtd_ite=" + qtd_ite + ", preco_unitario_ite=" + preco_unitario_ite
				+ ", id_prod=" + id_prod + ", id_ped=" + id_ped + "]";
	}
}
