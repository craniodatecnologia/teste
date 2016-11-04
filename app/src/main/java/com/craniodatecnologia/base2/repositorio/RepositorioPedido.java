package com.craniodatecnologia.base2.repositorio;
import com.craniodatecnologia.base2.util.*;
import android.content.*;
import android.database.*;
import java.util.*;
import com.craniodatecnologia.base2.models.*;

public class RepositorioPedido
{

	BaseDeDados databaseUtil;

	public RepositorioPedido(Context context) {
		databaseUtil = new BaseDeDados(context);
	}

	public void salvar(PedidoModel pedidoModel) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("item", pedidoModel.getItem());
		contentValues.put("quantidade", pedidoModel.getQuantidade());
		contentValues.put("valor", pedidoModel.getValor());

		databaseUtil.getConexaoDatabase().insert("tb_pedido", null, contentValues);
	}

	public void Atualizar(PedidoModel pedidoModel) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("item", pedidoModel.getItem());
		contentValues.put("quantidade", pedidoModel.getQuantidade());
		contentValues.put("valor", pedidoModel.getValor());

		databaseUtil.getConexaoDatabase().update("tb_pedido", contentValues, "codigo = ?", new String[] { Integer.toString(pedidoModel.getCodigo())});
	}

	public Integer Excluir(int codigo) {
		return databaseUtil.getConexaoDatabase().delete("tb_pedido", "codigo = ?", new String[] { Integer.toString(codigo) });
	}

	public PedidoModel GetPedido(int codigo) {

		Cursor cursor = databaseUtil.getConexaoDatabase().rawQuery("SELECT * FROM tb_pedido WHERE codigo = " + codigo, null);
		cursor.moveToFirst();

		PedidoModel pedidoModel = new PedidoModel();
		pedidoModel.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
		pedidoModel.setItem(cursor.getString(cursor.getColumnIndex("item")));
		pedidoModel.setQuantidade(cursor.getString(cursor.getColumnIndex("quantidade")));
		pedidoModel.setValor(cursor.getString(cursor.getColumnIndex("valor")));

		return pedidoModel;
	}

	public List<PedidoModel> SelecionarTodos() {
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();

		StringBuilder stringBuilderQuery = new StringBuilder();
		stringBuilderQuery.append(" SELECT codigo, ");
		stringBuilderQuery.append(" item, ");
		stringBuilderQuery.append(" quantidade, ");
		stringBuilderQuery.append(" valor ");
		stringBuilderQuery.append(" FROM tb_pedido ");
		stringBuilderQuery.append(" ORDER BY codigo ");

		Cursor cursor = databaseUtil.getConexaoDatabase().rawQuery(stringBuilderQuery.toString(), null);
		cursor.moveToFirst();

		PedidoModel pedidoModel;

		while (!cursor.isAfterLast()) {
			pedidoModel = new PedidoModel();

			pedidoModel.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
			pedidoModel.setItem(cursor.getString(cursor.getColumnIndex("item")));
			pedidoModel.setQuantidade(cursor.getString(cursor.getColumnIndex("quantidade")));
			pedidoModel.setValor(cursor.getString(cursor.getColumnIndex("valor")));

			pedidos.add(pedidoModel);

			cursor.moveToNext();
		}

		return pedidos;
	}
}

