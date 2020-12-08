package br.com.chagas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Column(length = 80, nullable = false)
    private String descricao;

    @Column(length = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoLancamento tipo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento", nullable = true)
    private Date dataVencimento;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_pagamento")
    private Date dataPagamento;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoLancamento getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lancamento)) {
            return false;
        }
        Lancamento lancamento = (Lancamento) o;
        return Objects.equals(id, lancamento.id) && Objects.equals(pessoa, lancamento.pessoa) && Objects.equals(descricao, lancamento.descricao) && Objects.equals(valor, lancamento.valor) && Objects.equals(tipo, lancamento.tipo) && Objects.equals(dataVencimento, lancamento.dataVencimento) && Objects.equals(dataPagamento, lancamento.dataPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pessoa, descricao, valor, tipo, dataVencimento, dataPagamento);
    }

}
