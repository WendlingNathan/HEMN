package br.com.hemn.backend.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ing")
	private Long idIng;

	@Column(name = "nome_ing", nullable = false, unique = true, length = 60)
	private String nomeIng;

	@Column(name = "unidade_medida_ing", nullable = false, length = 2)
	private String unidade_medida_ing;

	public Long getId_ing() {
		return idIng;
	}

	public String getNome_ing() {
		return nomeIng;
	}

	public void setNome_ing(String nome_ing) {
		this.nomeIng = nome_ing;
	}

	public String getUnidade_medida_ing() {
		return unidade_medida_ing;
	}

	public void setUnidade_medida_ing(String unidade_medida_ing) {
		this.unidade_medida_ing = unidade_medida_ing;
	}

	@Override
	public String toString() {
		return "Ingrediente [id_ing=" + idIng + ", nome_ing=" + nomeIng + ", unidade_medida_ing=" + unidade_medida_ing
				+ "]";
	}
}
