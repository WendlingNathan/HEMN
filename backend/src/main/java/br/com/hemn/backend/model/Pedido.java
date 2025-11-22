package br.com.hemn.backend.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Representa um pedido realizado por um cliente.
 * 
 * <p>Armazena informações como data/hora, status e associações com cliente,
 * funcionário responsável e itens do pedido.<p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único do pedido.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ped")
    private Long id_ped;

    /**
     * Data e hora em que o pedido foi registrado.
     */
    @Column(name = "data_hora_ped", nullable = false)
    private LocalDateTime data_hora_ped;

    /**
     * Status atual do pedido.
     * Exemplo: "A" (Aberto), "F" (Finalizado), "C" (Cancelado).
     */
    @Column(name = "status_ped", nullable = false, length = 1)
    private String statusPed;

    /**
     * Cliente que realizou o pedido.
     */
    @ManyToOne
    @JoinColumn(name = "id_cli", nullable = false)
    private Cliente id_cli;

    /**
     * Funcionário responsável por registrar o pedido.
     */
    @ManyToOne
    @JoinColumn(name = "id_fun", nullable = false)
    private Funcionario id_fun;

    /**
     * Itens que compõem este pedido.
     */
    @OneToMany(mappedBy = "id_ped")
    private List<Item> itens;

    /**
     * Retorna o identificador do pedido.
     */
    public Long getId_ped() {
        return id_ped;
    }

    /**
     * Retorna a data e hora do pedido.
     */
    public LocalDateTime getData_hora_ped() {
        return data_hora_ped;
    }

    /**
     * Define a data e hora do pedido.
     */
    public void setData_hora_ped(LocalDateTime data_hora_ped) {
        this.data_hora_ped = data_hora_ped;
    }

    /**
     * Retorna o status do pedido.
     */
    public String getStatus_ped() {
        return statusPed;
    }

    /**
     * Define o status do pedido.
     */
    public void setStatus_ped(String status_ped) {
        this.statusPed = status_ped;
    }

    /**
     * Retorna o cliente associado ao pedido.
     */
    public Cliente getId_cli() {
        return id_cli;
    }

    /**
     * Define o cliente associado ao pedido.
     */
    public void setId_cli(Cliente id_cli) {
        this.id_cli = id_cli;
    }

    /**
     * Retorna o funcionário responsável pelo pedido.
     */
    public Funcionario getId_fun() {
        return id_fun;
    }

    /**
     * Define o funcionário responsável pelo pedido.
     */
    public void setId_fun(Funcionario id_fun) {
        this.id_fun = id_fun;
    }

    /**
     * Retorna a lista de itens do pedido.
     */
    public List<Item> getItens() {
        return itens;
    }

    /**
     * Define a lista de itens do pedido.
     */
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Pedido [id_ped=" + id_ped + ", data_hora_ped=" + data_hora_ped 
                + ", status_ped=" + statusPed + ", id_cli=" + id_cli 
                + ", id_fun=" + id_fun + "]";
    }
}
