package com.craniodatecnologia.base2;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.craniodatecnologia.base2.models.*;
import com.craniodatecnologia.base2.repositorio.*;

public class CadastrarProduto extends Activity
{
	
	EditText referencia, descricao, tamanho, ncm, preco, observacoes;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrar_produto);
		
		referencia = (EditText) findViewById(R.id.referenciaProduto);
		
		descricao = (EditText) findViewById(R.id.descricaoProduto);
		
		tamanho = (EditText) findViewById(R.id.tamanhoProduto);
		tamanho.setText("PADRÃO");
		
		ncm = (EditText) findViewById(R.id.ncmProduto);
		
		preco = (EditText) findViewById(R.id.precoProduto);
		
		observacoes = (EditText) findViewById(R.id.observacoesProduto);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_cadastro_produtos, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{

			case R.id.salvarProduto:
				menuSalvar();
				return true;

				/*
				 case R.id.sair:
				 finish();
				 return true;
				 */

			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	public void menuSalvar()
	{
		if (descricao.getText().toString().isEmpty())
		{
			descricao.setError("Campo obrigatório");
			descricao.requestFocus();
		} 
		else if (preco.getText().toString().isEmpty()) {
			preco.setError("Campo obrigatório");
			preco.requestFocus();
		}
		else
		{
			ListaProdutos listaProdutos = new ListaProdutos();
			listaProdutos.setReferencia(referencia.getText().toString());
			listaProdutos.setDescricao(descricao.getText().toString());
			listaProdutos.setTamanho(tamanho.getText().toString());
			listaProdutos.setNcm(ncm.getText().toString());
			listaProdutos.setPreco(preco.getText().toString());
			listaProdutos.setObservacoes(observacoes.getText().toString());
			
			new RepositorioProdutos(CadastrarProduto.this).Salvar(listaProdutos);

			Toast toast = Toast.makeText(getApplicationContext(), "Produto cadastrado com sucesso", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();

			finishAndRemoveTask();
		}
	}
}
