package com.craniodatecnologia.base2;
import android.database.sqlite.*;
import android.content.*;

public class DatabaseClientes extends SQLiteOpenHelper
{

	private static final String NOME_BASE_DE_DADOS = "base.db";
	private static final int VERSAO_BASE_DE_DADOS = 1;

	public DatabaseClientes(Context context) {
		super(context, NOME_BASE_DE_DADOS, null, VERSAO_BASE_DE_DADOS);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		StringBuilder stringBuilderCreateTable = new StringBuilder();

		stringBuilderCreateTable.append(" CREATE TABLE tb_clientes (");
		stringBuilderCreateTable.append(" codigo INTEGER PRIMARY KEY AUTOINCREMENT, ");
		stringBuilderCreateTable.append(" razao_social TEXT NOT NULL, ");
		stringBuilderCreateTable.append(" nome_fantasia TEXT NOT NULL, ");
		stringBuilderCreateTable.append(" telefone TEXT NOT NULL, ");
		stringBuilderCreateTable.append(" telefone_comercial TEXT NOT NULL, ");
		stringBuilderCreateTable.append(" celular TEXT NOT NULL, ");
		stringBuilderCreateTable.append(" contato TEXT NOT NULL, ");
		stringBuilderCreateTable.append(" email TEXT NOT NULL, ");
		stringBuilderCreateTable.append(" cpf INTEGER NOT NULL, ");
		stringBuilderCreateTable.append(" rg INTEGER NOT NULL, ");
		stringBuilderCreateTable.append(" endereco TEXT NOT NULL, ");
		stringBuilderCreateTable.append(" bairro TEXT NOT NULL, ");
		stringBuilderCreateTable.append(" cep INTEGER NOT NULL, ");
		stringBuilderCreateTable.append(" ibge INTEGER NOT NULL, ");
		stringBuilderCreateTable.append(" cidade TEXT NOT NULL, ");
		stringBuilderCreateTable.append(" uf TEXT NOT NULL, ");
		stringBuilderCreateTable.append(" observacoes TEXT NOT NULL ) ");
		
		db.execSQL(" create index idx_clientes_razaosocial on tb_clientes(razao_social)");
		db.execSQL(" create index idx_clientes_nomefantasia on tb_clientes(nome_fantasia)");
		

		db.execSQL(stringBuilderCreateTable.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS tb_clientes");
		onCreate(db);
	}

	public SQLiteDatabase GetConexaoDatabase() {
		return this.getWritableDatabase();
	}

}

