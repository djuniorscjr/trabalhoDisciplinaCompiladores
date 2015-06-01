package com.compilador.tipo;

import com.compilador.Classificacao;
import com.compilador.modelo.TipoToken;
import com.compilador.modelo.Token;

public class Numero implements Classificacao{

	public Token classificar(char[] arquivo, Integer indice) {
		int estado = 0;
		StringBuilder sb = new StringBuilder();
		
		while (indice <= arquivo.length - 1) {
			switch (estado) {
			case 0:
				if (Character.isDigit(arquivo[indice])) {
					estado = 1;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 1:
				if (Character.isDigit(arquivo[indice])) {
					estado = 1;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				}else if(arquivo[indice] == '.'){
					estado = 1;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				}else {
					indice = arquivo.length;
				}
				break;	
			default:
				break;
			}

		}
		if (sb.length() > 0) {
			Token token = new Token();
			token.setDescricao(sb.toString());
			token.setTipoToken(TipoToken.NUMERO);
				
			return token;
		}

		return null;

	}


}
