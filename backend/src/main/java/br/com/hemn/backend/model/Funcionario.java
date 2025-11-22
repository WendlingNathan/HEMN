package br.com.hemn.backend.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa um funcionário cadastrado no sistema, contendo informações
 * essenciais como nome, cargo e telefone.
 *
 * <p>Esta entidade permite o controle e identificação de funcionários
 * responsáveis por operações internas, podendo se relacionar com outras
 * entidades do sistema conforme necessário.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador único do funcionário.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fun")
	private Long id_fun;

	/**
	 * Nome completo do funcionário.
	 */
	@Column(name = "nome_fun", nullable = false, length = 80)
	private String nomeFun;

	/**
	 * Cargo do funcionário.
	 *
	 * <p>Representado por um caractere (ex.: 'A' para atendente, 'G' para gerente).</p>
	 */
	@Column(name = "cargo_fun", nullable = false, length = 1)
	private String cargo_fun;

	/**
	 * Telefone do funcionário (campo opcional).
	 */
	@Column(name = "telefone_fun", length = 11)
	private String telefone_fun;

	/**
	 * Obtém o identificador do funcionário.
	 *
	 * @return id_fun
	 */
	public Long getId_fun() {
		return id_fun;
	}

	/**
	 * Obtém o nome do funcionário.
	 *
	 * @return nome_fun
	 */
	public String getNome_fun() {
		return nomeFun;
	}

	/**
	 * Define o nome do funcionário.
	 *
	 * @param nome_fun nome completo
	 */
	public void setNome_fun(String nome_fun) {
		this.nomeFun = nome_fun;
	}

	/**
	 * Obtém o cargo do funcionário.
	 *
	 * @return cargo_fun
	 */
	public String getCargo_fun() {
		return cargo_fun;
	}

	/**
	 * Define o cargo do funcionário.
	 *
	 * @param cargo_fun caractere representando o cargo
	 */
	public void setCargo_fun(String cargo_fun) {
		this.cargo_fun = cargo_fun;
	}

	/**
	 * Obtém o telefone do funcionário.
	 *
	 * @return telefone_fun
	 */
	public String getTelefone_fun() {
		return telefone_fun;
	}

	/**
	 * Define o telefone do funcionário.
	 *
	 * @param telefone_fun telefone com até 11 dígitos
	 */
	public void setTelefone_fun(String telefone_fun) {
		this.telefone_fun = telefone_fun;
	}

	@Override
	public String toString() {
		return "Funcionario [id_fun=" + id_fun + ", nome_fun=" + nomeFun + ", cargo_fun=" + cargo_fun
				+ ", telefone_fun=" + telefone_fun + "]";
	}
}
