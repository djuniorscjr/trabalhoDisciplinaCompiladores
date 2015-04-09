package com.compilador.etapa;

import com.compilador.Classificacao;
import com.compilador.modelo.Token;

public class Lexical {

	private char[] arquivo;
	
	public Lexical(char[] arquivo) {
		this.arquivo = arquivo;
	}

	public char[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(char[] arquivo) {
		this.arquivo = arquivo;
	}

	public Token getToken() {
		
		return null;
	}

}
