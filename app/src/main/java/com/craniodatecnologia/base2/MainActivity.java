package com.craniodatecnologia.base2;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.graphics.drawable.*;
import android.graphics.*;
import android.text.*;
import java.util.*;
import android.widget.*;
import android.widget.AdapterView.*;
import com.craniodatecnologia.base2.models.*;
import com.craniodatecnologia.base2.adapter.*;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		ArrayList<ListaMain> image_details = getSearchResults();

        final ListView lv1 = (ListView) findViewById(R.id.listaMain);
        lv1.setAdapter(new ListaMainAdapter(this, image_details));

        lv1.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> a, View v, int position, long id)
				{ 
					Object o = lv1.getItemAtPosition(position);
					final ListaMain obj_itemDetails = (ListaMain)o;

					{
						switch (position)
						{
							case 0:
								Intent intent0 = new Intent(MainActivity.this, NovoPedido.class);
								startActivity(intent0);
								break;

							case 1:
								Intent intent1 = new Intent(MainActivity.this, Clientes.class);
								startActivity(intent1);
								break;

							case 2:
								Intent intent2 = new Intent(MainActivity.this, Produtos.class);
								startActivity(intent2);
								break;
								
							case 3:
								Intent intent3 = new Intent(MainActivity.this, MinhasVendas.class);
								startActivity(intent3);
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
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{

			case R.id.configuracoes:
				Intent irParaConfiguracoes = new Intent(MainActivity.this, Configuracoes.class);
				startActivity(irParaConfiguracoes);
				return true;

			case R.id.sair:
				finish();
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

	private ArrayList<ListaMain> getSearchResults()
	{
    	ArrayList<ListaMain> results = new ArrayList<ListaMain>();

    	ListaMain item_details = new ListaMain();
    	item_details.setItem("Novo pedido");
    	item_details.setSubItem("Fazer um novo pedido");
    	item_details.setImagemItem(1);
    	results.add(item_details);

		item_details = new ListaMain();
    	item_details.setItem("Clientes");
    	item_details.setSubItem("Consultar ou cadastrar clientes");
    	item_details.setImagemItem(2);
    	results.add(item_details);
		
		item_details = new ListaMain();
		item_details.setItem("Produtos");
		item_details.setSubItem("Visualizar e gerenciar produtos");
		item_details.setImagemItem(1);
		results.add(item_details);

		item_details = new ListaMain();
    	item_details.setItem("Minhas vendas");
    	item_details.setSubItem("Gerencie suas vendas");
    	item_details.setImagemItem(3);
    	results.add(item_details);

		return results;
	}

}
