package br.com.hemn.backend.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;

/**
 * Representa um cliente do sistema, contendo informações pessoais,
 * dados de contato e referência a um endereço cadastrado.
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador único do cliente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cli")
	private Long id_cli;

	/**
	 * Nome completo do cliente.
	 */
	@Column(name = "nome_cli", nullable = false, length = 80)
	private String nomeCli;

	/**
	 * CPF do cliente (formato numérico sem pontuação).
	 */
	@Column(name = "cpf_cli", nullable = false, unique = true, length = 11)
	private String cpf_cli;

	/**
	 * Telefone de contato do cliente.
	 */
	@Column(name = "telefone_cli", nullable = false, length = 12)
	private String telefone_cli;

	/**
	 * Endereço de e-mail do cliente.
	 */
	@Column(name = "email_cli", nullable = false, unique = true, length = 60)
	private String email_cli;

	/**
	 * Endereço associado ao cliente.
	 * Relacionamento: muitos clientes para um endereço (ManyToOne).
	 */
	@ManyToOne
	@JoinColumn(name = "id_end", nullable = false)
	private Endereco id_end;

	/**
	 * Obtém o identificador do cliente.
	 *
	 * @return id do cliente
	 */
	public Long getId_cli() {
		return id_cli;
	}

	/**
	 * Obtém o nome do cliente.
	 *
	 * @return nome do cliente
	 */
	public String getNome_cli() {
		return nomeCli;
	}

	/**
	 * Define o nome do cliente.
	 *
	 * @param nome_cli nome completo
	 */
	public void setNome_cli(String nome_cli) {
		this.nomeCli = nome_cli;
	}

	/**
	 * Obtém o CPF do cliente.
	 *
	 * @return CPF
	 */
	public String getCpf_cli() {
		return cpf_cli;
	}

	/**
	 * Define o CPF do cliente.
	 *
	 * @param cpf_cli CPF
	 */
	public void setCpf_cli(String cpf_cli) {
		this.cpf_cli = cpf_cli;
	}

	/**
	 * Obtém o telefone do cliente.
	 *
	 * @return telefone
	 */
	public String getTelefone_cli() {
		return telefone_cli;
	}

	/**
	 * Define o telefone do cliente.
	 *
	 * @param telefone_cli telefone
	 */
	public void setTelefone_cli(String telefone_cli) {
		this.telefone_cli = telefone_cli;
	}

	/**
	 * Obtém o e-mail do cliente.
	 *
	 * @return e-mail
	 */
	public String getEmail_cli() {
		return email_cli;
	}

	/**
	 * Define o e-mail do cliente.
	 *
	 * @param email_cli e-mail
	 */
	public void setEmail_cli(String email_cli) {
		this.email_cli = email_cli;
	}

	/**
	 * Obtém o endereço associado ao cliente.
	 *
	 * @return endereço
	 */
	public Endereco getId_end() {
		return id_end;
	}

	/**
	 * Define o endereço associado ao cliente.
	 *
	 * @param id_end endereço
	 */
	public void setId_end(Endereco id_end) {
		this.id_end = id_end;
	}

	@Override
	public String toString() {
		return "Cliente [id_cli=" + id_cli + ", nome_cli=" + nomeCli + ", cpf_cli=" + cpf_cli +
				", telefone_cli=" + telefone_cli + ", email_cli=" + email_cli + ", id_end=" + id_end + "]";
	}
}
