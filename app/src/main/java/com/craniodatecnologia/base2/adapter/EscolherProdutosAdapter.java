package com.craniodatecnologia.base2.adapter;
import android.widget.*;
import android.view.*;
import java.util.*;
import com.craniodatecnologia.base2.models.*;
import com.craniodatecnologia.base2.repositorio.*;
import com.craniodatecnologia.base2.*;
import android.content.*;

public class EscolherProdutosAdapter extends BaseAdapter {
	private static LayoutInflater layoutInflater = null;

	List<EscolherProdutosModels> listaProdutos = new ArrayList<EscolherProdutosModels>();

	RepositorioProdutosEscolhidos repositorioProdutos;

	private EscolherProduto verProdutos;

	public EscolherProdutosAdapter(EscolherProduto verProdutos, List<EscolherProdutosModels> listaProdutos) {

		this.listaProdutos = listaProdutos;
		this.verProdutos = verProdutos;
		this.layoutInflater = (LayoutInflater) this.verProdutos.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.repositorioProdutos = new RepositorioProdutosEscolhidos(verProdutos);
	}

	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return listaProdutos.size();
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
		final View viewLinhaLista = layoutInflater.inflate(R.layout.lista_produtos, null);

		//TextView textViewCodigo = (TextView) viewLinhaLista.findViewById(R.id.textViewCodigo);
		TextView textViewDescricao = (TextView) viewLinhaLista.findViewById(R.id.txtDescricaoProduto);
		TextView textViewPreco = (TextView) viewLinhaLista.findViewById(R.id.txtPrecoProdutos);
		//TextView textViewValor = (TextView) viewLinhaLista.findViewById(R.id.textViewValor);

		//Button buttonExcluir = (Button) viewLinhaLista.findViewById(R.id.buttonExcluir);

		//textViewCodigo.setText(String.valueOf(ListaClientess.get(position).getCodigo()));
		textViewDescricao.setText(String.valueOf(listaProdutos.get(position).getDescricao()));
		textViewPreco.setText(String.valueOf(listaProdutos.get(position).getPreco()));
		//textViewValor.setText(String.valueOf(listaProdutos.get(position).getValor()));

		return viewLinhaLista;
	}

	public void AtualizarLista() {
		this.listaProdutos.clear();
		this.listaProdutos = repositorioProdutos.selecionarTodos();
		this.notifyDataSetChanged();
	}

}
