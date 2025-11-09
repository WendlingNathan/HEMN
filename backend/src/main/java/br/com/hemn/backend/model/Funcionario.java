package br.com.hemn.backend.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fun")
	private Long id_fun;

	@Column(name = "nome_fun", nullable = false, length = 80)
	private String nomeFun;

	@Column(name = "cargo_fun", nullable = false, length = 1)
	private String cargo_fun;

	@Column(name = "telefone_fun", length = 11)
	private String telefone_fun;

	public Long getId_fun() {
		return id_fun;
	}

	public String getNome_fun() {
		return nomeFun;
	}

	public void setNome_fun(String nome_fun) {
		this.nomeFun = nome_fun;
	}

	public String getCargo_fun() {
		return cargo_fun;
	}

	public void setCargo_fun(String cargo_fun) {
		this.cargo_fun = cargo_fun;
	}

	public String getTelefone_fun() {
		return telefone_fun;
	}

	public void setTelefone_fun(String telefone_fun) {
		this.telefone_fun = telefone_fun;
	}

	@Override
	public String toString() {
		return "Funcionario [id_fun=" + id_fun + ", nome_fun=" + nomeFun + ", cargo_fun=" + cargo_fun
				+ ", telefone_fun=" + telefone_fun + "]";
	}
}
