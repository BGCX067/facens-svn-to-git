package br.com.facens.facens.shared.beans;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Agencia implements IsSerializable{

	private int codigo;
	private String nome;
	private String endereco;
	private String cnpj;
	private boolean ativo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public boolean isAtiva() {
		return ativo;
	}

	public void setAtiva(boolean ativa) {
		this.ativo = ativa;
	}

}
