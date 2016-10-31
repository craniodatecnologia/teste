package com.craniodatecnologia.base2;
import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.ContextMenu.*;
import android.view.MenuItem.*;
import android.widget.*;
import android.widget.AdapterView.*;
import java.util.*;
import com.craniodatecnologia.base2.adapter.*;
import com.craniodatecnologia.base2.repositorio.*;
import com.craniodatecnologia.base2.models.*;

public class Clientes extends Activity 
{
	private ListView lv1;
	ListaClientesAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clientes);

        lv1 = (ListView) findViewById(R.id.listaClientes);

		try
		{
			RepositorioClientes repositorioClientes =  new RepositorioClientes(this);

			//BUSCA AS PESSOAS CADASTRADAS
			List<ListaClientes> clientes = repositorioClientes.selecionarTodos();

			//SETA O ADAPTER DA LISTA COM OS REGISTROS RETORNADOS DA BASE
			lv1.setAdapter(new ListaClientesAdapter(this, clientes));
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
													   
						String cliente = (String) ((TextView) view.findViewById(R.id.textoRazaoSocial)).getText();
													   
						AlertDialog.Builder alert = new AlertDialog.Builder(Clientes.this);
						alert.setTitle("Cliente");
						alert.setMessage(cliente);
						alert.setPositiveButton("Editar", new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface p1, int p2)
								{
									// CODIGO PARA ALTERAR UM CLIENTE
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
			AlertDialog.Builder aviso = new AlertDialog.Builder(Clientes.this);
			aviso.setMessage("" + erro);
			aviso.setPositiveButton("Ok", null);
			aviso.show();
		}
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		RepositorioClientes repositorioClientes =  new RepositorioClientes(this);

		//BUSCA AS PESSOAS CADASTRADAS
		List<ListaClientes> clientes = repositorioClientes.selecionarTodos();

		//SETA O ADAPTER DA LISTA COM OS REGISTROS RETORNADOS DA BASE
		lv1.setAdapter(new ListaClientesAdapter(this, clientes));
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_clientes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{

			case R.id.adicionarCliente:
				Intent adicionarCliente = new Intent(Clientes.this, CadastrarCliente.class);
				startActivity(adicionarCliente);
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
