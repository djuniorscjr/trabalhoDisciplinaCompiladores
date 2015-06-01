package com.compilador.modelo;

public enum TipoToken {
	
	IDENTIFICADOR 		("Identificador"),
	PALAVRA_RESEVADA	("Palavra Reservada"),
	SIMBOLO_ESPECIAL	("Simbolo Especial"),
	COMENTARIO			("Coment�rio"),
	STRING				("String"),
	NUMERO				("N�mero"),
	NAO_IDENTIFICADO	("N�o Especificado");
	
	private String decricao;
	
	private TipoToken(String descricao){
		this.decricao = descricao;
	}
	
	public String getDecricao() {
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}
}