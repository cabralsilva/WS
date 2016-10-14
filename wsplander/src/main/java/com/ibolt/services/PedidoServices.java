package com.ibolt.services;

import com.ibolt.models.Pedido;
import com.ibolt.models.RetornoWS;
import com.ibolt.services.ControlServices;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoServices extends ControlServices {
	public void invalidarPedido(Pedido p, String msg) throws SQLException {
		String sql = "UPDATE Pedido SET Processo = 'Falha de Comunicação', LogWebService = '" + msg + "' " + "WHERE "
				+ "Pedido.Codigo = " + p.getCodigoPedido();
		System.out.println(sql);
		this.sttm.execute(sql);
	}

	public RetornoWS<Pedido> insertPedidoClienteNovo(Pedido p) throws SQLException {
		RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
		String columns = "CodigoCliente, Loja, Processo, Editar, ClientePessoa, EntregaNome, EntregaRua, EntregaNumero, EntregaComplemento, EntregaBairro, EntregaMunicipio, EntregaUf, EntregaCep, EntregaInformacoesReferencia, ClienteNome, ClienteDataNascimento, ClienteCpf, ClienteRg, ClienteRazaoSocial, ClienteCnpj, ClienteInscricaoEstadual, ClienteEmail, ClienteCep, ClienteRua, ClienteNumero, ClienteComplemento, ClienteBairro, ClienteMunicipio, ClienteUf, ClienteInformacoesReferencia, ClienteDdd[1], ClienteTelefone[1], ClienteDdd[2], ClienteTelefone[2], ClienteSenha";
		String values = p.getCodigoCliente() + ", '" + p.getLoja() + "', '" + p.getProcesso() + "', '" + p.getEditar()
				+ "', '" + p.getClientePessoa() + "', '"
				+ (p.getClienteNome() != null ? p.getClienteNome() : p.getClienteRazaoSocial()) + "', '"
				+ p.getClienteRua() + "', '" + p.getClienteNumero() + "', '" + p.getClienteComplemento() + "', '"
				+ p.getClienteBairro() + "', '" + p.getClienteMunicipio() + "', '" + p.getClienteUf() + "', '"
				+ p.getClienteCep() + "'";
		values = String.valueOf(values) + (p.getEntregaInformacoesReferencia() == null
				? new StringBuilder(", ").append((Object) null).toString()
				: new StringBuilder(", '").append(p.getEntregaInformacoesReferencia()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteNome() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteNome()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteDataNascimento() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteDataNascimento()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteCpf() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteCpf()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteRg() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteRg()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteRazaoSocial() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteRazaoSocial()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteCnpj() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteCnpj()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteInscricaoEstadual() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteInscricaoEstadual()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteEmail() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteEmail()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteCep() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteCep()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteRua() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteRua()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteNumero() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteNumero()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteComplemento() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteComplemento()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteBairro() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteBairro()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteMunicipio() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteMunicipio()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteUf() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteUf()).append("'").toString());
		values = String.valueOf(values) + (p.getClienteInformacoesReferencia() == null
				? new StringBuilder(", ").append((Object) null).toString()
				: new StringBuilder(", '").append(p.getClienteInformacoesReferencia()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteDdd1() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteDdd1()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteTelefone1() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteTelefone1()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteDdd2() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteDdd2()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteTelefone2() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteTelefone2()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteSenha() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteSenha()).append("'").toString());
		String sql = "INSERT INTO Pedido (" + columns + ") values (" + values + ")";
		System.out.println(sql);
		this.sttm.execute(sql, 1);
		ResultSet rs = this.sttm.getGeneratedKeys();
		while (rs.next()) {
			p.setCodigoPedido(Long.valueOf(rs.getLong(1)));
			retorno.setCodStatus(Long.valueOf(1));
			retorno.setMsg("Pedido inserido com sucesso");
			retorno.setModel(p);
		}
		rs.close();
		return retorno;
	}

	public RetornoWS<Pedido> insertPedido(Pedido p) throws SQLException {
		RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
		String columns = "CodigoCliente, Loja, Processo, Editar, ClientePessoa, EntregaNome, EntregaRua, EntregaNumero, EntregaComplemento, EntregaBairro, EntregaMunicipio, EntregaUf, EntregaCep, EntregaInformacoesReferencia, ClienteNome, ClienteDataNascimento, ClienteCpf, ClienteRg, ClienteRazaoSocial, ClienteCnpj, ClienteInscricaoEstadual, ClienteEmail, ClienteCep, ClienteRua, ClienteNumero, ClienteComplemento, ClienteBairro, ClienteMunicipio, ClienteUf, ClienteInformacoesReferencia, ClienteDdd[1], ClienteTelefone[1], ClienteDdd[2], ClienteTelefone[2], ClienteSenha";
		String values = p.getCodigoCliente() + ", '" + p.getLoja() + "', '" + p.getProcesso() + "', '" + p.getEditar()
				+ "', '" + p.getClientePessoa() + "', '" + p.getEntregaNome() + "', '" + p.getEntregaRua() + "', '"
				+ p.getEntregaNumero() + "', '" + p.getEntregaComplemento() + "', '" + p.getEntregaBairro() + "', '"
				+ p.getEntregaMunicipio() + "', '" + p.getEntregaUf() + "', '" + p.getEntregaCep() + "'";
		values = String.valueOf(values) + (p.getEntregaInformacoesReferencia() == null
				? new StringBuilder(", ").append((Object) null).toString()
				: new StringBuilder(", '").append(p.getEntregaInformacoesReferencia()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteNome() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteNome()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteDataNascimento() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteDataNascimento()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteCpf() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteCpf()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteRg() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteRg()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteRazaoSocial() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteRazaoSocial()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteCnpj() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteCnpj()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteInscricaoEstadual() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteInscricaoEstadual()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteEmail() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteEmail()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteCep() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteCep()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteRua() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteRua()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteNumero() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteNumero()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteComplemento() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteComplemento()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteBairro() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteBairro()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteMunicipio() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteMunicipio()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteUf() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteUf()).append("'").toString());
		values = String.valueOf(values) + (p.getClienteInformacoesReferencia() == null
				? new StringBuilder(", ").append((Object) null).toString()
				: new StringBuilder(", '").append(p.getClienteInformacoesReferencia()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteDdd1() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteDdd1()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteTelefone1() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteTelefone1()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteDdd2() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteDdd2()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteTelefone2() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteTelefone2()).append("'").toString());
		values = String.valueOf(values)
				+ (p.getClienteSenha() == null ? new StringBuilder(", ").append((Object) null).toString()
						: new StringBuilder(", '").append(p.getClienteSenha()).append("'").toString());
		String sql = "INSERT INTO Pedido (" + columns + ") values (" + values + ")";
		System.out.println(sql);
		this.sttm.execute(sql, 1);
		ResultSet rs = this.sttm.getGeneratedKeys();
		while (rs.next()) {
			p.setCodigoPedido(Long.valueOf(rs.getLong(1)));
			retorno.setCodStatus(Long.valueOf(1));
			retorno.setMsg("Pedido inserido com sucesso");
			retorno.setModel(p);
		}
		rs.close();
		return retorno;
	}

	public Long getPedidoForId(Long id) throws SQLException {
		Long codigo = null;
		String sql = "SELECT Codigo FROM Pedido WHERE Id = " + id;
		System.out.println(sql);
		ResultSet rs = this.sttm.executeQuery(sql);
		while (rs.next()) {
			codigo = rs.getLong("Codigo");
		}
		rs.close();
		return codigo;
	}

	public RetornoWS<Pedido> getPedidoForCodigo(Long codigo) throws SQLException {
		RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
		String sql = "SELECT Pedido.Codigo, Pedido.Loja, Pedido.Processo, Pedido.Editar, Pedido.EntregaNome, Pedido.EntregaRua, Pedido.EntregaNumero, Pedido.EntregaComplemento, Pedido.EntregaBairro, Pedido.EntregaMunicipio, Pedido.EntregaUf, Pedido.EntregaCep, Pedido.CodigoCliente, Pedido.ClienteNome, Pedido.ClienteDataNascimento, Pedido.ClienteCpf, Pedido.ClienteRg, Pedido.ClienteRazaoSocial, Pedido.ClienteCnpj, Pedido.ClienteInscricaoEstadual, Pedido.ClienteEmail, Pedido.ClienteCep, Pedido.ClienteRua, Pedido.ClienteNumero, Pedido.ClienteComplemento, Pedido.ClienteBairro, Pedido.ClienteMunicipio, Pedido.ClienteUf, Pedido.ClienteInformacoesReferencia, Pedido.ClienteDdd, Pedido.ClienteTelefone, Pedido.ClienteDdd[2] AS ClienteDdd2, Pedido.ClienteTelefone[2] AS ClienteTelefone2, Pedido.ClienteSenha, Pedido.TransacaoIp, Pedido.FormaPagamento, Pedido.DataVencimento, Pedido.NumeroParcelas, Pedido.ValorParcelas, Pedido.CartaoTitular, Pedido.CartaoNumero, Pedido.CartaoValidade, Pedido.CartaoCodigoSeguranca, Pedido.ValorOutros, Pedido.TipoFrete, Pedido.ValorFrete, Pedido.ValorFinal, Pedido.Quantidade, Pedido.Subtotal, Cliente.Email AS EmailC FROM Pedido  LEFT JOIN Cliente ON Pedido.CodigoCliente = Cliente.Codigo  WHERE Pedido.Codigo = "
				+ codigo;
		System.out.println(sql);
		ResultSet rs = this.sttm.executeQuery(sql);
		rs.last();
		int numeroRegistros = rs.getRow();
		rs.beforeFirst();
		if (numeroRegistros == 1) {
			while (rs.next()) {
				Pedido p = new Pedido();
				p.setCodigoPedido(Long.valueOf(rs.getLong("Codigo")));
				p.setLoja(rs.getString("Loja"));
				p.setProcesso(rs.getString("Processo"));
				p.setEditar(rs.getString("Editar"));
				p.setEntregaNome(rs.getString("EntregaNome"));
				p.setEntregaRua(rs.getString("EntregaRua"));
				p.setEntregaNumero(rs.getString("EntregaNumero"));
				p.setEntregaComplemento(rs.getString("EntregaComplemento"));
				p.setEntregaBairro(rs.getString("EntregaBairro"));
				p.setEntregaMunicipio(rs.getString("EntregaMunicipio"));
				p.setEntregaUf(rs.getString("EntregaUf"));
				p.setEntregaCep(rs.getString("EntregaCep"));
				p.setCodigoCliente(Long.valueOf(rs.getLong("CodigoCliente")));
				p.setClienteNome(rs.getString("ClienteNome"));
				p.setClienteDataNascimento(rs.getString("ClienteDataNascimento"));
				p.setClienteCpf(rs.getString("ClienteCpf"));
				p.setClienteRg(rs.getString("ClienteRg"));
				p.setClienteRazaoSocial(rs.getString("ClienteRazaoSocial"));
				p.setClienteCnpj(rs.getString("ClienteCnpj"));
				p.setClienteInscricaoEstadual(rs.getString("ClienteInscricaoEstadual"));
				p.setClienteEmail(rs.getString("ClienteEmail") != "" && rs.getString("ClienteEmail") != null
						? rs.getString("ClienteEmail") : rs.getString("EmailC"));
				p.setClienteCep(rs.getString("ClienteCep"));
				p.setClienteRua(rs.getString("ClienteRua"));
				p.setClienteNumero(rs.getString("ClienteNumero"));
				p.setClienteComplemento(rs.getString("ClienteComplemento"));
				p.setClienteBairro(rs.getString("ClienteBairro"));
				p.setClienteMunicipio(rs.getString("ClienteMunicipio"));
				p.setClienteUf(rs.getString("ClienteUf"));
				p.setClienteInformacoesReferencia(rs.getString("ClienteInformacoesReferencia"));
				p.setClienteDdd1(rs.getString("ClienteDdd"));
				p.setClienteDdd2(rs.getString("ClienteDdd2"));
				p.setClienteTelefone1(rs.getString("ClienteTelefone"));
				p.setClienteTelefone2(rs.getString("ClienteTelefone2"));
				p.setClienteSenha(rs.getString("ClienteSenha"));
				p.setTransacaoIp(rs.getString("TransacaoIp"));
				p.setFormaPagamento(rs.getString("FormaPagamento"));
				p.setDataVencimento(rs.getString("DataVencimento"));
				p.setNumeroParcelas(rs.getString("NumeroParcelas"));
				p.setValorParcelas(rs.getString("ValorParcelas"));
				p.setCartaoTitular(rs.getString("CartaoTitular"));
				p.setCartaoNumero(rs.getString("CartaoNumero"));
				p.setCartaoValidade(rs.getString("CartaoValidade"));
				p.setCartaoCodigoSeguranca(rs.getString("CartaoCodigoSeguranca"));
				p.setValorOutros(rs.getString("ValorOutros"));
				p.setTipoFrete(rs.getString("TipoFrete"));
				p.setValorFrete(rs.getString("ValorFrete"));
				p.setValorFinal(rs.getString("ValorFinal"));
				p.setQuantidade(Long.valueOf(rs.getLong("Quantidade")));
				p.setSubtotal(rs.getString("Subtotal"));
				retorno.setCodStatus(Long.valueOf(1));
				retorno.setMsg("Busca Realizada com Sucesso!");
				retorno.setModel(p);
			}
			rs.close();
		} else if(numeroRegistros == 0){
			rs.close();
			throw new SQLException("Nenhum Registro encontrado");
		} else if(numeroRegistros > 1){
			rs.close();
			throw new SQLException("Mais de um pedido com o mesmo código encontrado! ");
		}

		
		return retorno;
	}

	public RetornoWS<Pedido> limparItemsPedido(Pedido p) throws SQLException {
		RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
		String sql = "DELETE FROM PedidoProdutoGrade WHERE PedidoProdutoGrade.CodigoPedido = " + p.getCodigoPedido();
		System.out.println(sql);
		this.sttm.execute(sql);
		retorno.setCodStatus(Long.valueOf(1));
		retorno.setMsg("Items do pedido exclu\u00eddos");
		retorno.setModel(p);
		return retorno;
	}

	public RetornoWS<Pedido> updateDelivey(Pedido p) throws SQLException {
		RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
		String sql = "UPDATE Pedido SET EntregaNome = '" + p.getEntregaNome() + "', " + "EntregaCep = '"
				+ p.getEntregaCep() + "', " + "EntregaRua = '" + p.getEntregaRua() + "', " + "EntregaNumero = '"
				+ p.getEntregaNumero() + "', " + "EntregaComplemento = '" + p.getEntregaComplemento() + "', "
				+ "EntregaBairro = '" + p.getEntregaBairro() + "', " + "EntregaUf = '" + p.getEntregaUf() + "', "
				+ "EntregaMunicipio = '" + p.getEntregaMunicipio() + "' " + ", EntregaInformacoesReferencia = '"
				+ p.getEntregaInformacoesReferencia() + "' " + "WHERE " + "Pedido.Codigo = " + p.getCodigoPedido();
		System.out.println(sql);
		this.sttm.execute(sql);
		retorno.setCodStatus(Long.valueOf(1));
		retorno.setMsg("Items do pedido exclu\u00eddos");
		retorno.setModel(p);
		return retorno;
	}

	public RetornoWS<Pedido> updateClienteNovo(Pedido p) throws SQLException {
		RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
		String sql = "UPDATE Pedido SET ClienteNome = "
				+ (p.getClienteNome() == null ? new StringBuilder().append((Object) null).append(", ").toString()
						: new StringBuilder("'").append(p.getClienteNome()).append("', ").toString())
				+ "ClienteDataNascimento = '" + p.getClienteDataNascimento() + "', " + "ClienteCpf = "
				+ (p.getClienteCpf() == null ? new StringBuilder().append((Object) null).append(", ").toString()
						: new StringBuilder("'").append(p.getClienteCpf()).append("', ").toString())
				+ "ClienteRg = '" + p.getClienteRg() + "', " + "ClienteRazaoSocial = "
				+ (p.getClienteRazaoSocial() == null ? new StringBuilder().append((Object) null).append(", ").toString()
						: new StringBuilder("'").append(p.getClienteRazaoSocial()).append("', ").toString())
				+ "ClienteCnpj = "
				+ (p.getClienteCnpj() == null ? new StringBuilder().append((Object) null).append(", ").toString()
						: new StringBuilder("'").append(p.getClienteCnpj()).append("', ").toString())
				+ "ClienteInscricaoEstadual = "
				+ (p.getClienteInscricaoEstadual() == null
						? new StringBuilder().append((Object) null).append(", ").toString()
						: new StringBuilder("'").append(p.getClienteInscricaoEstadual()).append("', ").toString())
				+ "ClienteEmail = '" + p.getClienteEmail() + "', " + "ClienteCep = '" + p.getClienteCep() + "', "
				+ "ClienteRua = '" + p.getClienteRua() + "', " + "ClienteNumero = '" + p.getClienteNumero() + "', "
				+ "ClienteComplemento = '" + p.getClienteComplemento() + "', " + "ClienteBairro = '"
				+ p.getClienteBairro() + "', " + "ClienteMunicipio = '" + p.getClienteMunicipio() + "', "
				+ "ClienteUf = '" + p.getClienteUf() + "', " + "ClienteInformacoesReferencia = '"
				+ p.getClienteInformacoesReferencia() + "', " + "ClienteDdd[1] = '" + p.getClienteDdd1() + "', "
				+ "ClienteTelefone[1] = '" + p.getClienteTelefone1() + "', " + "ClienteDdd[2] = '" + p.getClienteDdd2()
				+ "', " + "ClienteTelefone[2] = '" + p.getClienteTelefone2() + "', ";
		if (p.getEntregaNome() != "" || p.getEntregaNome() != null) {
			sql = String.valueOf(sql) + "EntregaNome = '" + p.getEntregaNome() + "', " + "EntregaCep = '"
					+ p.getEntregaCep() + "', " + "EntregaRua = '" + p.getEntregaRua() + "', " + "EntregaNumero = '"
					+ p.getEntregaNumero() + "', " + "EntregaComplemento = '" + p.getEntregaComplemento() + "', "
					+ "EntregaBairro = '" + p.getEntregaBairro() + "', " + "EntregaUf = '" + p.getEntregaUf() + "', "
					+ "EntregaMunicipio = '" + p.getEntregaMunicipio() + "', ";
		}
		sql = String.valueOf(sql) + "ClienteSenha = '" + p.getClienteSenha() + "' " + "WHERE " + "Pedido.Codigo = "
				+ p.getCodigoPedido();
		System.out.println(sql);
		this.sttm.execute(sql);
		retorno.setCodStatus(Long.valueOf(1));
		retorno.setMsg("Informa\u00e7\u00f5es do cliente novo alterado com sucesso");
		retorno.setModel(p);
		return retorno;
	}

	public RetornoWS<Pedido> updatePedidoFinalizacao(Pedido p) throws SQLException {
		RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
		String setFields = " EntregaNome = '" + p.getEntregaNome() + "', " + "EntregaCep = '" + p.getEntregaCep()
				+ "', " + "EntregaRua = '" + p.getEntregaRua() + "', " + "EntregaNumero = '" + p.getEntregaNumero()
				+ "', " + "EntregaComplemento = '" + p.getEntregaComplemento() + "', " + "EntregaBairro = '"
				+ p.getEntregaBairro() + "', " + "EntregaUf = '" + p.getEntregaUf() + "', " + "EntregaMunicipio = '"
				+ p.getEntregaMunicipio() + "', " + "Processo = '" + p.getProcesso() + "', " + "TransacaoIp = '"
				+ p.getTransacaoIp() + "', " + "FormaPagamento = '" + p.getFormaPagamento() + "', " + "TipoFrete = '"
				+ p.getTipoFrete() + "', " + "Loja = '" + p.getLoja() + "', " + "ValorFrete = " + p.getValorFrete()
				+ ", " + "NumeroParcelas = " + p.getNumeroParcelas() + ", " + "ValorParcelas = " + p.getValorParcelas()
				+ ", ";
		setFields = p.getFormaPagamento().equals("boleto")
				? String.valueOf(setFields) + "DataVencimento = DATE '" + p.getDataVencimento() + "' "
				: String.valueOf(setFields) + "CartaoTitular = '" + p.getCartaoTitular() + "', " + "CartaoNumero = '"
						+ p.getCartaoNumero() + "', " + "CartaoValidade = '" + p.getCartaoValidade() + "', "
						+ "CartaoCodigoSeguranca = '" + p.getCartaoCodigoSeguranca() + "', " + "ValorOutros = "
						+ p.getValorOutros() + " ";
		String sql = "UPDATE Pedido SET " + setFields + "WHERE " + "Pedido.Codigo = " + p.getCodigoPedido();
		System.out.println(sql);
		this.sttm.execute(sql);
		retorno.setCodStatus(Long.valueOf(1));
		retorno.setMsg("Pedido Atualizado com sucesso");
		retorno.setModel(p);
		return retorno;
	}
}