package com.compilador.etapa;


import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.compilador.modelo.Token;
import com.compilador.tipo.Identificador;

public class Lexical {

	private char[] arquivo;
	private List<Token> tokens;
	
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
		while(arquivo.length > 0){
			Identificador identificador = new Identificador();
			Token token = identificador.classificar(arquivo);
			tokens.add(token);
			this.removerLidos(token.getDescricao());
		}
		return null;
	}
	
	private void removerLidos(String word){
		int i = 0;
		while(word.length() > 0){
			arquivo = ArrayUtils.remove(arquivo, i);
			i++;
		}
	}
	
	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	

}
