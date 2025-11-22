package br.com.hemn.backend.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa um ingrediente utilizado na composição de produtos,
 * contendo informações básicas como nome e unidade de medida.
 *
 * <p>Esta entidade auxilia no controle de estoque e no cálculo
 * de quantidades utilizadas em cada produto.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Entity
@Table(name = "ingrediente")
public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador único do ingrediente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ing")
	private Long idIng;

	/**
	 * Nome do ingrediente.
	 *
	 * <p>Deve ser único no sistema.</p>
	 */
	@Column(name = "nome_ing", nullable = false, unique = true, length = 60)
	private String nomeIng;

	/**
	 * Unidade de medida referente ao ingrediente.
	 *
	 * <p>Exemplos: "g", "kg", "ml".</p>
	 */
	@Column(name = "unidade_medida_ing", nullable = false, length = 2)
	private String unidade_medida_ing;

	/**
	 * Obtém o identificador do ingrediente.
	 *
	 * @return id_ing
	 */
	public Long getId_ing() {
		return idIng;
	}

	/**
	 * Obtém o nome do ingrediente.
	 *
	 * @return nome_ing
	 */
	public String getNome_ing() {
		return nomeIng;
	}

	/**
	 * Define o nome do ingrediente.
	 *
	 * @param nome_ing nome do ingrediente
	 */
	public void setNome_ing(String nome_ing) {
		this.nomeIng = nome_ing;
	}

	/**
	 * Obtém a unidade de medida do ingrediente.
	 *
	 * @return unidade_medida_ing
	 */
	public String getUnidade_medida_ing() {
		return unidade_medida_ing;
	}

	/**
	 * Define a unidade de medida do ingrediente.
	 *
	 * @param unidade_medida_ing unidade de medida
	 */
	public void setUnidade_medida_ing(String unidade_medida_ing) {
		this.unidade_medida_ing = unidade_medida_ing;
	}

	@Override
	public String toString() {
		return "Ingrediente [id_ing=" + idIng + ", nome_ing=" + nomeIng +
				", unidade_medida_ing=" + unidade_medida_ing + "]";
	}
}
