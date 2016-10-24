package com.craniodatecnologia.base2;

public class ListMain
{
	
	private final String novoPedido;
	private final String cadastrarPessoa;
	private final String minhasVendas;
	
	public ListMain(String novoPedido, String cadastrarPessoa, String minhasVendas) {
		
		this.novoPedido = novoPedido;
		this.cadastrarPessoa = cadastrarPessoa;
		this.minhasVendas = minhasVendas;
		
	}
	
	public String getNovoPedido() {
		return novoPedido;
	}
	
	public String getCadastrarPessoa() {
		return cadastrarPessoa;
	}
	
	public String getMinhasVendas() {
		return minhasVendas;
	}
	
}
