package br.com.hemn.backend.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

/**
 * Representa um pagamento realizado para um determinado pedido.
 * Contém informações como valor total, forma de pagamento e data do pagamento.
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Entity
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único do pagamento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pag")
    private Long id_pag;

    /**
     * Valor total pago pelo cliente.
     */
    @Column(name = "valor_total_pag", nullable = false)
    private double valor_total_pag;

    /**
     * Forma de pagamento utilizada.
     * Exemplo: "D" (débito), "C" (crédito), "P" (PIX).
     */
    @Column(name = "forma_pagameto_pag", nullable = false, length = 1)
    private String forma_pagameto_pag;

    /**
     * Data e hora em que o pagamento foi realizado.
     */
    @Column(name = "data_pag", nullable = false)
    private LocalDateTime data_pag;

    /**
     * Pedido ao qual este pagamento está associado.
     */
    @ManyToOne
    @JoinColumn(name = "id_ped", nullable = false)
    private Pedido id_ped;

    /**
     * Retorna o identificador do pagamento.
     */
    public Long getId_pag() {
        return id_pag;
    }

    /**
     * Retorna o valor total pago.
     */
    public double getValor_total_pag() {
        return valor_total_pag;
    }

    /**
     * Define o valor total pago.
     */
    public void setValor_total_pag(double valor_total_pag) {
        this.valor_total_pag = valor_total_pag;
    }

    /**
     * Retorna a forma de pagamento utilizada.
     */
    public String getForma_pagameto_pag() {
        return forma_pagameto_pag;
    }

    /**
     * Define a forma de pagamento utilizada.
     */
    public void setForma_pagameto_pag(String forma_pagameto_pag) {
        this.forma_pagameto_pag = forma_pagameto_pag;
    }

    /**
     * Retorna a data do pagamento.
     */
    public LocalDateTime getData_pag() {
        return data_pag;
    }

    /**
     * Define a data do pagamento.
     */
    public void setData_pag(LocalDateTime data_pag) {
        this.data_pag = data_pag;
    }

    /**
     * Retorna o pedido relacionado ao pagamento.
     */
    public Pedido getId_ped() {
        return id_ped;
    }

    /**
     * Define o pedido relacionado ao pagamento.
     */
    public void setId_ped(Pedido id_ped) {
        this.id_ped = id_ped;
    }

    @Override
    public String toString() {
        return "Pagamento [id_pag=" + id_pag + ", valor_total_pag=" + valor_total_pag 
                + ", forma_pagameto_pag=" + forma_pagameto_pag 
                + ", data_pag=" + data_pag + ", id_ped=" + id_ped + "]";
    }
}
