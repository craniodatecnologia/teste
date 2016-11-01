package com.craniodatecnologia.base2;
import android.app.*;
import android.os.*;
import android.widget.*;
import java.util.*;
import android.view.*;
import com.craniodatecnologia.base2.util.*;
import android.view.View.*;
import java.text.*;
import android.content.*;

public class NovoPedido extends Activity
{
	
	Spinner spinnerClientes;
	ImageButton adicionarProduto;
	EditText dataPedido;
	Calendar myCalendar = Calendar.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.novo_pedido);
		
		spinnerClientes = (Spinner) findViewById(R.id.spinnerClientes);
		dataPedido = (EditText) findViewById(R.id.dataPedido);
		adicionarProduto = (ImageButton) findViewById(R.id.buttonAdicionarProduto);
		
		final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int ano, int mes, int dia)
			{
				myCalendar.set(Calendar.YEAR, ano);
				myCalendar.set(Calendar.MONTH, mes);
				myCalendar.set(Calendar.DAY_OF_MONTH, dia);
				atualizaData();
			}
		};
		
		dataPedido.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View p1)
				{
					new DatePickerDialog(NovoPedido.this, date, myCalendar.get(Calendar.YEAR),
					myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
				}
		});
		
		adicionarProduto.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v)
				{
					Intent addProduto = new Intent(NovoPedido.this, EscolherProduto.class);
					startActivity(addProduto);
				}
		});
		
		atualizaData();
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
	
	private void atualizaData() {
		String myFormat = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
		
		dataPedido.setText(sdf.format(myCalendar.getTime()));
	}
}
