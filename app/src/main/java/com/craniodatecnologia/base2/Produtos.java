package com.craniodatecnologia.base2;
import android.app.*;
import android.os.*;
import android.content.*;
import android.view.*;

public class Produtos extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.produtos);
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
