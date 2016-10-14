package com.ibolt.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "model")
public class ItemPedido {
	@XmlElement
	private Long codigo;
	@XmlElement
	private Long codigo_pedido;
	@XmlElement
	private Long codigo_produto_grade;
	@XmlElement
	private Long quantidade;
	@XmlElement
	private Double valor;
	@XmlElement
	private String descricao;

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigoPedido() {
		return this.codigo_pedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigo_pedido = codigoPedido;
	}

	public Long getCodigoProdutoGrade() {
		return this.codigo_produto_grade;
	}

	public void setCodigoProdutoGrade(Long codigoProdutoGrade) {
		this.codigo_produto_grade = codigoProdutoGrade;
	}

	public Long getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return this.valor;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valor = valorUnitario;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return "ItemPedido [codigoPedido=" + this.codigo_pedido + ", codigoProdutoGrade=" + this.codigo_produto_grade
				+ ", quantidade=" + this.quantidade + ", valorUnitario=" + this.valor + ", descricao=" + this.descricao
				+ "]";
	}
}