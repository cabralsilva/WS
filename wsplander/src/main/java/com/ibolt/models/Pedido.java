package com.ibolt.models;

import com.ibolt.models.Cliente;
import com.ibolt.models.ItemPedido;
import com.ibolt.models.PedidoPagamento;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="model")
public class Pedido extends AutenticacaoAcesso{
    @XmlElement
    private Long codigoPedido;
    @XmlElement
    private String Loja;
    @XmlElement
    private String Processo;
    @XmlElement
    private String Editar;
    @XmlElement
    private String EntregaNome;
    @XmlElement
    private String EntregaRua;
    @XmlElement
    private String EntregaNumero;
    @XmlElement
    private String EntregaComplemento;
    @XmlElement
    private String EntregaBairro;
    @XmlElement
    private String EntregaMunicipio;
    @XmlElement
    private String EntregaUf;
    @XmlElement
    private String EntregaCep;
    @XmlElement
    private String EntregaInformacoesReferencia;
    @XmlElement
    private Long CodigoCliente;
    @XmlElement
    private String ClientePessoa;
    @XmlElement
    private String ClienteNome;
    @XmlElement
    private String ClienteDataNascimento;
    @XmlElement
    private String ClienteCpf;
    @XmlElement
    private String ClienteRg;
    @XmlElement
    private String ClienteRazaoSocial;
    @XmlElement
    private String ClienteCnpj;
    @XmlElement
    private String ClienteInscricaoEstadual;
    @XmlElement
    private String ClienteEmail;
    @XmlElement
    private String ClienteCep;
    @XmlElement
    private String ClienteRua;
    @XmlElement
    private String ClienteNumero;
    @XmlElement
    private String ClienteComplemento;
    @XmlElement
    private String ClienteBairro;
    @XmlElement
    private String ClienteMunicipio;
    @XmlElement
    private String ClienteUf;
    @XmlElement
    private String ClienteInformacoesReferencia;
    @XmlElement
    private String ClienteDdd1;
    @XmlElement
    private String ClienteDdd2;
    @XmlElement
    private String ClienteTelefone1;
    @XmlElement
    private String ClienteTelefone2;
    @XmlElement
    private String ClienteSenha;
    @XmlElement
    private String TransacaoIp;
    @XmlElement
    private String FormaPagamento;
    @XmlElement
    private String DataVencimento;
    @XmlElement
    private String NumeroParcelas;
    @XmlElement
    private String ValorParcelas;
    @XmlElement
    private String CartaoTitular;
    @XmlElement
    private String CartaoNumero;
    @XmlElement
    private String CartaoValidade;
    @XmlElement
    private String CartaoCodigoSeguranca;
    @XmlElement
    private String ValorOutros;
    @XmlElement
    private String TipoFrete;
    @XmlElement
    private String ValorFrete;
    @XmlElement
    private String ValorFinal;
    @XmlElement
    private Long Quantidade;
    @XmlElement
    private String Subtotal;
    @XmlElement
    private Cliente fkCliente;
    @XmlElement
    private List<ItemPedido> lstItems;
    @XmlElement
    private PedidoPagamento fkPagamento;

    public String getSubtotal() {
        return this.Subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.Subtotal = subtotal;
    }

    public Long getQuantidade() {
        return this.Quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.Quantidade = quantidade;
    }

    public Long getCodigoPedido() {
        return this.codigoPedido;
    }

    public void setCodigoPedido(Long codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getLoja() {
        return this.Loja;
    }

    public void setLoja(String loja) {
        this.Loja = loja;
    }

    public String getProcesso() {
        return this.Processo;
    }

    public void setProcesso(String processo) {
        this.Processo = processo;
    }

    public String getEditar() {
        return this.Editar;
    }

    public void setEditar(String editar) {
        this.Editar = editar;
    }

    public Long getCodigoCliente() {
        return this.CodigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.CodigoCliente = codigoCliente;
    }

    public String getClientePessoa() {
        return this.ClientePessoa;
    }

    public void setClientePessoa(String clientePessoa) {
        this.ClientePessoa = clientePessoa;
    }

    public String getEntregaNome() {
        return this.EntregaNome;
    }

    public void setEntregaNome(String entregaNome) {
        this.EntregaNome = entregaNome;
    }

    public String getEntregaRua() {
        return this.EntregaRua;
    }

    public void setEntregaRua(String entregaRua) {
        this.EntregaRua = entregaRua;
    }

    public String getEntregaNumero() {
        return this.EntregaNumero;
    }

    public void setEntregaNumero(String entregaNumero) {
        this.EntregaNumero = entregaNumero;
    }

    public String getEntregaComplemento() {
        return this.EntregaComplemento;
    }

    public void setEntregaComplemento(String entregaComplemento) {
        this.EntregaComplemento = entregaComplemento;
    }

    public String getEntregaBairro() {
        return this.EntregaBairro;
    }

    public void setEntregaBairro(String entregaBairro) {
        this.EntregaBairro = entregaBairro;
    }

    public String getEntregaMunicipio() {
        return this.EntregaMunicipio;
    }

    public void setEntregaMunicipio(String entregaMunicipio) {
        this.EntregaMunicipio = entregaMunicipio;
    }

    public String getEntregaUf() {
        return this.EntregaUf;
    }

    public void setEntregaUf(String entregaUf) {
        this.EntregaUf = entregaUf;
    }

    public String getEntregaCep() {
        return this.EntregaCep;
    }

    public void setEntregaCep(String entregaCep) {
        this.EntregaCep = entregaCep;
    }

    public String getEntregaInformacoesReferencia() {
        return this.EntregaInformacoesReferencia;
    }

    public void setEntregaInformacoesReferencia(String entregaInformacoesReferencia) {
        this.EntregaInformacoesReferencia = entregaInformacoesReferencia;
    }

    public String getClienteNome() {
        return this.ClienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.ClienteNome = clienteNome;
    }

    public String getClienteDataNascimento() {
        return this.ClienteDataNascimento;
    }

    public void setClienteDataNascimento(String clienteDataNascimento) {
        this.ClienteDataNascimento = clienteDataNascimento;
    }

    public String getClienteCpf() {
        return this.ClienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.ClienteCpf = clienteCpf;
    }

    public String getClienteRg() {
        return this.ClienteRg;
    }

    public void setClienteRg(String clienteRg) {
        this.ClienteRg = clienteRg;
    }

    public String getClienteRazaoSocial() {
        return this.ClienteRazaoSocial;
    }

    public void setClienteRazaoSocial(String clienteRazaoSocial) {
        this.ClienteRazaoSocial = clienteRazaoSocial;
    }

    public String getClienteCnpj() {
        return this.ClienteCnpj;
    }

    public void setClienteCnpj(String clienteCnpj) {
        this.ClienteCnpj = clienteCnpj;
    }

    public String getClienteInscricaoEstadual() {
        return this.ClienteInscricaoEstadual;
    }

    public void setClienteInscricaoEstadual(String clienteInscricaoEstadual) {
        this.ClienteInscricaoEstadual = clienteInscricaoEstadual;
    }

    public String getClienteEmail() {
        return this.ClienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.ClienteEmail = clienteEmail;
    }

    public String getClienteCep() {
        return this.ClienteCep;
    }

    public void setClienteCep(String clienteCep) {
        this.ClienteCep = clienteCep;
    }

    public String getClienteRua() {
        return this.ClienteRua;
    }

    public void setClienteRua(String clienteRua) {
        this.ClienteRua = clienteRua;
    }

    public String getClienteNumero() {
        return this.ClienteNumero;
    }

    public void setClienteNumero(String clienteNumero) {
        this.ClienteNumero = clienteNumero;
    }

    public String getClienteComplemento() {
        return this.ClienteComplemento;
    }

    public void setClienteComplemento(String clienteComplemento) {
        this.ClienteComplemento = clienteComplemento;
    }

    public String getClienteBairro() {
        return this.ClienteBairro;
    }

    public void setClienteBairro(String clienteBairro) {
        this.ClienteBairro = clienteBairro;
    }

    public String getClienteMunicipio() {
        return this.ClienteMunicipio;
    }

    public void setClienteMunicipio(String clienteMunicipio) {
        this.ClienteMunicipio = clienteMunicipio;
    }

    public String getClienteUf() {
        return this.ClienteUf;
    }

    public void setClienteUf(String clienteUf) {
        this.ClienteUf = clienteUf;
    }

    public String getClienteInformacoesReferencia() {
        return this.ClienteInformacoesReferencia;
    }

    public void setClienteInformacoesReferencia(String clienteInformacoesReferencia) {
        this.ClienteInformacoesReferencia = clienteInformacoesReferencia;
    }

    public String getClienteDdd1() {
        return this.ClienteDdd1;
    }

    public void setClienteDdd1(String clienteDdd) {
        this.ClienteDdd1 = clienteDdd;
    }

    public String getClienteTelefone1() {
        return this.ClienteTelefone1;
    }

    public void setClienteTelefone1(String clienteTelefone) {
        this.ClienteTelefone1 = clienteTelefone;
    }

    public String getClienteDdd2() {
        return this.ClienteDdd2;
    }

    public void setClienteDdd2(String clienteDdd) {
        this.ClienteDdd2 = clienteDdd;
    }

    public String getClienteTelefone2() {
        return this.ClienteTelefone2;
    }

    public void setClienteTelefone2(String clienteTelefone) {
        this.ClienteTelefone2 = clienteTelefone;
    }

    public String getClienteSenha() {
        return this.ClienteSenha;
    }

    public void setClienteSenha(String clienteSenha) {
        this.ClienteSenha = clienteSenha;
    }

    public String getTransacaoIp() {
        return this.TransacaoIp;
    }

    public void setTransacaoIp(String transacaoIp) {
        this.TransacaoIp = transacaoIp;
    }

    public String getFormaPagamento() {
        return this.FormaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.FormaPagamento = formaPagamento;
    }

    public String getDataVencimento() {
        return this.DataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.DataVencimento = dataVencimento;
    }

    public String getNumeroParcelas() {
        return this.NumeroParcelas;
    }

    public void setNumeroParcelas(String numeroParcelas) {
        this.NumeroParcelas = numeroParcelas;
    }

    public String getValorParcelas() {
        return this.ValorParcelas;
    }

    public void setValorParcelas(String valorParcelas) {
        this.ValorParcelas = valorParcelas;
    }

    public String getCartaoTitular() {
        return this.CartaoTitular;
    }

    public void setCartaoTitular(String cartaoTitular) {
        this.CartaoTitular = cartaoTitular;
    }

    public String getCartaoNumero() {
        return this.CartaoNumero;
    }

    public void setCartaoNumero(String cartaoNumero) {
        this.CartaoNumero = cartaoNumero;
    }

    public String getCartaoValidade() {
        return this.CartaoValidade;
    }

    public void setCartaoValidade(String cartaoValidade) {
        this.CartaoValidade = cartaoValidade;
    }

    public String getCartaoCodigoSeguranca() {
        return this.CartaoCodigoSeguranca;
    }

    public void setCartaoCodigoSeguranca(String cartaoCodigoSeguranca) {
        this.CartaoCodigoSeguranca = cartaoCodigoSeguranca;
    }

    public String getValorOutros() {
        return this.ValorOutros;
    }

    public void setValorOutros(String valorOutros) {
        this.ValorOutros = valorOutros;
    }

    public String getTipoFrete() {
        return this.TipoFrete;
    }

    public void setTipoFrete(String tipoFrete) {
        this.TipoFrete = tipoFrete;
    }

    public String getValorFrete() {
        return this.ValorFrete;
    }

    public void setValorFrete(String valorFrete) {
        this.ValorFrete = valorFrete;
    }

    public String getValorFinal() {
        return this.ValorFinal;
    }

    public void setValorFinal(String valorFinal) {
        this.ValorFinal = valorFinal;
    }

    public Cliente getFkCliente() {
        return this.fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    public List<ItemPedido> getLstItems() {
        return this.lstItems;
    }

    public void setLstItems(List<ItemPedido> lstItems) {
        this.lstItems = lstItems;
    }

    public PedidoPagamento getFkPagamento() {
        return this.fkPagamento;
    }

    public void setFkPagamento(PedidoPagamento fkPagamento) {
        this.fkPagamento = fkPagamento;
    }

    public String toString() {
        return "Pedido [codigoPedido=" + this.codigoPedido + ", Loja=" + this.Loja + ", Processo=" + this.Processo + ", Editar=" + this.Editar + ", EntregaNome=" + this.EntregaNome + ", EntregaRua=" + this.EntregaRua + ", EntregaNumero=" + this.EntregaNumero + ", EntregaComplemento=" + this.EntregaComplemento + ", EntregaBairro=" + this.EntregaBairro + ", EntregaMunicipio=" + this.EntregaMunicipio + ", EntregaUf=" + this.EntregaUf + ", EntregaCep=" + this.EntregaCep + ", EntregaInformacoesReferencia=" + this.EntregaInformacoesReferencia + ", CodigoCliente=" + this.CodigoCliente + ", ClientePessoa=" + this.ClientePessoa + ", ClienteNome=" + this.ClienteNome + ", ClienteDataNascimento=" + this.ClienteDataNascimento + ", ClienteCpf=" + this.ClienteCpf + ", ClienteRg=" + this.ClienteRg + ", ClienteRazaoSocial=" + this.ClienteRazaoSocial + ", ClienteCnpj=" + this.ClienteCnpj + ", ClienteInscricaoEstadual=" + this.ClienteInscricaoEstadual + ", ClienteEmail=" + this.ClienteEmail + ", ClienteCep=" + this.ClienteCep + ", ClienteRua=" + this.ClienteRua + ", ClienteNumero=" + this.ClienteNumero + ", ClienteComplemento=" + this.ClienteComplemento + ", ClienteBairro=" + this.ClienteBairro + ", ClienteMunicipio=" + this.ClienteMunicipio + ", ClienteUf=" + this.ClienteUf + ", ClienteInformacoesReferencia=" + this.ClienteInformacoesReferencia + ", ClienteDdd1=" + this.ClienteDdd1 + ", ClienteDdd2=" + this.ClienteDdd2 + ", ClienteTelefone1=" + this.ClienteTelefone1 + ", ClienteTelefone2=" + this.ClienteTelefone2 + ", ClienteSenha=" + this.ClienteSenha + ", TransacaoIp=" + this.TransacaoIp + ", FormaPagamento=" + this.FormaPagamento + ", DataVencimento=" + this.DataVencimento + ", NumeroParcelas=" + this.NumeroParcelas + ", ValorParcelas=" + this.ValorParcelas + ", CartaoTitular=" + this.CartaoTitular + ", CartaoNumero=" + this.CartaoNumero + ", CartaoValidade=" + this.CartaoValidade + ", CartaoCodigoSeguranca=" + this.CartaoCodigoSeguranca + ", ValorOutros=" + this.ValorOutros + ", TipoFrete=" + this.TipoFrete + ", ValorFrete=" + this.ValorFrete + ", ValorFinal=" + this.ValorFinal + ", Quantidade=" + this.Quantidade + ", Subtotal=" + this.Subtotal + ", fkCliente=" + this.fkCliente + ", lstItems=" + this.lstItems + "]";
    }
}
