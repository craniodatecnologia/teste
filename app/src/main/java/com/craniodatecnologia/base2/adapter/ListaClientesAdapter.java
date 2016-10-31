package com.craniodatecnologia.base2.adapter;
import android.widget.*;
import java.util.*;
import android.view.*;
import android.content.*;
import com.craniodatecnologia.base2.*;
import com.craniodatecnologia.base2.repositorio.*;
import com.craniodatecnologia.base2.models.*;

public class ListaClientesAdapter extends BaseAdapter {
	private static LayoutInflater layoutInflater = null;

	List<ListaClientes> listaClientes = new ArrayList<ListaClientes>();

	RepositorioClientes repositorioClientes;

	private Clientes verClientes;

	public ListaClientesAdapter(Clientes verClientes, List<ListaClientes> listaClientes) {

		this.listaClientes = listaClientes;
		this.verClientes = verClientes;
		this.layoutInflater = (LayoutInflater) this.verClientes.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.repositorioClientes = new RepositorioClientes(verClientes);
	}

	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return listaClientes.size();
	}

	@Override
	public Object getItem(int position)
	{
		// TODO: Implement this method
		return position;
	}

	@Override
	public long getItemId(int position)
	{
		// TODO: Implement this method
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		final View viewLinhaLista = layoutInflater.inflate(R.layout.lista_clientes, null);

		//TextView textViewCodigo = (TextView) viewLinhaLista.findViewById(R.id.textViewCodigo);
		TextView textViewRazaoSocial = (TextView) viewLinhaLista.findViewById(R.id.textoRazaoSocial);
		TextView textViewNomefantasia = (TextView) viewLinhaLista.findViewById(R.id.textoNomeFantasia);
		//TextView textViewValor = (TextView) viewLinhaLista.findViewById(R.id.textViewValor);

		//Button buttonExcluir = (Button) viewLinhaLista.findViewById(R.id.buttonExcluir);

		//textViewCodigo.setText(String.valueOf(ListaClientess.get(position).getCodigo()));
		textViewRazaoSocial.setText(String.valueOf(listaClientes.get(position).getRazaoSocial()));
		textViewNomefantasia.setText(String.valueOf(listaClientes.get(position).getNomeFantasia()));
		//textViewValor.setText(String.valueOf(ListaClientess.get(position).getValor()));

		return viewLinhaLista;
	}

	public void AtualizarLista() {
		this.listaClientes.clear();
		this.listaClientes = repositorioClientes.selecionarTodos();
		this.notifyDataSetChanged();
	}

}

