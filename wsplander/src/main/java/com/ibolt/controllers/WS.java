
package com.ibolt.controllers;

import com.ibolt.models.Cliente;
import com.ibolt.models.ItemPedido;
import com.ibolt.models.Pedido;
import com.ibolt.models.PedidoPagamento;
import com.ibolt.models.RetornoWS;
import com.ibolt.services.ClienteService;
import com.ibolt.services.ItemPedidoServices;
import com.ibolt.services.LoginServices;
import com.ibolt.services.PedidoPagamentoServices;
import com.ibolt.services.PedidoServices;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path(value = "/")
public class WS {
	@POST
	@Path(value = "/novologin")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response novologin(Pedido p) {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("Pedido: " + (Object) p);
			LoginServices ls = new LoginServices();
			ItemPedidoServices ips = new ItemPedidoServices();
			RetornoWS<ItemPedido> retornoItem = new RetornoWS<ItemPedido>();
			try {
				ls.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados! " + e.getMessage());
				retorno.setModel((Object) null);
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Cliente> retornoCliente = new RetornoWS<Cliente>();
			try {
				retornoCliente = ls.loginCliente(p.getFkCliente().getEmail().toLowerCase(),
						p.getFkCliente().getSenhaCliente());
			} catch (SQLException e2) {
				System.out.println("Erro ao tentar logar: " + e2);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados! " + e2.getMessage());
				retorno.setModel((Object) null);
				e2.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			if (retornoCliente.getCodStatus() == 1) {
				p.getFkCliente().setCodigoCliente(((Cliente) retornoCliente.getModel()).getCodigoCliente());
				p.getFkCliente().setNome(((Cliente) retornoCliente.getModel()).getNome());
				p.getFkCliente().setCpf(((Cliente) retornoCliente.getModel()).getCpf());
				p.getFkCliente().setRg(((Cliente) retornoCliente.getModel()).getRg());
				p.getFkCliente().setRazaoSocial(((Cliente) retornoCliente.getModel()).getRazaoSocial());
				p.getFkCliente().setCnpj(((Cliente) retornoCliente.getModel()).getCnpj());
				p.getFkCliente().setPessoa(((Cliente) retornoCliente.getModel()).getPessoa());
				p.getFkCliente().setDataNascimento(((Cliente) retornoCliente.getModel()).getDataNascimento());
				p.getFkCliente().setInscricaoEstadual(((Cliente) retornoCliente.getModel()).getInscricaoEstadual());
				p.getFkCliente().setEmail(((Cliente) retornoCliente.getModel()).getEmail());
				p.getFkCliente().setCep(((Cliente) retornoCliente.getModel()).getCep());
				p.getFkCliente().setLogradouro(((Cliente) retornoCliente.getModel()).getLogradouro());
				p.getFkCliente().setNumero(((Cliente) retornoCliente.getModel()).getNumero());
				p.getFkCliente().setComplemento(((Cliente) retornoCliente.getModel()).getComplemento());
				p.getFkCliente().setBairro(((Cliente) retornoCliente.getModel()).getBairro());
				p.getFkCliente().setMunicipio(((Cliente) retornoCliente.getModel()).getMunicipio());
				p.getFkCliente().setUf(((Cliente) retornoCliente.getModel()).getUf());
				p.getFkCliente().setDdd1(((Cliente) retornoCliente.getModel()).getDdd1());
				p.getFkCliente().setDdd2(((Cliente) retornoCliente.getModel()).getDdd2());
				p.getFkCliente().setTelefone1(((Cliente) retornoCliente.getModel()).getTelefone1());
				p.getFkCliente().setTelefone2(((Cliente) retornoCliente.getModel()).getTelefone2());
				p.getFkCliente()
						.setInformacoesReferencia(((Cliente) retornoCliente.getModel()).getInformacoesReferencia());
				p.setCodigoCliente(p.getFkCliente().getCodigoCliente());
				p.setClientePessoa(p.getFkCliente().getPessoa().toString());
				p.setEntregaNome(p.getFkCliente().getNome());
				p.setEntregaRua(p.getFkCliente().getLogradouro());
				p.setEntregaNumero(p.getFkCliente().getNumero());
				p.setEntregaComplemento(p.getFkCliente().getComplemento());
				p.setEntregaBairro(p.getFkCliente().getBairro());
				p.setEntregaMunicipio(p.getFkCliente().getMunicipio());
				p.setEntregaUf(p.getFkCliente().getUf());
				p.setEntregaCep(p.getFkCliente().getCep());
				PedidoServices ps = new PedidoServices();
				ps.setSttm(ls.getSttm());
				RetornoWS<Pedido> retornoPedido = new RetornoWS<Pedido>();
				try {
					retornoPedido = ps.insertPedido(p);
					((Pedido) retornoPedido.getModel())
							.setCodigoPedido(ps.getPedidoForId(((Pedido) retornoPedido.getModel()).getCodigoPedido()));
					p.setCodigoPedido(((Pedido) retornoPedido.getModel()).getCodigoPedido());
					if (retornoPedido.getCodStatus() == 1) {
						ips.setSttm(ls.getSttm());
						int i = 0;
						while (i < p.getLstItems().size()) {
							((ItemPedido) p.getLstItems().get(i)).setCodigoPedido(p.getCodigoPedido());
							retornoItem = ips.insertItemPedido((ItemPedido) p.getLstItems().get(i));
							if (retornoItem.getCodStatus() != 1) {
								ips.deleteAllItemsPedido(p.getCodigoPedido());
								ps.invalidarPedido(p, retornoItem.getMsg());
								ls.CloseConnection();
								return Response.ok((Object) retornoItem).build();
							}
							++i;
						}
						ls.CloseConnection();
						System.out.println("Retorno WS: " + retornoPedido.getModel());
						return Response.ok((Object) retornoPedido).build();
					}
					ls.CloseConnection();
					return Response.ok((Object) retornoPedido).build();
				} catch (SQLException e) {
					try {
						ips.deleteAllItemsPedido(((Pedido) retornoPedido.getModel()).getCodigoPedido());
						ps.invalidarPedido((Pedido) retornoPedido.getModel(), e.getMessage());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					System.out.println("Falha ao inserir dados no banco: " + e);
					RetornoWS<Object> retorno = new RetornoWS<Object>();
					retorno.setCodStatus(Long.valueOf(4));
					retorno.setMsg("Não foi possível acessar o banco de dados! " + e.getMessage());
					retorno.setModel((Object) null);
					return Response.ok((Object) retorno).build();
				}
			}
			ls.CloseConnection();
			return Response.ok((Object) retornoCliente).build();
		} else {
			return Response.status(404).build();
		}

	}

	@POST
	@Path(value = "/novocliente")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response novocliente(Pedido p) {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("Pedido: " + (Object) p);
			PedidoServices ps = new PedidoServices();
			ItemPedidoServices ips = new ItemPedidoServices();
			RetornoWS<ItemPedido> retornoItem = new RetornoWS<ItemPedido>();
			ips.setSttm(ps.getSttm());
			try {
				ps.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Pedido> retornoPedido = new RetornoWS<Pedido>();
			try {
				retornoPedido = ps.insertPedidoClienteNovo(p);
				((Pedido) retornoPedido.getModel())
						.setCodigoPedido(ps.getPedidoForId(((Pedido) retornoPedido.getModel()).getCodigoPedido()));
				if (retornoPedido.getCodStatus() == 1) {
					ips.setSttm(ps.getSttm());
					int i = 0;
					while (i < p.getLstItems().size()) {
						((ItemPedido) p.getLstItems().get(i)).setCodigoPedido(p.getCodigoPedido());
						retornoItem = ips.insertItemPedido((ItemPedido) p.getLstItems().get(i));
						if (retornoItem.getCodStatus() != 1) {
							ips.deleteAllItemsPedido(p.getCodigoPedido());
							ps.invalidarPedido(p, retornoItem.getMsg());
							ps.CloseConnection();
							return Response.ok((Object) retornoItem).build();
						}
						++i;
					}
					System.out.println("RetornoPedido: " + (Object) retornoPedido);
					ps.CloseConnection();
					return Response.ok((Object) retornoPedido).build();
				}
				ps.CloseConnection();
				return Response.ok((Object) retornoPedido).build();
			} catch (Exception e) {
				try {
					ips.deleteAllItemsPedido(((Pedido) retornoPedido.getModel()).getCodigoPedido());
					ps.invalidarPedido((Pedido) retornoPedido.getModel(), e.getMessage());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				ps.CloseConnection();
				System.out.println("Erro: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Erro ao criar pedido!" + e.getMessage());
				retorno.setModel((Object) null);
				return Response.ok((Object) retorno).build();
			}
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/updatePedidoFinalizacao")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response updateOrderFinally(Pedido p) {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("Pedido: " + (Object) p);
			PedidoServices ps = new PedidoServices();
			try {
				ps.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Pedido> retornoPedido = new RetornoWS<Pedido>();
			try {
				retornoPedido = ps.updatePedidoFinalizacao(p);
				if (retornoPedido.getCodStatus() == 1) {
					PedidoPagamentoServices pps = new PedidoPagamentoServices();
					pps.setSttm(ps.getSttm());
					RetornoWS<PedidoPagamento> retornoPP = new RetornoWS<PedidoPagamento>();
					retornoPP = pps.insertPedidoPagamento(p.getFkPagamento());
					if (retornoPP.getCodStatus() != 1) {
						ps.CloseConnection();
						return Response.ok((Object) retornoPP).build();
					}
				}
				ps.CloseConnection();
				return Response.ok((Object) retornoPedido).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Erro ao criar pedido!" + e.getMessage());
				retorno.setModel((Object) null);
				return Response.ok((Object) retorno).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/updateItems")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response updateItems(Pedido p) {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("Pedido: " + (Object) p);
			PedidoServices ps = new PedidoServices();
			RetornoWS<Pedido> retornoPedido = new RetornoWS<Pedido>();
			try {
				ps.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			try {
				retornoPedido = ps.limparItemsPedido(p);
				if (retornoPedido.getCodStatus() == 1) {
					ItemPedidoServices ips = new ItemPedidoServices();
					ips.setSttm(ps.getSttm());
					RetornoWS<ItemPedido> retornoItem = new RetornoWS<ItemPedido>();
					int i = 0;
					while (i < p.getLstItems().size()) {
						retornoItem = ips.insertItemPedido((ItemPedido) p.getLstItems().get(i));
						if (retornoItem.getCodStatus() != 1) {
							ips.deleteAllItemsPedido(p.getCodigoPedido());
							ps.CloseConnection();
							return Response.ok((Object) retornoItem).build();
						}
						++i;
					}
					ps.CloseConnection();
					retornoItem.setCodStatus(Long.valueOf(1));
					retornoItem.setMsg("Todos os itens atualizados com sucesso");
					retornoItem.setModel(null);
					return Response.ok((Object) retornoItem).build();
				}
				ps.CloseConnection();
				return Response.ok((Object) retornoPedido).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Erro ao criar pedido!" + e.getMessage());
				retorno.setModel((Object) null);
				return Response.ok((Object) retorno).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/login")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response login(@FormParam(value = "email") String email, @FormParam(value = "senha") String senha) {

		System.out.println("User: " + email + " -- Senha: " + senha);
		LoginServices ls = new LoginServices();
		try {
			ls.CreateConnection();
		} catch (Exception e) {
			System.out.println("Erro ao criar a conexão: " + e);
			RetornoWS<Object> retorno = new RetornoWS<Object>();
			retorno.setCodStatus(Long.valueOf(4));
			retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
			retorno.setModel((Object) null);
			e.printStackTrace();
			return Response.ok((Object) retorno).build();
		}
		RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
		try {
			retorno = ls.loginCliente(email, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ls.CloseConnection();
		System.out.println((Object) retorno);
		return Response.ok((Object) retorno).build();
	}

	@POST
	@Path(value = "/novopedido")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response novopedido(Pedido p) {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("Pedido: " + (Object) p);
			PedidoServices ps = new PedidoServices();
			try {
				ps.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
			try {
				retorno = ps.insertPedido(p);
				((Pedido) retorno.getModel())
						.setCodigoPedido(ps.getPedidoForId(((Pedido) retorno.getModel()).getCodigoPedido()));
				ps.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/getPedidoCodigo")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response getPedido(Pedido p) throws InterruptedException {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("BUSCAR PEDIDO POR CODIGO Pedido: " + (Object) p);
			PedidoServices ps = new PedidoServices();
			try {
				ps.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
			try {
				retorno = ps.getPedidoForCodigo(p.getCodigoPedido());
				ps.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao buscar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				ps.CloseConnection();
				System.out.println((Object) retornoE);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@GET
	@Path(value = "/getPedidoCodigo")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response getPedido(@QueryParam(value = "id") Long codigo) throws InterruptedException {
		System.out.println("BUSCAR PEDIDO POR CODIGO Pedido: " + codigo);
		PedidoServices ps = new PedidoServices();
		try {
			ps.CreateConnection();
		} catch (Exception e) {
			System.out.println("Erro ao criar a conexão: " + e);
			RetornoWS<Object> retorno = new RetornoWS<Object>();
			retorno.setCodStatus(Long.valueOf(4));
			retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
			retorno.setModel((Object) null);
			e.printStackTrace();
			return Response.ok((Object) retorno).build();
		}
		RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
		try {
			retorno = ps.getPedidoForCodigo(codigo);
			ps.CloseConnection();
			System.out.println((Object) retorno);
			return Response.ok((Object) retorno).build();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
			RetornoWS<Object> retornoE = new RetornoWS<Object>();
			retornoE.setCodStatus(Long.valueOf(4));
			retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
			retornoE.setModel((Object) null);
			return Response.ok((Object) retornoE).build();
		}
	}

	@POST
	@Path(value = "/getClienteCodigo")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response getCliente(Cliente c) {
		if ((c.getUsr().equals("pdroqtl")) && (c.getPwd().equals("jck9com*"))) {
			System.out.println("Cliente: " + (Object) c);
			ClienteService cs = new ClienteService();
			try {
				cs.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
			try {
				retorno = cs.getClienteForCodigo(c.getCodigoCliente());
				cs.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/getItemPorCodigoPedido")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response getItems(Pedido p) {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("Pedido: " + (Object) p);
			ItemPedidoServices ps = new ItemPedidoServices();
			try {
				ps.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<List<ItemPedido>> retorno = new RetornoWS<List<ItemPedido>>();
			try {
				retorno = ps.getItemsForCodigoPedido(p.getCodigoPedido());
				ps.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/itempedido")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response novoItemPedido(ItemPedido ip) {
		if ((ip.getUsr().equals("pdroqtl")) && (ip.getPwd().equals("jck9com*"))) {
			System.out.println("Item: " + (Object) ip);
			ItemPedidoServices ips = new ItemPedidoServices();
			try {
				ips.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<ItemPedido> retorno = new RetornoWS<ItemPedido>();
			try {
				retorno = ips.insertItemPedido(ip);
				ips.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/limparItensPedido")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response cleanOrder(Pedido p) {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("Pedido: " + (Object) p);
			PedidoServices ps = new PedidoServices();
			try {
				ps.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
			try {
				retorno = ps.limparItemsPedido(p);
				ps.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/atualizarEnderecoEntrega")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response updateAddressDelivery(Pedido p) {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("Pedido: " + (Object) p);
			PedidoServices ps = new PedidoServices();
			try {
				ps.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
			try {
				retorno = ps.updateDelivey(p);
				ps.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/atualizarPedidoFinalizacao")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response updateOrderConfirm(Pedido p) {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("Pedido: " + (Object) p);
			PedidoServices ps = new PedidoServices();
			try {
				ps.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
			try {
				retorno = ps.updatePedidoFinalizacao(p);
				ps.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/atualizarCliente")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response updateClient(Cliente c) {
		if ((c.getUsr().equals("pdroqtl")) && (c.getPwd().equals("jck9com*"))) {
			System.out.println("Cliente: " + (Object) c);
			ClienteService cs = new ClienteService();
			try {
				cs.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
			try {
				retorno = cs.updateCliente(c);
				cs.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/atualizarClienteEnderecoEntrega")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response updateClientAddressDelivery(Pedido p) {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("Pedido: " + (Object) p);
			ClienteService cs = new ClienteService();
			try {
				cs.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Cliente> retornoCliente = new RetornoWS<Cliente>();
			try {
				retornoCliente = cs.updateCliente(p.getFkCliente());
				PedidoServices ps = new PedidoServices();
				ps.setSttm(cs.getSttm());
				RetornoWS<Pedido> retornoPedido = new RetornoWS<Pedido>();
				retornoPedido = ps.updateDelivey(p);
				cs.CloseConnection();
				((Pedido) retornoPedido.getModel()).setFkCliente((Cliente) retornoCliente.getModel());
				System.out.println((Object) retornoPedido);
				return Response.ok((Object) retornoPedido).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/atualizarClienteNovo")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response updateNewClient(Pedido p) {
		if ((p.getUsr().equals("pdroqtl")) && (p.getPwd().equals("jck9com*"))) {
			System.out.println("Pedidoc: " + (Object) p);
			PedidoServices ps = new PedidoServices();
			try {
				ps.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Pedido> retorno = new RetornoWS<Pedido>();
			try {
				retorno = ps.updateClienteNovo(p);
				ps.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/atualizarSenhaCliente")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response updatePasswordClient(Cliente c) {
		if ((c.getUsr().equals("pdroqtl")) && (c.getPwd().equals("jck9com*"))) {
			System.out.println("Cliente: " + (Object) c);
			ClienteService cs = new ClienteService();
			try {
				cs.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
			try {
				retorno = cs.updateSenhaCliente(c);
				retorno = cs.searchCodigo(c.getCodigoCliente());
				cs.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/inserirPedidoPagamento")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response novoPedidoPagamento(PedidoPagamento pp) {
		if ((pp.getUsr().equals("pdroqtl")) && (pp.getPwd().equals("jck9com*"))) {
			System.out.println("PedidoPagamento: " + (Object) pp);
			PedidoPagamentoServices pps = new PedidoPagamentoServices();
			try {
				pps.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<PedidoPagamento> retorno = new RetornoWS<PedidoPagamento>();
			try {
				retorno = pps.insertPedidoPagamento(pp);
				pps.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}
	}

	@POST
	@Path(value = "/pesquisarEmailCliente")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response searchEmailClient(@FormParam(value = "email") String email, @FormParam(value = "usr") String usr,
			@FormParam(value = "pwd") String pwd) {
		if ((usr.equals("pdroqtl")) && (pwd.equals("jck9com*"))) {
			System.out.println("Email: " + email);
			ClienteService cs = new ClienteService();
			try {
				cs.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<Cliente> retorno = new RetornoWS<Cliente>();
			try {
				retorno = cs.searchEmail(email.toLowerCase());
				cs.CloseConnection();
				System.out.println((Object) retorno);
				return Response.ok((Object) retorno).build();
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(4));
				retornoE.setMsg("Erro ao criar pedido!" + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
		} else

		{
			return Response.status(404).build();
		}

	}

	@POST
	@Path(value = "/insereNewsletter")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response insertNewsletter(@FormParam(value = "email") String email, @FormParam(value = "usr") String usr,
			@FormParam(value = "pwd") String pwd) {
		if ((usr.equals("pdroqtl")) && (pwd.equals("jck9com*"))) {
			System.out.println("Email Newsletter: " + email);
			ClienteService cs = new ClienteService();
			try {
				cs.CreateConnection();
			} catch (Exception e) {
				System.out.println("Erro ao criar a conexão: " + e);
				RetornoWS<Object> retorno = new RetornoWS<Object>();
				retorno.setCodStatus(Long.valueOf(4));
				retorno.setMsg("Não foi possível acessar o banco de dados!" + e.getMessage());
				retorno.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retorno).build();
			}
			RetornoWS<String> retorno = new RetornoWS<String>();
			try {
				retorno = cs.searchEmailNewsletter(email);
				if (retorno.getCodStatus() != 1) {
					cs.CloseConnection();
					System.out.println((Object) retorno);
					return Response.ok((Object) retorno).build();
				}
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(3));
				retornoE.setMsg("Erro ao verificar email! " + e.getMessage());
				retornoE.setModel((Object) null);
				return Response.ok((Object) retornoE).build();
			}
			try {
				cs.insertNewsletter(email);
				retorno.setCodStatus(Long.valueOf(1));
				retorno.setMsg("Cadastro realizado.");
				retorno.setModel(null);
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
				RetornoWS<Object> retornoE = new RetornoWS<Object>();
				retornoE.setCodStatus(Long.valueOf(3));
				retornoE.setMsg("Erro ao cadastrar newsletter! " + e.getMessage());
				retornoE.setModel((Object) null);
				e.printStackTrace();
				return Response.ok((Object) retornoE).build();
			}
			System.out.println((Object) retorno);
			return Response.ok((Object) retorno).build();
		} else

		{
			return Response.status(404).build();
		}
	}

	@GET
	@Path(value = "/testeWS")
	@Produces(value = { "application/json; charset=UTF-8" })
	public Response TesteWs(@QueryParam(value = "texto") String texto) throws InterruptedException {
		System.out.println("Texto: " + texto);
		RetornoWS<String> retorno = new RetornoWS<String>();
		retorno.setCodStatus(Long.valueOf(1));
		retorno.setMsg("WS OK");
		retorno.setModel(texto);
		System.out.println((Object) retorno);
		return Response.ok((Object) retorno).build();
	}
}