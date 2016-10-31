package com.craniodatecnologia.base2;
import android.app.*;
import android.os.*;
import android.widget.*;
import java.util.*;
import android.view.*;
import com.craniodatecnologia.base2.util.*;

public class NovoPedido extends Activity
{
	
	Spinner spinnerClientes;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.novo_pedido);
		
		spinnerClientes = (Spinner) findViewById(R.id.spinnerClientes);
		
		
		loadSpinnerData();
		}
		
	private void loadSpinnerData() {
        // database handler
        BaseDeDados db = new BaseDeDados(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
																	android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
			.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerClientes.setAdapter(dataAdapter);
    }

	public void onItemSelected(AdapterView<?> parent, View view, int position,
							   long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
					   Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}
