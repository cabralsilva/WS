package com.ibolt.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="model")
public class Cliente extends AutenticacaoAcesso{
    @XmlElement
    private Long codigoCliente;
    @XmlElement
    private String Nome;
    @XmlElement
    private String Cpf;
    @XmlElement
    private String Rg;
    @XmlElement
    private String Logradouro;
    @XmlElement
    private String Municipio;
    @XmlElement
    private String Uf;
    @XmlElement
    private String Bairro;
    @XmlElement
    private String Numero;
    @XmlElement
    private String Complemento;
    @XmlElement
    private String Cep;
    @XmlElement
    private String Ddd1;
    @XmlElement
    private String Ddd2;
    @XmlElement
    private String Telefone1;
    @XmlElement
    private String Telefone2;
    @XmlElement
    private String Email;
    @XmlElement
    private String senhaCliente;
    @XmlElement
    private String sexoCliente;
    @XmlElement
    private String DataNascimento;
    @XmlElement
    private Long Pessoa;
    @XmlElement
    private String RazaoSocial;
    @XmlElement
    private String Cnpj;
    @XmlElement
    private String InscricaoEstadual;
    @XmlElement
    private String paisCliente;
    @XmlElement
    private String codigoPaisCliente;
    @XmlElement
    private String codigoMunicipioCliente;
    @XmlElement
    private String dataUltimaCompraCliente;
    @XmlElement
    private String InformacoesReferencia;

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getCpf() {
        return this.Cpf;
    }

    public void setCpf(String cpf) {
        this.Cpf = cpf;
    }

    public String getRg() {
        return this.Rg;
    }

    public void setRg(String rg) {
        this.Rg = rg;
    }

    public String getLogradouro() {
        return this.Logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.Logradouro = logradouro;
    }

    public String getMunicipio() {
        return this.Municipio;
    }

    public void setMunicipio(String municipio) {
        this.Municipio = municipio;
    }

    public String getUf() {
        return this.Uf;
    }

    public void setUf(String uf) {
        this.Uf = uf;
    }

    public String getBairro() {
        return this.Bairro;
    }

    public void setBairro(String bairro) {
        this.Bairro = bairro;
    }

    public String getNumero() {
        return this.Numero;
    }

    public void setNumero(String numero) {
        this.Numero = numero;
    }

    public String getComplemento() {
        return this.Complemento;
    }

    public void setComplemento(String complemento) {
        this.Complemento = complemento;
    }

    public String getCep() {
        return this.Cep;
    }

    public void setCep(String cep) {
        this.Cep = cep;
    }

    public String getDdd1() {
        return this.Ddd1;
    }

    public void setDdd1(String ddd1) {
        this.Ddd1 = ddd1;
    }

    public String getDdd2() {
        return this.Ddd2;
    }

    public void setDdd2(String ddd2) {
        this.Ddd2 = ddd2;
    }

    public String getTelefone1() {
        return this.Telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.Telefone1 = telefone1;
    }

    public String getTelefone2() {
        return this.Telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.Telefone2 = telefone2;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getDataNascimento() {
        return this.DataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.DataNascimento = dataNascimento;
    }

    public String getRazaoSocial() {
        return this.RazaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.RazaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return this.Cnpj;
    }

    public void setCnpj(String cnpj) {
        this.Cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return this.InscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.InscricaoEstadual = inscricaoEstadual;
    }

    public String getInformacoesReferencia() {
        return this.InformacoesReferencia;
    }

    public void setInformacoesReferencia(String informacoesReferencia) {
        this.InformacoesReferencia = informacoesReferencia;
    }

    public Long getCodigoCliente() {
        return this.codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getSenhaCliente() {
        return this.senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public String getSexoCliente() {
        return this.sexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    public String getPaisCliente() {
        return this.paisCliente;
    }

    public void setPaisCliente(String paisCliente) {
        this.paisCliente = paisCliente;
    }

    public String getCodigoPaisCliente() {
        return this.codigoPaisCliente;
    }

    public void setCodigoPaisCliente(String codigoPaisCliente) {
        this.codigoPaisCliente = codigoPaisCliente;
    }

    public String getCodigoMunicipioCliente() {
        return this.codigoMunicipioCliente;
    }

    public void setCodigoMunicipioCliente(String codigoMunicipioCliente) {
        this.codigoMunicipioCliente = codigoMunicipioCliente;
    }

    public String getDataUltimaCompraCliente() {
        return this.dataUltimaCompraCliente;
    }

    public void setDataUltimaCompraCliente(String dataUltimaCompraCliente) {
        this.dataUltimaCompraCliente = dataUltimaCompraCliente;
    }

    public Long getPessoa() {
        return this.Pessoa;
    }

    public void setPessoa(Long pessoa) {
        this.Pessoa = pessoa;
    }

    public String toString() {
        return "Cliente [codigoCliente=" + this.codigoCliente + ", Nome=" + this.Nome + ", Cpf=" + this.Cpf + ", Rg=" + this.Rg + ", Logradouro=" + this.Logradouro + ", Municipio=" + this.Municipio + ", Uf=" + this.Uf + ", Bairro=" + this.Bairro + ", Numero=" + this.Numero + ", Complemento=" + this.Complemento + ", Cep=" + this.Cep + ", Ddd1=" + this.Ddd1 + ", Ddd2=" + this.Ddd2 + ", Telefone1=" + this.Telefone1 + ", Telefone2=" + this.Telefone2 + ", Email=" + this.Email + ", senhaCliente=" + this.senhaCliente + ", sexoCliente=" + this.sexoCliente + ", DataNascimento=" + this.DataNascimento + ", Pessoa=" + this.Pessoa + ", RazaoSocial=" + this.RazaoSocial + ", Cnpj=" + this.Cnpj + ", InscricaoEstadual=" + this.InscricaoEstadual + ", paisCliente=" + this.paisCliente + ", codigoPaisCliente=" + this.codigoPaisCliente + ", codigoMunicipioCliente=" + this.codigoMunicipioCliente + ", dataUltimaCompraCliente=" + this.dataUltimaCompraCliente + ", InformacoesReferencia=" + this.InformacoesReferencia + "]";
    }
}