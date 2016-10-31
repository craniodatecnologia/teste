package com.craniodatecnologia.base2.util;
import android.database.sqlite.*;
import android.content.*;
import java.util.*;
import android.database.*;

public class BaseDeDados extends SQLiteOpenHelper
{

	private static final String NOME_BASE_DE_DADOS = "base.db";
	private static final int VERSAO_BASE_DE_DADOS = 1;

	public BaseDeDados(Context context) {
		super(context, NOME_BASE_DE_DADOS, null, VERSAO_BASE_DE_DADOS);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		StringBuilder stringBuilderCreateTable = new StringBuilder();
		StringBuilder tabelaProdutos = new StringBuilder();

		stringBuilderCreateTable.append(" CREATE TABLE tb_clientes (");
		stringBuilderCreateTable.append(" codigo INTEGER PRIMARY KEY AUTOINCREMENT, ");
		stringBuilderCreateTable.append(" razao_social VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" nome_fantasia VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" telefone VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" telefone_comercial VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" celular VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" contato VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" email VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" cpf VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" rg VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" endereco VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" bairro VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" cep VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" cidade VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" uf VARCHAR NOT NULL, ");
		stringBuilderCreateTable.append(" observacoes VARCHAR NOT NULL ) ");
		
		db.execSQL(stringBuilderCreateTable.toString());
		
		String ROW1 = "INSERT INTO tb_clientes " + " (codigo, razao_social, nome_fantasia, telefone, telefone_comercial, celular, contato, email, cpf, rg, endereco, bairro, cep, cidade, uf, observacoes)" 
		+ " Values (NULL, 'CONSUMIDOR', '', '', '', '', '', '', '12345678900', '', '', '', '', 'Santo Antônio da Platina', 'PR', '')";
		db.execSQL(ROW1);
		
		String ROW2 = "INSERT INTO tb_clientes " + " (codigo, razao_social, nome_fantasia, telefone, telefone_comercial, celular, contato, email, cpf, rg, endereco, bairro, cep, cidade, uf, observacoes)" 
			+ " Values (NULL, 'BRUNO ALEX DE OLIVEIRA', 'BRUNNO OLIVEIRA', '', '', '', '', '', '12345678900', '', '', '', '', 'Santo Antônio da Platina', 'PR', '')";
		db.execSQL(ROW2);
		
		tabelaProdutos.append(" CREATE TABLE tb_produtos (");
		tabelaProdutos.append(" codigo INTEGER PRIMARY KEY AUTOINCREMENT, ");
		tabelaProdutos.append(" razao_social VARCHAR NOT NULL, ");
		tabelaProdutos.append(" nome_fantasia VARCHAR NOT NULL, ");
		tabelaProdutos.append(" telefone VARCHAR NOT NULL, ");
		tabelaProdutos.append(" telefone_comercial VARCHAR NOT NULL, ");
		tabelaProdutos.append(" celular VARCHAR NOT NULL, ");
		tabelaProdutos.append(" contato VARCHAR NOT NULL, ");
		tabelaProdutos.append(" email VARCHAR NOT NULL, ");
		tabelaProdutos.append(" cpf VARCHAR NOT NULL, ");
		tabelaProdutos.append(" rg VARCHAR NOT NULL, ");
		tabelaProdutos.append(" endereco VARCHAR NOT NULL, ");
		tabelaProdutos.append(" bairro VARCHAR NOT NULL, ");
		tabelaProdutos.append(" cep VARCHAR NOT NULL, ");
		tabelaProdutos.append(" cidade VARCHAR NOT NULL, ");
		tabelaProdutos.append(" uf VARCHAR NOT NULL, ");
		tabelaProdutos.append(" observacoes VARCHAR NOT NULL ) ");
		
		db.execSQL(tabelaProdutos.toString());
		
		String ROW3 = "INSERT INTO tb_produtos " + " (codigo, razao_social, nome_fantasia, telefone, telefone_comercial, celular, contato, email, cpf, rg, endereco, bairro, cep, cidade, uf, observacoes)" 
			+ " Values (NULL, 'CONSUMIDOR', '', '', '', '', '', '', '12345678900', '', '', '', '', 'Santo Antônio da Platina', 'PR', '')";
		db.execSQL(ROW3);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS tb_clientes");
		onCreate(db);
	}

	public SQLiteDatabase getConexaoDatabase() {
		return this.getWritableDatabase();
	}
	
	public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM tb_clientes";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }

}

