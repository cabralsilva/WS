package com.ibolt.services;

import com.ibolt.models.Cliente;
import com.ibolt.models.RetornoWS;
import com.ibolt.services.ControlServices;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteService extends ControlServices {
	public RetornoWS<Cliente> insertCliente(Cliente c) {
		RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
		return retorno;
	}

	public RetornoWS<Cliente> updateCliente(Cliente c) throws SQLException {
		RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
		try {
			removeCaracteres(c);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		String sql = "UPDATE Cliente SET \tNome = "
				+ (c.getNome() == null ? null : new StringBuilder("'").append(c.getNome()).append("'").toString())
				+ ", DataNascimento = "
				+ (c.getDataNascimento() != null
						? new StringBuilder("DATE '").append(c.getDataNascimento()).append("'").toString() : null)
				+ ", Cpf = " + c.getCpf() + ", Rg = "
				+ (c.getRg() == null ? null : new StringBuilder("'").append(c.getRg()).append("'").toString())
				+ ", RazaoSocial = "
				+ (c.getRazaoSocial() == null ? null
						: new StringBuilder("'").append(c.getRazaoSocial()).append("'").toString())
				+ ", Cnpj = " + c.getCnpj() + ", InscricaoEstadual = "
				+ (c.getInscricaoEstadual() == null ? null
						: new StringBuilder("'").append(c.getInscricaoEstadual()).append("'").toString())
				+ ", Email = '" + c.getEmail() + "'" + ", Cep = " + c.getCep() + ", Logradouro = '" + c.getLogradouro()
				+ "'" + ", Numero = '" + c.getNumero() + "'" + ", Complemento = '" + c.getComplemento() + "'"
				+ ", Bairro = '" + c.getBairro() + "'" + ", Municipio = '" + c.getMunicipio() + "'" + ", Uf = '"
				+ c.getUf() + "'" + ", InformacoesReferencia = '" + c.getInformacoesReferencia() + "'" + ", Ddd[1] = '"
				+ c.getDdd1() + "'" + ", Telefone[1] = '" + c.getTelefone1() + "'" + ", Ddd[2] = '" + c.getDdd2() + "'"
				+ ", Telefone[2] = '" + c.getTelefone2() + "'" + " WHERE " + "Cliente.Codigo = " + c.getCodigoCliente();
		System.out.println(sql);
		this.sttm.execute(sql);
		retorno.setCodStatus(Long.valueOf(1));
		retorno.setMsg("Cliente Atualizado com sucesso!");
		retorno.setModel(c);
		return retorno;
	}

	public RetornoWS<Cliente> updateSenhaCliente(Cliente c) throws SQLException {
		RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
		try {
			removeCaracteres(c);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		String sql = "UPDATE Cliente SET \tSenha = '" + c.getSenhaCliente() + "'" + " WHERE " + "Cliente.Codigo = "
				+ c.getCodigoCliente();
		System.out.println(sql);
		this.sttm.execute(sql);
		retorno.setCodStatus(Long.valueOf(1));
		retorno.setMsg("Senha Alterada com sucesso!");
		retorno.setModel(c);
		return retorno;
	}

	public RetornoWS<Cliente> getClienteForCodigo(Long codigo) throws SQLException {
		RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
		String sql = "SELECT Cliente.Codigo, Cliente.Nome, Cliente.Logradouro, Cliente.Bairro, Cliente.Numero, Cliente.Municipio, Cliente.Cep, Cliente.Uf FROM Cliente WHERE Cliente.Codigo = "
				+ codigo;
		System.out.println(sql);
		ResultSet rs = this.sttm.executeQuery(sql);
		while (rs.next()) {
			Cliente c = new Cliente();
			c.setNome(rs.getString("Nome"));
			c.setLogradouro(rs.getString("Logradouro"));
			c.setBairro(rs.getString("Bairro"));
			c.setNumero(rs.getString("Numero"));
			c.setMunicipio(rs.getString("Municipio"));
			c.setUf(rs.getString("Uf"));
			c.setCep(rs.getString("Cep"));
			retorno.setCodStatus(Long.valueOf(1));
			retorno.setMsg("Busca Realizada com Sucesso!");
			retorno.setModel(c);
		}
		rs.close();
		return retorno;
	}

	public RetornoWS<Cliente> searchEmail(String email) throws SQLException {
		RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
		Cliente c = new Cliente();
		String sql = "SELECT Cliente.Codigo, Cliente.Nome, Cliente.Email, Cliente.Cpf, Cliente.Rg, Cliente.Cnpj, Cliente.RazaoSocial, "
				+ "Cliente.InscricaoEstadual, Cliente.Logradouro, Cliente.Bairro, Cliente.Numero, Cliente.Complemento, Cliente.Municipio, "
				+ "Cliente.Cep, Cliente.Uf, Cliente.Pais, Cliente.Ddd, Cliente.Telefone, Cliente.DataNascimento, Cliente.Sexo, "
				+ "Cliente.DataUltimaCompra, Cliente.Pessoa, Cliente.Ddd, Cliente.Telefone, Cliente.Senha, Cliente.InformacoesReferencia, "
				+ "Cliente.Ddd[2] AS Ddd2, Cliente.Telefone[2] AS Telefone2 FROM Cliente "
				+ "WHERE LOWER(Cliente.Email) = '" + email + "' ORDER BY Cliente.Codigo ASC FETCH FIRST 1 ROW ONLY";
		System.out.println(sql);
		ResultSet rs = this.sttm.executeQuery(sql);
		rs.last();
		int numeroRegistros = rs.getRow();
		rs.beforeFirst();
		if (numeroRegistros == 1) {
			while (rs.next()) {
				c.setCodigoCliente(Long.valueOf(rs.getLong("Codigo")));
				c.setNome(rs.getString("Nome"));
				c.setDataNascimento(rs.getString("DataNascimento"));
				c.setCpf(rs.getString("Cpf"));
				c.setRg(rs.getString("Rg"));
				c.setRazaoSocial(rs.getString("RazaoSocial"));
				c.setCnpj(rs.getString("Cnpj"));
				c.setInscricaoEstadual(rs.getString("InscricaoEstadual"));
				c.setEmail(rs.getString("Email"));
				c.setCep(rs.getString("Cep"));
				c.setLogradouro(rs.getString("Logradouro"));
				c.setNumero(rs.getString("Numero"));
				c.setComplemento(rs.getString("Complemento"));
				c.setBairro(rs.getString("Bairro"));
				c.setMunicipio(rs.getString("Municipio"));
				c.setUf(rs.getString("Uf"));
				c.setInformacoesReferencia(rs.getString("InformacoesReferencia"));
				c.setDdd1(rs.getString("Ddd"));
				c.setTelefone1(rs.getString("Telefone"));
				c.setDdd2(rs.getString("Ddd2"));
				c.setTelefone2(rs.getString("Telefone2"));
				c.setSexoCliente(rs.getString("Sexo"));
				c.setDataUltimaCompraCliente(rs.getString("DataUltimaCompra"));
				c.setSenhaCliente(rs.getString("Senha"));
				c.setPessoa(Long.valueOf(rs.getLong("Pessoa")));
				retorno.setCodStatus(Long.valueOf(1));
				retorno.setMsg("Email Já Cadastrado!");
				retorno.setModel(c);
			}
		} else if (numeroRegistros < 1) {
			retorno.setCodStatus(Long.valueOf(2));
			retorno.setMsg("Nenhum registro cadastrado!");
			retorno.setModel(null);
		}
		rs.close();
		return retorno;
	}

	public RetornoWS<String> searchEmailNewsletter(String email) throws SQLException {
		RetornoWS<String> retorno = new RetornoWS<String>();
		String sql = "SELECT Newsletter.Codigo FROM Newsletter WHERE Newsletter.Email = '" + email + "'";
		System.out.println(sql);
		ResultSet rs = this.sttm.executeQuery(sql);
		rs.last();
		int numeroRegistros = rs.getRow();
		if (numeroRegistros >= 1) {
			retorno.setCodStatus(Long.valueOf(2));
			retorno.setMsg("Já existe um usuário cadastrado com esse e-mail.");
			retorno.setModel(null);
		} else {
			retorno.setCodStatus(Long.valueOf(1));
			retorno.setMsg("Nenhum registro cadastrado!");
			retorno.setModel(null);
		}
		rs.close();
		return retorno;
	}

	public void insertNewsletter(String email) throws SQLException {
		String sql = "INSERT INTO Newsletter (Email) VALUES ('" + email + "')";
		System.out.println(sql);
		this.sttm.execute(sql);
	}

	public RetornoWS<Cliente> searchCodigo(Long codigo) throws SQLException {
		RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
		Cliente c = new Cliente();
		String sql = "SELECT Cliente.Codigo, Cliente.Nome, Cliente.Email, Cliente.Cpf, Cliente.Rg, Cliente.Cnpj, Cliente.RazaoSocial, Cliente.InscricaoEstadual, Cliente.Logradouro, Cliente.Bairro, Cliente.Numero, Cliente.Complemento, Cliente.Municipio, Cliente.Cep, Cliente.Uf, Cliente.Pais, Cliente.Ddd, Cliente.Telefone, Cliente.DataNascimento, Cliente.Sexo, Cliente.DataUltimaCompra, Cliente.Pessoa, Cliente.Ddd, Cliente.Telefone, Cliente.Senha, Cliente.InformacoesReferencia, Cliente.Ddd[2] AS Ddd2, Cliente.Telefone[2] AS Telefone2 FROM Cliente WHERE Cliente.Codigo = "
				+ codigo;
		System.out.println(sql);
		ResultSet rs = this.sttm.executeQuery(sql);
		while (rs.next()) {
			c.setCodigoCliente(Long.valueOf(rs.getLong("Codigo")));
			c.setNome(rs.getString("Nome"));
			c.setDataNascimento(rs.getString("DataNascimento"));
			c.setCpf(rs.getString("Cpf"));
			c.setRg(rs.getString("Rg"));
			c.setRazaoSocial(rs.getString("RazaoSocial"));
			c.setCnpj(rs.getString("Cnpj"));
			c.setInscricaoEstadual(rs.getString("InscricaoEstadual"));
			c.setEmail(rs.getString("Email"));
			c.setCep(rs.getString("Cep"));
			c.setLogradouro(rs.getString("Logradouro"));
			c.setNumero(rs.getString("Numero"));
			c.setComplemento(rs.getString("Complemento"));
			c.setBairro(rs.getString("Bairro"));
			c.setMunicipio(rs.getString("Municipio"));
			c.setUf(rs.getString("Uf"));
			c.setInformacoesReferencia(rs.getString("InformacoesReferencia"));
			c.setDdd1(rs.getString("Ddd"));
			c.setTelefone1(rs.getString("Telefone"));
			c.setDdd2(rs.getString("Ddd2"));
			c.setTelefone2(rs.getString("Telefone2"));
			c.setSexoCliente(rs.getString("Sexo"));
			c.setDataUltimaCompraCliente(rs.getString("DataUltimaCompra"));
			c.setSenhaCliente(rs.getString("Senha"));
			c.setPessoa(Long.valueOf(rs.getLong("Pessoa")));
			retorno.setCodStatus(Long.valueOf(1));
			retorno.setMsg("Email J\u00e1 Cadastrado!");
			retorno.setModel(c);
		}
		return retorno;
	}
}