package com.craniodatecnologia.base2.repositorio;
import com.craniodatecnologia.base2.util.*;
import android.content.*;
import com.craniodatecnologia.base2.models.*;
import android.database.*;
import java.util.*;

public class RepositorioProdutosEscolhidos
{

	BaseDeDados database;

	public RepositorioProdutosEscolhidos(Context context) {
		database = new BaseDeDados(context);
	}

	public void Salvar(EscolherProdutosModels listaProdutos) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("referencia", listaProdutos.getReferencia());
		contentValues.put("descricao", listaProdutos.getDescricao());
		contentValues.put("tamanho", listaProdutos.getTamanho());
		contentValues.put("ncm", listaProdutos.getNcm());
		contentValues.put("preco", listaProdutos.getPreco());
		contentValues.put("observacoes", listaProdutos.getObservacoes());

		database.getConexaoDatabase().insert("tb_produtos", null, contentValues);
	}

	public void Atualizar(EscolherProdutosModels listaProdutos) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("referencia", listaProdutos.getReferencia());
		contentValues.put("descricao", listaProdutos.getDescricao());
		contentValues.put("tamanho", listaProdutos.getTamanho());
		contentValues.put("ncm", listaProdutos.getNcm());
		contentValues.put("preco", listaProdutos.getPreco());
		contentValues.put("observacoes", listaProdutos.getObservacoes());

		database.getConexaoDatabase().update("tb_produtos", contentValues, "codigo = ?", new String[] { Integer.toString(listaProdutos.getCodigo())});
	}

	public Integer Excluir(int codigo) {
		return database.getConexaoDatabase().delete("tb_produtos", "codigo = ?", new String[] { Integer.toString(codigo) });
	}

	public EscolherProdutosModels getCodigo(int codigo) {

		Cursor cursor = database.getConexaoDatabase().rawQuery("SELECT * FROM tb_produtos WHERE codigo = " + codigo, null);
		cursor.moveToFirst();

		EscolherProdutosModels listaProdutos = new EscolherProdutosModels();
		listaProdutos.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
		listaProdutos.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
		listaProdutos.setPreco(cursor.getString(cursor.getColumnIndex("preco")));

		return listaProdutos;
	}

	public List<EscolherProdutosModels> selecionarTodos() {
		List<EscolherProdutosModels> produtos = new ArrayList<EscolherProdutosModels>();

		StringBuilder stringBuilderQuery = new StringBuilder();
		stringBuilderQuery.append(" SELECT codigo, ");
		stringBuilderQuery.append(" descricao, ");
		stringBuilderQuery.append(" preco ");
		stringBuilderQuery.append(" FROM tb_produtos ");
		stringBuilderQuery.append(" ORDER BY codigo ");

		Cursor cursor = database.getConexaoDatabase().rawQuery(stringBuilderQuery.toString(), null);
		cursor.moveToFirst();

		EscolherProdutosModels listaProdutos;

		while (!cursor.isAfterLast()) {
			listaProdutos = new EscolherProdutosModels();

			listaProdutos.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
			listaProdutos.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
			listaProdutos.setPreco(cursor.getString(cursor.getColumnIndex("preco")));

			produtos.add(listaProdutos);

			cursor.moveToNext();
		}

		return produtos;
	}
}
