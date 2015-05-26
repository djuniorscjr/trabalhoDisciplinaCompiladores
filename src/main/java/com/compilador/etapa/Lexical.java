package com.compilador.etapa;


import java.util.ArrayList;
import java.util.List;

import com.compilador.modelo.Token;
import com.compilador.tipo.Identificador;
import com.compilador.tipo.PalavraReservada;

public class Lexical {

	private char[] arquivo;
	private List<Token> tokens;
	private Integer indice;
	private Integer max;
	private Boolean encontrou;
	
	public Lexical(char[] arquivo) {
		this.arquivo = arquivo;
		this.tokens = new ArrayList<Token>();
		indice = 0;
		max = arquivo.length - 1;
		encontrou = false;
	}
	
	public Token getToken(){
		Token token = new Token();
		while(indice <= max) {
			Identificador identificador = new Identificador();
			token = identificador.classificar(arquivo, indice);
			if(token == null){
				PalavraReservada palavraReservada = new PalavraReservada();
				token = palavraReservada.classificar(arquivo, indice);
				if(arquivo[indice] == ' '){
					indice++;
				}else if(token == null){
					indice++;
				}else{
					indice = indice + token.getDescricao().length();
					tokens.add(token);
				}
			}else{
				indice = indice + token.getDescricao().length();
				tokens.add(token);
			}
		}
		for (Token token1 : tokens) {
			System.out.println(token1.getTipoToken().getDecricao() + " - " + token1.getDescricao());
		}
		return token;
	}
	
	public char[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(char[] arquivo) {
		this.arquivo = arquivo;
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}
		
	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Boolean getEncontrou() {
		return encontrou;
	}

	public void setEncontrou(Boolean encontrou) {
		this.encontrou = encontrou;
	}


}
