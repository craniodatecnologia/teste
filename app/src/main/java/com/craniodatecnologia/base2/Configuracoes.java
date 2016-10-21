package com.craniodatecnologia.base2;
import android.preference.*;
import android.os.*;

public class Configuracoes extends PreferenceActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.configuracoes);

		
		}

}
