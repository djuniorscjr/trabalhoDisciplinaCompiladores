package com.compilador.tipo;

import com.compilador.Classificacao;
import com.compilador.modelo.TipoToken;
import com.compilador.modelo.Token;

public class ConjuntoDePalavras implements Classificacao {

	public Token classificar(char[] arquivo, Integer indice) {
		int estado = 0;
		StringBuilder sb = new StringBuilder();
		Token token = new Token();
		while (indice <= arquivo.length - 1) {
			switch (estado) {
			case 0:
				if (arquivo[indice] == '"') {
					estado = 1;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				}else {
					indice = arquivo.length;
				}
				break;
			case 1:
				if (arquivo[indice] == '"') {
					estado = 10;
					sb.append(arquivo[indice]);
					token.setIndice(indice);
					indice = indice + 1;
				} else {
					estado = 1;
					sb.append(arquivo[indice]);
					indice++;
				}
				break;
			default:
				indice = arquivo.length;
				break;
			}

		}
		if (sb.length() > 1) {
			
			token.setDescricao(sb.toString());
			token.setTipoToken(TipoToken.STRING);
				
			return token;
		}

		return null;

	}
}
