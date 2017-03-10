package com.ibolt.services;

import com.ibolt.models.ItemPedido;
import com.ibolt.models.RetornoWS;
import com.ibolt.services.ControlServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoServices extends ControlServices {
    public void deleteAllItemsPedido(Long codigoPedido) throws SQLException {
        String sql = "DELETE FROM PedidoProdutoGrade WHERE PedidoProdutoGrade.CodigoPedido = " + codigoPedido;
        System.out.println(sql);
        this.sttm.execute(sql);
    }

    public RetornoWS<ItemPedido> insertItemPedido(ItemPedido ip) throws SQLException {
        RetornoWS<ItemPedido> retorno = new RetornoWS<ItemPedido>();
        try {
			removeCaracteres(ip);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
        String sql = "INSERT INTO PedidoProdutoGrade(CodigoPedido,CodigoProdutoGrade,Quantidade,ValorUnitario)VALUES(" + ip.getCodigoPedido() + ",'" + ip.getCodigoProdutoGrade() + "'" + "," + ip.getQuantidade() + "," + ip.getValorUnitario() + ")";
        System.out.println(sql);
        this.sttm.execute(sql, 1);
        ResultSet rs = this.sttm.getGeneratedKeys();
        while (rs.next()) {
            System.out.println("Código gerado: " + rs.getLong(1));
            ip.setCodigo(Long.valueOf(rs.getLong(1)));
            retorno.setCodStatus(Long.valueOf(1));
            retorno.setMsg("Item do Pedido inserido com sucesso");
            retorno.setModel(ip);
        }
        rs.close();
        return retorno;
    }

    public RetornoWS<List<ItemPedido>> getItemsForCodigoPedido(Long codigoPedido) throws SQLException {
        RetornoWS<List<ItemPedido>> retorno = new RetornoWS<List<ItemPedido>>();
        String sql = "SELECT PedidoProdutoGrade.CodigoPedido, PedidoProdutoGrade.CodigoProdutoGrade,  PedidoProdutoGrade.Descricao, PedidoProdutoGrade.Quantidade, PedidoProdutoGrade.ValorUnitario,  ProdutoGrade.Descricao AS DescricaoPG FROM PedidoProdutoGrade  LEFT JOIN ProdutoGrade ON PedidoProdutoGrade.CodigoProdutoGrade = ProdutoGrade.CodigoProdutoGrade WHERE PedidoProdutoGrade.CodigoPedido = " + codigoPedido;
        System.out.println(sql);
        ResultSet rs = this.sttm.executeQuery(sql);
        ArrayList<ItemPedido> lstItem = new ArrayList<ItemPedido>();
        while (rs.next()) {
            ItemPedido ip = new ItemPedido();
            ip.setCodigoPedido(Long.valueOf(rs.getLong("CodigoPedido")));
            ip.setCodigoProdutoGrade(Long.valueOf(rs.getLong("CodigoProdutoGrade")));
            ip.setDescricao(rs.getString("DescricaoPG"));
            ip.setQuantidade(Long.valueOf(rs.getLong("Quantidade")));
            ip.setValorUnitario(Double.valueOf(rs.getDouble("ValorUnitario")));
            lstItem.add(ip);
        }
        retorno.setCodStatus(Long.valueOf(1));
        retorno.setMsg("Busca Realizada com Sucesso!");
        retorno.setModel(lstItem);
        rs.close();
        return retorno;
    }
}