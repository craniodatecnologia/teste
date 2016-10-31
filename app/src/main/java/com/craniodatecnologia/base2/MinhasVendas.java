package com.craniodatecnologia.base2;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;

public class MinhasVendas extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.minhas_vendas);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_minhas_vendas, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{

			case R.id.novoPedido:
				Intent novopedido = new Intent(MinhasVendas.this, NovoPedido.class);
				startActivity(novopedido);
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
}
