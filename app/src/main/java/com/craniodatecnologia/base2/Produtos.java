package com.craniodatecnologia.base2;
import android.app.*;
import android.os.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import com.craniodatecnologia.base2.adapter.*;
import com.craniodatecnologia.base2.repositorio.*;
import java.util.*;
import com.craniodatecnologia.base2.models.*;
import android.widget.AdapterView.*;

public class Produtos extends Activity
{
	
	private ListView lv1;
	ListaProdutosAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.produtos);
		
		lv1 = (ListView) findViewById(R.id.listaProdutos);
		
		try
		{
			RepositorioProdutos repositorioProdutos =  new RepositorioProdutos(this);

			//BUSCA AS PESSOAS CADASTRADAS
			List<ListaProdutos> produtos = repositorioProdutos.selecionarTodos();

			//SETA O ADAPTER DA LISTA COM OS REGISTROS RETORNADOS DA BASE
			lv1.setAdapter(new ListaProdutosAdapter(this, produtos));
			lv1.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view, int posicao, long id)
					{
						//Intent intent = new Intent(Clientes.this, AtualizarClientes.class);
					}
				});
			lv1.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> parent, View view,final int pos,
												   final long id) {

						String produto = (String) ((TextView) view.findViewById(R.id.txtDescricaoProduto)).getText();
						String preco = (String) ((TextView) view.findViewById(R.id.txtPrecoProdutos)).getText();

						AlertDialog.Builder alert = new AlertDialog.Builder(Produtos.this);
						alert.setTitle("Produto:");
						alert.setMessage(produto + "\n" + "R$ " + preco);
						alert.setPositiveButton("Editar", new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface p1, int p2)
								{
									// CODIGO PARA ALTERAR UM PRODUTO
								}
							});
						alert.setNegativeButton("Cancelar", null);
						alert.setCancelable(false);
						alert.show();
						return false;
					}
				});
		}
		catch (Exception erro)
		{
			AlertDialog.Builder aviso = new AlertDialog.Builder(Produtos.this);
			aviso.setMessage("" + erro);
			aviso.setPositiveButton("Ok", null);
			aviso.show();
		}
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		RepositorioProdutos repositorioProdutos =  new RepositorioProdutos(this);

		//BUSCA AS PESSOAS CADASTRADAS
		List<ListaProdutos> produtos = repositorioProdutos.selecionarTodos();

		//SETA O ADAPTER DA LISTA COM OS REGISTROS RETORNADOS DA BASE
		lv1.setAdapter(new ListaProdutosAdapter(this, produtos));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_produtos, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{

			case R.id.adicionarProduto:
				Intent adicionarProduto = new Intent(Produtos.this, CadastrarProduto.class);
				startActivity(adicionarProduto);
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
}
