package com.craniodatecnologia.base2;
import android.content.*;
import java.util.*;
import android.database.*;

public class RepositorioClientes
{
	
	DatabaseClientes databaseClientes;

	public RepositorioClientes(Context context) {
		databaseClientes = new DatabaseClientes(context);
	}

	public void Salvar(ListaClientes listaClientes) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("razao_social", listaClientes.getRazaoSocial());
		contentValues.put("nome_fantasia", listaClientes.getNomeFantasia());

		databaseClientes.GetConexaoDatabase().insert("tb_clientes", null, contentValues);
	}

	public void Atualizar(ListaClientes listaClientes) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("ds_item", listaClientes.getRazaoSocial());
		contentValues.put("ds_quantidade", listaClientes.getNomeFantasia());

		databaseClientes.GetConexaoDatabase().update("tb_pedido", contentValues, "id_pedido = ?", new String[] { Integer.toString(listaClientes.getCodigo())});
	}

	public Integer Excluir(int codigo) {
		return databaseClientes.GetConexaoDatabase().delete("tb_pedido", "id_pedido = ?", new String[] { Integer.toString(codigo) });
	}

	public ListaClientes GetPedido(int codigo) {

		Cursor cursor = databaseClientes.GetConexaoDatabase().rawQuery("SELECT * FROM tb_pedido WHERE id_pedido = " + codigo, null);
		cursor.moveToFirst();

		ListaClientes listaClientes = new ListaClientes();
		listaClientes.setCodigo(cursor.getInt(cursor.getColumnIndex("id_pedido")));
		listaClientes.setRazaoSocial(cursor.getString(cursor.getColumnIndex("ds_item")));
		listaClientes.setNomeFantasia(cursor.getString(cursor.getColumnIndex("ds_quantidade")));

		return listaClientes;
	}

	public List<ListaClientes> SelecionarTodos() {
		List<ListaClientes> pedidos = new ArrayList<ListaClientes>();

		StringBuilder stringBuilderQuery = new StringBuilder();
		stringBuilderQuery.append(" SELECT id_pedido, ");
		stringBuilderQuery.append(" ds_item, ");
		stringBuilderQuery.append(" ds_quantidade, ");
		stringBuilderQuery.append(" fl_valor ");
		stringBuilderQuery.append(" FROM tb_pedido ");
		stringBuilderQuery.append(" ORDER BY id_pedido ");

		Cursor cursor = databaseClientes.GetConexaoDatabase().rawQuery(stringBuilderQuery.toString(), null);
		cursor.moveToFirst();

		ListaClientes listaClientes;

		while (!cursor.isAfterLast()) {
			listaClientes = new ListaClientes();

			listaClientes.setCodigo(cursor.getInt(cursor.getColumnIndex("id_pedido")));
			listaClientes.setRazaoSocial(cursor.getString(cursor.getColumnIndex("ds_item")));
			listaClientes.setNomeFantasia(cursor.getString(cursor.getColumnIndex("ds_quantidade")));

			pedidos.add(listaClientes);

			cursor.moveToNext();
		}

		return pedidos;
	}
}
