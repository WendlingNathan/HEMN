package br.com.hemn.backend.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa um endereço cadastrado no sistema, contendo informações
 * de localização como logradouro, número, cidade, bairro e referência.
 *
 * <p>Esta entidade é utilizada por outras tabelas que dependem de um
 * endereço associado, como Cliente e Funcionário.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identificador único do endereço.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_end")
	private Long id_end;
	
	/**
	 * Complemento do endereço (ex.: apartamento, bloco).
	 */
	@Column(name = "complemento_end", nullable = false, length = 20)
	private String complemento_end;
	
	/**
	 * Logradouro do endereço (ex.: rua, avenida).
	 */
	@Column(name = "logradouro_end", nullable = false, length = 20)
	private String logradouro_end;
	
	/**
	 * Número do endereço.
	 */
	@Column(name = "numero_end", nullable = false)
	private int numero_end;
	
	/**
	 * Cidade referente ao endereço.
	 */
	@Column(name = "cidade_end", nullable = false, length = 80)
	private String cidade_end;
	
	/**
	 * Bairro referente ao endereço.
	 */
	@Column(name = "bairro_end", nullable = false, length = 40)
	private String bairro_end;
	
	/**
	 * Ponto de referência do endereço (campo opcional).
	 */
	@Column(name = "pont_ref_end", length = 80)
	private String pont_ref_end;

	/**
	 * Obtém o complemento do endereço.
	 *
	 * @return complemento
	 */
	public String getCoplemento_end() {
		return complemento_end;
	}

	/**
	 * Define o complemento do endereço.
	 *
	 * @param coplemento_end complemento
	 */
	public void setCoplemento_end(String coplemento_end) {
		this.complemento_end = coplemento_end;
	}

	/**
	 * Obtém o logradouro do endereço.
	 *
	 * @return logradouro
	 */
	public String getLogradouro_end() {
		return logradouro_end;
	}

	/**
	 * Define o logradouro do endereço.
	 *
	 * @param logradouro_end logradouro
	 */
	public void setLogradouro_end(String logradouro_end) {
		this.logradouro_end = logradouro_end;
	}

	/**
	 * Obtém o número do endereço.
	 *
	 * @return número
	 */
	public int getNumero_end() {
		return numero_end;
	}

	/**
	 * Define o número do endereço.
	 *
	 * @param numero_end número
	 */
	public void setNumero_end(int numero_end) {
		this.numero_end = numero_end;
	}

	/**
	 * Obtém a cidade do endereço.
	 *
	 * @return cidade
	 */
	public String getCidade_end() {
		return cidade_end;
	}

	/**
	 * Define a cidade do endereço.
	 *
	 * @param cidade_end cidade
	 */
	public void setCidade_end(String cidade_end) {
		this.cidade_end = cidade_end;
	}

	/**
	 * Obtém o bairro do endereço.
	 *
	 * @return bairro
	 */
	public String getBairro_end() {
		return bairro_end;
	}

	/**
	 * Define o bairro do endereço.
	 *
	 * @param bairro_end bairro
	 */
	public void setBairro_end(String bairro_end) {
		this.bairro_end = bairro_end;
	}

	/**
	 * Obtém o ponto de referência.
	 *
	 * @return ponto de referência
	 */
	public String getPont_ref_end() {
		return pont_ref_end;
	}

	/**
	 * Define o ponto de referência.
	 *
	 * @param pont_ref_end ponto de referência
	 */
	public void setPont_ref_end(String pont_ref_end) {
		this.pont_ref_end = pont_ref_end;
	}

	/**
	 * Obtém o valor do serialVersionUID.
	 *
	 * @return serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Obtém o identificador do endereço.
	 *
	 * @return id_end
	 */
	public Long getId_end() {
		return id_end;
	}

	@Override
	public String toString() {
		return "Endereco [id_end=" + id_end + ", complemento_end=" + complemento_end + ", logradouro_end=" + logradouro_end +
				", numero_end=" + numero_end + ", cidade_end=" + cidade_end + ", bairro_end=" + bairro_end +
				", pont_ref_end=" + pont_ref_end + "]";
	}
}
