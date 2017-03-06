package com.ibolt.services;

import com.ibolt.models.Cliente;
import com.ibolt.models.RetornoWS;
import com.ibolt.services.ControlServices;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServices
extends ControlServices {
    public RetornoWS<Cliente> loginCliente(String email, String senha, Cliente c) throws SQLException, Exception {
        RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
        String sql =  "SELECT Cliente.Codigo, Cliente.Nome, Cliente.Email, Cliente.Cpf, Cliente.Rg, Cliente.Cnpj, "
        			+ "Cliente.RazaoSocial, Cliente.InscricaoEstadual, Cliente.Logradouro, Cliente.Bairro, Cliente.Numero, "
        			+ "Cliente.Complemento, Cliente.Municipio, Cliente.MunicipioCodigo, Cliente.Cep, Cliente.Uf, "
        			+ "Cliente.Pais, Cliente.PaisCodigo, Cliente.Ddd, Cliente.Telefone, Cliente.DataNascimento, Cliente.Sexo, "
        			+ "Cliente.DataUltimaCompra, Cliente.Pessoa FROM Cliente "
        				+ "WHERE LOWER(Cliente.Email) = '" + email + "' AND Cliente.Senha = '" + senha + "' ORDER BY Cliente.Codigo ASC FETCH FIRST 1 ROW ONLY";
        
        
        ResultSet rs = this.sttm.executeQuery(sql);
        rs.last();
        int numeroRegistros = rs.getRow();
        rs.beforeFirst();
//        System.out.println("Encontrou: " + numeroRegistros);
        if (numeroRegistros == 1) {
            while (rs.next()) {
                int inicio;
//                Cliente c = new Cliente();
                c.setCodigoCliente(Long.valueOf(rs.getLong("Codigo")));
                c.setNome(rs.getString("Nome"));
                c.setEmail(rs.getString("Email"));
                c.setCpf(rs.getString("Cpf"));
                c.setRg(rs.getString("Rg"));
                c.setCnpj(rs.getString("Cnpj"));
                c.setRazaoSocial(rs.getString("RazaoSocial"));
                c.setInscricaoEstadual(rs.getString("InscricaoEstadual"));
                c.setLogradouro(rs.getString("Logradouro"));
                c.setBairro(rs.getString("Bairro"));
                c.setNumero(rs.getString("Numero"));
                c.setComplemento(rs.getString("Complemento"));
                c.setMunicipio(rs.getString("Municipio"));
                c.setCodigoMunicipioCliente(rs.getString("MunicipioCodigo"));
                c.setCep(rs.getString("Cep"));
                c.setUf(rs.getString("Uf"));
                c.setPaisCliente(rs.getString("Pais"));
                c.setCodigoPaisCliente(rs.getString("PaisCodigo"));
                c.setDdd1(rs.getString("Ddd"));
                c.setTelefone1(rs.getString("Telefone"));
                c.setDataNascimento(rs.getString("DataNascimento"));
                c.setSexoCliente(rs.getString("Sexo"));
                c.setDataUltimaCompraCliente(rs.getString("DataUltimaCompra"));
                c.setPessoa(Long.valueOf(rs.getLong("Pessoa")));
                int limite = c.getCpf() != null && c.getCpf() != "" ? c.getCpf().length() : c.getCnpj().length();
                int i = inicio = c.getCpf() != null && c.getCpf() != "" ? 11 : 14;
                while (i > limite) {
                    if (c.getCpf() != null && c.getCpf() != "") {
                        c.setCpf("0" + c.getCpf());
                    } else {
                        c.setCnpj("0" + c.getCnpj());
                    }
                    --i;
                }
                limite = c.getCep().length();
                i = inicio = 8;
                while (i > limite) {
                    c.setCep("0" + c.getCep());
                    --i;
                }
                retorno.setModel(c);
                retorno.setCodStatus(Long.valueOf(1));
                retorno.setMsg("Usuário Encontrado");
            }
        } else if (numeroRegistros > 1) {
//        	System.out.println("Preparando retorno...");
            retorno.setCodStatus(Long.valueOf(2));
            retorno.setMsg("Há mais de um usuário com este email cadastrado! Contate o administrador do sistema.");
            retorno.setModel(null);
        } else {
            retorno.setCodStatus(Long.valueOf(2));
            retorno.setMsg("Usuário ou senha inválido! Tente novamente.");
            retorno.setModel(null);
        }
        rs.close();
        return retorno;
    }
}