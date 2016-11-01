package com.craniodatecnologia.base2;
import android.app.*;
import android.widget.*;
import com.craniodatecnologia.base2.adapter.*;
import android.os.*;
import com.craniodatecnologia.base2.repositorio.*;
import java.util.*;
import com.craniodatecnologia.base2.models.*;
import android.widget.AdapterView.*;
import android.view.*;
import android.content.*;
import android.text.*;


public class EscolherProduto extends Activity
{
	
	private ListView lv1;
	EscolherProdutosAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.produtos);

		lv1 = (ListView) findViewById(R.id.listaProdutos);

		try
		{
			RepositorioProdutosEscolhidos repositorioProdutos =  new RepositorioProdutosEscolhidos(this);

			//BUSCA AS PESSOAS CADASTRADAS
			List<EscolherProdutosModels> escolherProdutos = repositorioProdutos.selecionarTodos();

			//SETA O ADAPTER DA LISTA COM OS REGISTROS RETORNADOS DA BASE
			lv1.setAdapter(new EscolherProdutosAdapter(this, escolherProdutos));
			lv1.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view, int posicao, long id)
					{
						String produto = (String) ((TextView) view.findViewById(R.id.txtDescricaoProduto)).getText();
						
						final EditText input0 = new EditText(EscolherProduto.this);
						input0.setInputType(InputType.TYPE_CLASS_NUMBER);
						input0.setText("1");
						
						AlertDialog.Builder dialog = new AlertDialog.Builder(EscolherProduto.this);
						dialog.setTitle(produto);
						dialog.setMessage("Informe a quantidade");
						dialog.setView(input0);
						dialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface p1, int p2)
								{
									// TODO: Implement this method
								}
						});
						dialog.setNegativeButton("Cancelar", null);
						dialog.show();
					}
				});
		}
		catch (Exception erro)
		{
			AlertDialog.Builder aviso = new AlertDialog.Builder(EscolherProduto.this);
			aviso.setMessage("" + erro);
			aviso.setPositiveButton("Ok", null);
			aviso.show();
		}
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		RepositorioProdutosEscolhidos repositorioProdutos =  new RepositorioProdutosEscolhidos(this);

		//BUSCA AS PESSOAS CADASTRADAS
		List<EscolherProdutosModels> produtos = repositorioProdutos.selecionarTodos();

		//SETA O ADAPTER DA LISTA COM OS REGISTROS RETORNADOS DA BASE
		lv1.setAdapter(new EscolherProdutosAdapter(this, produtos));
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
				Intent adicionarProduto = new Intent(EscolherProduto.this, CadastrarProduto.class);
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
