package br.com.hemn.backend.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ped")
	private Long id_ped;

	@Column(name = "data_hora_ped", nullable = false)
	private LocalDateTime data_hora_ped;

	@Column(name = "status_ped", nullable = false, length = 1)
	private String statusPed;

	@ManyToOne
	@JoinColumn(name = "id_cli", nullable = false)
	private Cliente id_cli;

	@ManyToOne
	@JoinColumn(name = "id_fun", nullable = false)
	private Funcionario id_fun;

	@OneToMany(mappedBy = "id_ped")
	private List<Item> itens;

	public Long getId_ped() {
		return id_ped;
	}

	public LocalDateTime getData_hora_ped() {
		return data_hora_ped;
	}

	public void setData_hora_ped(LocalDateTime data_hora_ped) {
		this.data_hora_ped = data_hora_ped;
	}

	public String getStatus_ped() {
		return statusPed;
	}

	public void setStatus_ped(String status_ped) {
		this.statusPed = status_ped;
	}

	public Cliente getId_cli() {
		return id_cli;
	}

	public void setId_cli(Cliente id_cli) {
		this.id_cli = id_cli;
	}

	public Funcionario getId_fun() {
		return id_fun;
	}

	public void setId_fun(Funcionario id_fun) {
		this.id_fun = id_fun;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Pedido [id_ped=" + id_ped + ", data_hora_ped=" + data_hora_ped + ", status_ped=" + statusPed
				+ ", id_cli=" + id_cli + ", id_fun=" + id_fun + "]";
	}
}
