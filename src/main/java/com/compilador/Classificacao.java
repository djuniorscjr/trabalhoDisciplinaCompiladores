package com.compilador;


import com.compilador.erro.Erro;
import com.compilador.modelo.Token;

public interface Classificacao {
	
	public Token classificar(char[] arquivo, Integer indice) throws Erro;
}
