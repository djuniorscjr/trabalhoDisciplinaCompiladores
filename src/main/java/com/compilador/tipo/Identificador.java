package com.compilador.tipo;

import com.compilador.Classificacao;
import com.compilador.modelo.TipoToken;
import com.compilador.modelo.Token;

public class Identificador implements Classificacao{

	public Token classificar(char[] arquivo) {
		int indice = 0;
		char c = arquivo[indice];
		StringBuilder sb = new StringBuilder();
		if(Character.isLetter(c)){
			sb.append(c);
			c = arquivo[indice++];
		}
		while(Character.isLetter(c) || Character.isDigit(c)){
			sb.append(c);
			c = arquivo[indice++];
		}
		if(sb.length() > 0){
			Token token = new Token();
			token.setDescricao(sb.toString());
			token.setTipoToken(TipoToken.IDENTIFICADOR);
			return token;
		}
		return null;
	}
	
	

}
