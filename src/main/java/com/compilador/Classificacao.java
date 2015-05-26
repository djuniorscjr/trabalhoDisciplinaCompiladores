package com.compilador;


import com.compilador.modelo.Token;

public interface Classificacao {
	
	public Token classificar(char[] arquivo, Integer indice);
}
