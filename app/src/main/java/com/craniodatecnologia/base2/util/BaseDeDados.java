package com.craniodatecnologia.base2.util;
import android.database.sqlite.*;
import android.content.*;
import java.util.*;
import android.database.*;
import android.app.*;
import android.widget.*;

public class BaseDeDados extends SQLiteOpenHelper
{

	private static final String NOME_BASE_DE_DADOS = "base.db";
	private static final int VERSAO_BASE_DE_DADOS = 4;

	public BaseDeDados(Context context) {
		super(context, NOME_BASE_DE_DADOS, null, VERSAO_BASE_DE_DADOS);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		criarTabelaClientes(db);
		criarTabelaProdutos(db);
		criarTabelaPedido(db);
		criarTabelaVenda(db);
	}
	

	private void criarTabelaClientes(SQLiteDatabase db)
	{
		StringBuilder stringBuilderCreateTable = new StringBuilder();

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

	}

	private void criarTabelaProdutos(SQLiteDatabase db)
	{
		StringBuilder tabelaProdutos = new StringBuilder();

		tabelaProdutos.append(" CREATE TABLE tb_produtos (");
		tabelaProdutos.append(" codigo INTEGER PRIMARY KEY AUTOINCREMENT, ");
		tabelaProdutos.append(" referencia VARCHAR NOT NULL, ");
		tabelaProdutos.append(" descricao VARCHAR NOT NULL, ");
		tabelaProdutos.append(" tamanho VARCHAR NOT NULL, ");
		tabelaProdutos.append(" ncm VARCHAR NOT NULL, ");
		tabelaProdutos.append(" preco VARCHAR NOT NULL, ");
		tabelaProdutos.append(" observacoes VARCHAR NOT NULL ) ");

		db.execSQL(tabelaProdutos.toString());

		/*
		String ROW2 = "INSERT INTO tb_produtos " + " (codigo, referencia, descricao, tamanho, ncm, preco, observacoes)" 
			+ " Values (NULL, '1', 'Smartphone Samsung S4 Mini', 'Padrão', '00000000', '599,99', '')";
		db.execSQL(ROW2);
		*/
	}
	
	private void criarTabelaPedido(SQLiteDatabase db) {
		StringBuilder tabelaPedido = new StringBuilder();
		
		tabelaPedido.append("CREATE TABLE tb_pedido (");
		tabelaPedido.append("codigo INTEGER PRIMARY KEY AUTOINCREMENT, ");
		tabelaPedido.append("item VARCHAR NOT NULL, ");
		tabelaPedido.append("quantidade INTEGER NOT NULL, ");
		tabelaPedido.append("valor DOUBLE NOT NULL )");
		
		db.execSQL(tabelaPedido.toString());
	}
	
	private void criarTabelaVenda(SQLiteDatabase db) {
		
		StringBuilder tabelaVenda = new StringBuilder();
		
		tabelaVenda.append("CREATE TABLE venda (");
		tabelaVenda.append("id INTEGER PRIMARY KEY AUTOINCREMENT," );
		tabelaVenda.append("ven_data DATE, ");
		tabelaVenda.append("ven_hora TIME, ");
		tabelaVenda.append("ven_nome_cli TEXT, ");
		tabelaVenda.append("ven_endereco_cli TEXT, ");
		tabelaVenda.append("ven_telefone_cli TEXT, ");
		tabelaVenda.append("ven_valor_total DOUBLE)");
		
		db.execSQL(tabelaVenda.toString());
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS tb_clientes");
		db.execSQL("DROP TABLE IF EXISTS tb_produtos");
		db.execSQL("DROP TABLE IF EXISTS tb_pedido");
		db.execSQL("DROP TABLE IF EXISTS venda");
		onCreate(db);
	}

	public SQLiteDatabase getConexaoDatabase() {
		return this.getWritableDatabase();
	}
	
	public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT * FROM tb_clientes";

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

