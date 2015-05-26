package com.compilador.modelo;

public class Token {
	
	private String descricao;
	private TipoToken tipoToken;

	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoToken getTipoToken() {
		return tipoToken;
	}
	public void setTipoToken(TipoToken tipoToken) {
		this.tipoToken = tipoToken;
	}
	
	
}
