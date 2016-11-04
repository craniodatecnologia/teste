package com.craniodatecnologia.base2.util;
import android.widget.*;
import android.view.*;
import java.util.*;
import com.craniodatecnologia.base2.*;
import com.craniodatecnologia.base2.models.*;
import com.craniodatecnologia.base2.repositorio.*;
import android.content.*;
import android.view.View.*;
import android.app.*;
import android.database.sqlite.*;
import android.database.*;

public class ConsultarProdutosAdicionadosAdapter extends BaseAdapter
{

	private static LayoutInflater layoutInflater = null;

	List<PedidoModel> pedidoModels = new ArrayList<PedidoModel>();

	RepositorioPedido pedidoRepository;

	private NovoPedido verPedido;

	public ConsultarProdutosAdicionadosAdapter(NovoPedido verPedido, List<PedidoModel> pedidoModels)
	{

		this.pedidoModels = pedidoModels;
		this.verPedido = verPedido;
		this.layoutInflater = (LayoutInflater) this.verPedido.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.pedidoRepository = new RepositorioPedido(verPedido);
	}

	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return pedidoModels.size();
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
		final View viewLinhaLista = layoutInflater.inflate(R.layout.lista_itens_pedido, null);

		TextView textViewItem = (TextView) viewLinhaLista.findViewById(R.id.itemVenda);
		TextView textViewQuantidade = (TextView) viewLinhaLista.findViewById(R.id.quantidadeVenda);
		TextView textViewValor = (TextView) viewLinhaLista.findViewById(R.id.valorVenda);

		//Button btExcluirItem = (Button) viewLinhaLista.findViewById(R.id.btExcluirItem);

		textViewItem.setText(String.valueOf(pedidoModels.get(position).getItem()));
		textViewQuantidade.setText(String.valueOf(pedidoModels.get(position).getQuantidade()));
		textViewValor.setText(String.valueOf(pedidoModels.get(position).getValor()));

		/*btExcluirItem.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View p1)
				{
					try
					{
						
						AlertDialog.Builder excluirItens = new AlertDialog.Builder(verPedido);
						excluirItens.setTitle("Aviso");
						excluirItens.setMessage("Confirma a exclusão deste item?");
						excluirItens.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface p1, int p2)
								{
									// TODO: Implement this method
									pedidoRepository.Excluir(pedidoModels.get(position).getCodigo());
									Toast toast = Toast.makeText(verPedido, "Item excluido!", Toast.LENGTH_LONG);
									toast.setGravity(Gravity.CENTER, 0, 0);
									toast.show();
									atualizarLista();
									
								}
							});
						excluirItens.setNegativeButton("Não", null);
						excluirItens.show();
						atualizarLista();
					}
					catch (Exception erro)
					{
						AlertDialog.Builder aviso = new AlertDialog.Builder(verPedido);
						aviso.setTitle("Erro");
						aviso.setMessage("" + erro);
						aviso.setPositiveButton("Ok", null);
						aviso.show();
					}
				}
			});*/

		return viewLinhaLista;
	}

	public void atualizarLista()
	{
		this.pedidoModels.clear();
		this.pedidoModels = pedidoRepository.SelecionarTodos();
		this.notifyDataSetChanged();
	}

}
