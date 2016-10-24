package com.craniodatecnologia.base2;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.graphics.drawable.*;
import android.graphics.*;
import android.text.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import java.util.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
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

}
