package com.craniodatecnologia.base2.repositorio;
import android.content.*;
import java.util.*;
import android.database.*;
import com.craniodatecnologia.base2.*;
import com.craniodatecnologia.base2.util.*;
import com.craniodatecnologia.base2.models.*;

public class RepositorioClientes
{
	
	BaseDeDados databaseClientes;

	public RepositorioClientes(Context context) {
		databaseClientes = new BaseDeDados(context);
	}

	public void Salvar(ListaClientes listaClientes) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("razao_social", listaClientes.getRazaoSocial());
		contentValues.put("nome_fantasia", listaClientes.getNomeFantasia());
		contentValues.put("telefone", listaClientes.getTelefone());
		contentValues.put("telefone_comercial", listaClientes.getTelefoneComercial());
		contentValues.put("celular", listaClientes.getCelular());
		contentValues.put("contato", listaClientes.getContato());
		contentValues.put("email", listaClientes.getEmail());
		contentValues.put("cpf", listaClientes.getCpf());
		contentValues.put("rg", listaClientes.getRg());
		contentValues.put("endereco", listaClientes.getEndereco());
		contentValues.put("bairro", listaClientes.getBairro());
		contentValues.put("cep", listaClientes.getCep());
		contentValues.put("cidade", listaClientes.getCidade());
		contentValues.put("uf", listaClientes.getUf());
		contentValues.put("observacoes", listaClientes.getObservacoes());
		
		databaseClientes.getConexaoDatabase().insert("tb_clientes", null, contentValues);
	}

	public void Atualizar(ListaClientes listaClientes) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("razao_social", listaClientes.getRazaoSocial());
		contentValues.put("nome_fantasia", listaClientes.getNomeFantasia());
		contentValues.put("telefone", listaClientes.getTelefone());
		contentValues.put("telefone_comercial", listaClientes.getTelefoneComercial());
		contentValues.put("celular", listaClientes.getCelular());
		contentValues.put("contato", listaClientes.getContato());
		contentValues.put("email", listaClientes.getEmail());
		contentValues.put("cpf", listaClientes.getCpf());
		contentValues.put("rg", listaClientes.getRg());
		contentValues.put("endereco", listaClientes.getEndereco());
		contentValues.put("bairro", listaClientes.getBairro());
		contentValues.put("cep", listaClientes.getCep());
		contentValues.put("cidade", listaClientes.getCidade());
		contentValues.put("uf", listaClientes.getUf());
		contentValues.put("observacoes", listaClientes.getObservacoes());
		
		databaseClientes.getConexaoDatabase().update("tb_clientes", contentValues, "codigo = ?", new String[] { Integer.toString(listaClientes.getCodigo())});
	}

	public Integer Excluir(int codigo) {
		return databaseClientes.getConexaoDatabase().delete("tb_clientes", "codigo = ?", new String[] { Integer.toString(codigo) });
	}

	public ListaClientes getCodigo(int codigo) {

		Cursor cursor = databaseClientes.getConexaoDatabase().rawQuery("SELECT * FROM tb_clientes WHERE codigo = " + codigo, null);
		cursor.moveToFirst();

		ListaClientes listaClientes = new ListaClientes();
		listaClientes.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
		listaClientes.setRazaoSocial(cursor.getString(cursor.getColumnIndex("razao_social")));
		listaClientes.setNomeFantasia(cursor.getString(cursor.getColumnIndex("nome_fantasia")));

		return listaClientes;
	}

	public List<ListaClientes> selecionarTodos() {
		List<ListaClientes> clientes = new ArrayList<ListaClientes>();

		StringBuilder stringBuilderQuery = new StringBuilder();
		stringBuilderQuery.append(" SELECT codigo, ");
		stringBuilderQuery.append(" razao_social, ");
		stringBuilderQuery.append(" nome_fantasia ");
		stringBuilderQuery.append(" FROM tb_clientes ");
		stringBuilderQuery.append(" ORDER BY codigo ");

		Cursor cursor = databaseClientes.getConexaoDatabase().rawQuery(stringBuilderQuery.toString(), null);
		cursor.moveToFirst();

		ListaClientes listaClientes;

		while (!cursor.isAfterLast()) {
			listaClientes = new ListaClientes();

			listaClientes.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
			listaClientes.setRazaoSocial(cursor.getString(cursor.getColumnIndex("razao_social")));
			listaClientes.setNomeFantasia(cursor.getString(cursor.getColumnIndex("nome_fantasia")));

			clientes.add(listaClientes);

			cursor.moveToNext();
		}

		return clientes;
	}
}
