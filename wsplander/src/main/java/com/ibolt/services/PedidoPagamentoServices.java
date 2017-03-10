package com.ibolt.services;

import com.ibolt.models.PedidoPagamento;
import com.ibolt.models.RetornoWS;
import com.ibolt.services.ControlServices;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoPagamentoServices extends ControlServices {
	public RetornoWS<PedidoPagamento> insertPedidoPagamento(PedidoPagamento pp) throws SQLException {
		RetornoWS<PedidoPagamento> retorno = new RetornoWS<PedidoPagamento>();
		try {
			removeCaracteres(pp);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO PedidoPagamento(CodigoPedido,CodigoFormaPagamento,Data,Parcelas,Valor)VALUES("
				+ pp.getCodigoPedido() + "," + pp.getCodigoFormaPagamento() + ",DATE '" + pp.getData() + "'" + ","
				+ pp.getParcelas() + "," + pp.getValor() + ")";
		System.out.println(sql);
		this.sttm.execute(sql, 1);
		ResultSet rs = this.sttm.getGeneratedKeys();
		while (rs.next()) {
			pp.setCodigo(Long.valueOf(rs.getLong(1)));
			retorno.setCodStatus(Long.valueOf(1));
			retorno.setMsg("Pedido Pagamento inserido com sucesso");
			retorno.setModel(pp);
		}
		rs.close();
		return retorno;
	}
}