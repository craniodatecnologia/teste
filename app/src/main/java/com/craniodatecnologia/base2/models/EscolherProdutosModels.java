package com.craniodatecnologia.base2.models;

public class EscolherProdutosModels
{
	
	private int codigo;
	private String referencia;
	private String descricao;
	private String tamanho;
	private String ncm;
	private String preco;
	private String observacoes;

	public EscolherProdutosModels()
	{}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}
