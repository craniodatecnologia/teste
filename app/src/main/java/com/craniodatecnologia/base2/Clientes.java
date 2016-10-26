package com.craniodatecnologia.base2;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.widget.AdapterView.*;
import java.util.*;

public class Clientes extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clientes);
		
		ArrayList<ListaClientes> image_details = getSearchResults();

        final ListView lv1 = (ListView) findViewById(R.id.listaClientes);
        lv1.setAdapter(new ListaClientesAdapter(this, image_details));

        lv1.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> a, View v, int position, long id)
				{ 
					Object o = lv1.getItemAtPosition(position);
					final ListaClientes obj_itemDetails = (ListaClientes)o;

					{
						switch (position)
						{
							case 0:
								//Intent intent = new Intent(MainActivity.this, NovoPedido.class);
								//startActivity(intent);
								break;

							case 1:
								Intent intent = new Intent(Clientes.this, MainActivity.class);
								startActivity(intent);
								break;

							case 2:
								//Intent intent = new Intent(MainActivity.this, MinhasVendas.class);
								//startActivity(intent);
								break;
							default:
						}
					}
				}  

			});
		
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
	
	private ArrayList<ListaClientes> getSearchResults()
	{
    	ArrayList<ListaClientes> results = new ArrayList<ListaClientes>();

    	ListaClientes item_details = new ListaClientes();
    	item_details.setRazaoSocial("CONSUMIDOR");
    	item_details.setNomeFantasia("");
    	results.add(item_details);

		item_details = new ListaClientes();
    	item_details.setRazaoSocial("GMG DE OLIVEIRA");
    	item_details.setNomeFantasia("CONTROL POWER");
    	results.add(item_details);

		return results;
	}

}
