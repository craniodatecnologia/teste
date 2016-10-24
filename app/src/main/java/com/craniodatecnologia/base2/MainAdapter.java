package com.craniodatecnologia.base2;
import android.support.v7.widget.*;
import android.view.*;
import java.util.*;

public class MainAdapter extends RecyclerView.Adapter 
{
	
	private List<ListMain> listMain;
	
	public MainAdapter(List<ListMain> listMain) {
		this.listMain = listMain;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup p1, int p2)
	{
		// TODO: Implement this method
		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder p1, int p2)
	{
		// TODO: Implement this method
	}

	@Override
	public int getItemCount()
	{
		// TODO: Implement this method
		return listMain.size();
	}
	
}
