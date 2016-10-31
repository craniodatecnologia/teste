package com.craniodatecnologia.base2.adapter;
import android.widget.*;
import java.util.*;
import android.view.*;
import android.content.*;
import com.craniodatecnologia.base2.models.*;
import com.craniodatecnologia.base2.*;

public class ListaMainAdapter extends BaseAdapter {
	private static ArrayList<ListaMain> itemDetailsrrayList;

	private Integer[] imgid = {
		R.drawable.novopedido,
		R.drawable.cadastrarpessoa,
		R.drawable.minhasvendas
	};

	private LayoutInflater l_Inflater;

	public ListaMainAdapter(Context context, ArrayList<ListaMain> results) {
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
			convertView = l_Inflater.inflate(R.layout.main_list_row, null);
			holder = new ViewHolder();
			holder.txt_itemName = (TextView) convertView.findViewById(R.id.textoItem);
			holder.txt_itemDescription = (TextView) convertView.findViewById(R.id.textoSubItem);
			//holder.txt_itemPrice = (TextView) convertView.findViewById(R.id.precoSobremesas);
			holder.itemImage = (ImageView) convertView.findViewById(R.id.imageItem);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.txt_itemName.setText(itemDetailsrrayList.get(position).getItem());
		holder.txt_itemDescription.setText(itemDetailsrrayList.get(position).getSubItem());
		//holder.txt_itemPrice.setText(itemDetailsrrayList.get(position).getPrice());
		holder.itemImage.setImageResource(imgid[itemDetailsrrayList.get(position).getImagemItem() - 1]);
//		imageLoader.DisplayImage("http://192.168.1.28:8082/ANDROID/images/BEVE.jpeg", holder.itemImage);

		return convertView;
	}

	static class ViewHolder {
		TextView txt_itemName;
		TextView txt_itemDescription;
		//TextView txt_itemPrice;
		ImageView itemImage;
	}
}

