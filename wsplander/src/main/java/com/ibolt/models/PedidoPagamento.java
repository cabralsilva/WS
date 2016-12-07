package com.ibolt.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="model")
public class PedidoPagamento extends AutenticacaoAcesso{
    @XmlElement
    private Long codigo;
    @XmlElement
    private Long CodigoPedido;
    @XmlElement
    private Long CodigoFormaPagamento;
    @XmlElement
    private String Data;
    @XmlElement
    private Long Parcelas;
    @XmlElement
    private Double Valor;

    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigoPedido() {
        return this.CodigoPedido;
    }

    public void setCodigoPedido(Long codigoPedido) {
        this.CodigoPedido = codigoPedido;
    }

    public Long getCodigoFormaPagamento() {
        return this.CodigoFormaPagamento;
    }

    public void setCodigoFormaPagamento(Long codigoFormaPagamento) {
        this.CodigoFormaPagamento = codigoFormaPagamento;
    }

    public String getData() {
        return this.Data;
    }

    public void setData(String data) {
        this.Data = data;
    }

    public Long getParcelas() {
        return this.Parcelas;
    }

    public void setParcelas(Long parcelas) {
        this.Parcelas = parcelas;
    }

    public Double getValor() {
        return this.Valor;
    }

    public void setValor(Double valor) {
        this.Valor = valor;
    }

    public String toString() {
        return "ItemPedido [codigo=" + this.codigo + ", CodigoPedido=" + this.CodigoPedido + ", CodigoFormaPagamento=" + this.CodigoFormaPagamento + ", Data=" + this.Data + ", Parcelas=" + this.Parcelas + ", Valor=" + this.Valor + "]";
    }
}