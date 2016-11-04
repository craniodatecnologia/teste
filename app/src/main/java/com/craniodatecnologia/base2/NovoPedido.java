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
import com.craniodatecnologia.base2.repositorio.*;
import com.craniodatecnologia.base2.models.*;
import android.database.sqlite.*;
import android.database.*;
import android.widget.AdapterView.*;

public class NovoPedido extends Activity
{
	// ITENS INSTANCIADOS
	RepositorioPedido repositorioPedido;
	EscolherProdutosModels pedidoModels;

	ImageButton adicionarProduto;
	//Calendar myCalendar = Calendar.getInstance();
	EditText ven_nome_cli;
	ListView lv1;
	Button fecharPedido;
	TextView totalPedido;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.novo_pedido);

		try {
		// ITENS DA LAYOUT
		//dataPedido = (EditText) findViewById(R.id.dataPedido);
		adicionarProduto = (ImageButton) findViewById(R.id.buttonAdicionarProduto);
		lv1 = (ListView) findViewById(R.id.produtosAdicionados);
		fecharPedido = (Button) findViewById(R.id.btFecharPedido);
		totalPedido = (TextView) findViewById(R.id.totalPedido);
		ven_nome_cli = (EditText) findViewById(R.id.ven_nome_cli);

		//MÉTODOS EXECUTADOS ON CREATE
		//atualizaData();
		carregarProdutosAdicionados();
		atualizaTotalPedido();


		// FUNÇÕES DOA ITENS DAS LAYOUT
//		final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
//
//			@Override
//			public void onDateSet(DatePicker view, int ano, int mes, int dia)
//			{
//				myCalendar.set(Calendar.YEAR, ano);
//				myCalendar.set(Calendar.MONTH, mes);
//				myCalendar.set(Calendar.DAY_OF_MONTH, dia);
//				atualizaData();
//			}
//		};
//
//		dataPedido.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View p1)
//				{
//					new DatePickerDialog(NovoPedido.this, date, myCalendar.get(Calendar.YEAR),
//										 myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//				}
//			});
		
			ven_nome_cli.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View p1)
					{
						Intent intent = new Intent(NovoPedido.this, Clientes.class);
						startActivity(intent);
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

		fecharPedido.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View p1)
				{

				}
			});

		lv1.setOnItemLongClickListener(new OnItemLongClickListener() {
			
				@Override
				public boolean onItemLongClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					try {
					
					AlertDialog.Builder excluir = new AlertDialog.Builder(NovoPedido.this);
					excluir.setTitle("Aviso");
					excluir.setMessage("Selecione uma opção");
					excluir.setPositiveButton("Deletar", new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								//repositorioPedido.Excluir(pedidoModels.get(position).getCodigo());
							}
						});
					excluir.setNegativeButton("Cancelar", null);
					excluir.show();
				} catch (Exception erro) {
					AlertDialog.Builder aviso = new AlertDialog.Builder(NovoPedido.this);
					aviso.setMessage("" + erro);
					aviso.setPositiveButton("Ok", null);
					aviso.show();
				}
					return false;
				}});
		
		} catch (Exception erro) {
			Toast toast = Toast.makeText(NovoPedido.this, "" + erro, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
			}
		}

//	private void atualizaData()
//	{
//		String myFormat = "dd/MM/yyyy";
//		SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
//
//		dataPedido.setText(sdf.format(myCalendar.getTime()));
//	}

	private void carregarProdutosAdicionados()
	{
		try
		{
			RepositorioPedido pedidoRepository =  new RepositorioPedido(this);

			//BUSCA AS PESSOAS CADASTRADAS
			List<PedidoModel> pedidos = pedidoRepository.SelecionarTodos();

			//SETA O ADAPTER DA LISTA COM OS REGISTROS RETORNADOS DA BASE
			lv1.setAdapter(new ConsultarProdutosAdicionadosAdapter(this, pedidos));
		}
		catch (Exception erro)
		{
			AlertDialog.Builder aviso = new AlertDialog.Builder(NovoPedido.this);
			aviso.setMessage("" + erro);
			aviso.setPositiveButton("Ok", null);
			aviso.show();
		}

	}

	@Override
	protected void onStart()
	{
		super.onStart();
		try
		{
			carregarProdutosAdicionados();
			atualizaTotalPedido();
			//atualizaData();
		} 
		catch (Exception erro)
		{
			AlertDialog.Builder aviso = new AlertDialog.Builder(NovoPedido.this);
			aviso.setMessage("" + erro);
			aviso.setPositiveButton("Ok", null);
			aviso.show();
		}}

	private void atualizaTotalPedido()
	{
		// abri o banco de dados
		SQLiteDatabase db = openOrCreateDatabase("base.db",
												 Context.MODE_PRIVATE, null);
		Cursor c = db.rawQuery("SELECT sum(valor) FROM tb_pedido ", null);
		if (c.moveToFirst())
		{
			do{
				//Recuperando valores
				Object[] o = new Object[1];
				double total = c.getDouble(0);
				
				Double localDouble = new Double(total);
				o[0] = localDouble;
				String str = String.format("%.2f", o);

				totalPedido.setText("R$ " + String.valueOf(str));
				totalPedido.setVisibility(View.VISIBLE);
			}
			while(c.moveToNext());
		}
		c.close();
		db.close();
	}

}
		
