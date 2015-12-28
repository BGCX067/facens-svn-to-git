package br.com.facens.facens.shared.beans;

public enum UnidadeFederativa {
	
	SP("São Paulo"),
	RJ("Rio de Janeiro"),
	MG("Minas Gerais"),
	PR("Paraná");
	
	private final String descricao;
	
	private UnidadeFederativa(String desc) {
		this.descricao = desc;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
