package com.compilador.tipo;


import com.compilador.Classificacao;
import com.compilador.erro.Erro;
import com.compilador.modelo.TipoToken;
import com.compilador.modelo.Token;

public class Identificador implements Classificacao {


	public Token classificar(char[] arquivo, Integer indice) throws Erro {

		int estado = 0;
		StringBuilder sb = new StringBuilder();
		Boolean bool = false;
		
		while (indice <= arquivo.length - 1) {
			switch (estado) {
			case 0:
				if (arquivo[indice] == '@') {
					estado = 1;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 1:
				if (Character.isLetter(arquivo[indice])) {
					estado = 2;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 2:
				if (Character.isLetter(arquivo[indice])
						|| Character.isDigit(arquivo[indice])) {
					estado = 3;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else if (arquivo[indice] == '_') {
					estado = 4;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 3:
				if (Character.isLetter(arquivo[indice])
						|| Character.isDigit(arquivo[indice])) {
					estado = 3;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 4:
				if (Character.isLetter(arquivo[indice])
						|| Character.isDigit(arquivo[indice])) {
					estado = 3;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
					bool = true;
				}
				break;
			default:
				break;
			}

		}
		if (sb.length() > 1) {
			if(bool){
				  throw new Erro("Erro Indetificador Inválido");
			}
			Token token = new Token();
			token.setDescricao(sb.toString());
			token.setTipoToken(TipoToken.IDENTIFICADOR);
				
			return token;
		}

		return null;
	}

}
