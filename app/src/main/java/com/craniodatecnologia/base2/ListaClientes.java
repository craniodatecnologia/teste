package com.craniodatecnologia.base2;

public class ListaClientes
{
	
	private int codigo;
	private String razaoSocial;
	private String nomeFantasia;

	public ListaClientes()
	{}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
}
