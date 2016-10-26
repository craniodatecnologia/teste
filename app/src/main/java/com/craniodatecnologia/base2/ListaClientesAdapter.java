package com.craniodatecnologia.base2;
import android.widget.*;
import java.util.*;
import android.view.*;
import android.content.*;

public class ListaClientesAdapter extends BaseAdapter {
	private static ArrayList<ListaClientes> itemDetailsrrayList;

	private LayoutInflater l_Inflater;

	public ListaClientesAdapter(Context context, ArrayList<ListaClientes> results) {
		itemDetailsrrayList = results;
		l_Inflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return itemDetailsrrayList.size();
	}

	public Object getItem(int position) {
		return itemDetailsrrayList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = l_Inflater.inflate(R.layout.lista_clientes, null);
			holder = new ViewHolder();
			holder.txt_razaoSocial = (TextView) convertView.findViewById(R.id.textoRazaoSocial);
			holder.txt_nomeFantasia = (TextView) convertView.findViewById(R.id.textoNomeFantasia);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.txt_razaoSocial.setText(itemDetailsrrayList.get(position).getRazaoSocial());
		holder.txt_nomeFantasia.setText(itemDetailsrrayList.get(position).getNomeFantasia());
		
		return convertView;
	}

	static class ViewHolder {
		TextView txt_razaoSocial;
		TextView txt_nomeFantasia;
		
	}
}

