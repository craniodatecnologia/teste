package com.craniodatecnologia.base2.models;
import java.util.*;
import com.craniodatecnologia.base2.*;

public class Venda
{
	
	private int cliente;
	private Date dataVenda;
	private String enderecoCliVenda;
	private Date horaVenda;
	private int idVenda;
	private String nomeCliVenda;
	private List<ListaProdutos> produto;
	private String telefoneCliVenda;
	private String tipoPagamento;
	private double totalVenda;
	
	public Venda() {
		super();
	}
	
	public int getCliente() {
		return cliente;
	}
	
	public Date getDataVenda() {
		return dataVenda;
	}
	
	public String getEnderecoCliVenda() {
		return enderecoCliVenda;
	}
	
	public Date getHoraVenda() {
		return horaVenda;
	}
	
	public int getIdVenda() {
		return idVenda;
	}
	
	public String getNomeCliVenda() {
		return nomeCliVenda;
	}
	
	public List<ListaProdutos> getProduto() {
		return produto;
	}
	
	public String getTelefoneCliVenda() {
		return telefoneCliVenda;
	}
	
	public double getTotalVenda() {
		return totalVenda;
	}
	
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public void setEnderecoCliVenda(String enderecoCliVenda) {
		this.enderecoCliVenda = enderecoCliVenda;
	}
	
	public void setHoraVenda(Date horaVenda) {
		this.horaVenda = horaVenda;
	}
	
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	public void setNomeCliVenda(String nomeCliVenda) {
		this.nomeCliVenda = nomeCliVenda;
	}
	
	public void setProduto(List<ListaProdutos> produto) {
		this.produto = produto;
	}
	
	public void setTelefoneCliVenda(String telefoneCliVenda) {
		this.telefoneCliVenda = telefoneCliVenda;
	}
	
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	public void setTotalVenda(double totalVenda) {
		this.totalVenda = totalVenda;
	}
	
	public String tipoPagamento() {
		return tipoPagamento;
	}
	
	
}
