package com.compilador.tipo;

import com.compilador.Classificacao;
import com.compilador.erro.Erro;
import com.compilador.modelo.TipoToken;
import com.compilador.modelo.Token;

public class Comentario implements Classificacao {

	public Token classificar(char[] arquivo, Integer indice) throws Erro {
		int estado = 0;
		StringBuilder sb = new StringBuilder();
		Token token = new Token();
		Boolean bool = false;
		while (indice <= arquivo.length - 1) {
			switch (estado) {
			case 0:
				if (arquivo[indice] == '*') {
					estado = 1;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else if(arquivo[indice] == '/'){
					estado = 4;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				}else if(arquivo[indice] == '@'){
					estado = 7;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				}else {
					indice = arquivo.length;
				}
				break;
			case 1:
				if (arquivo[indice] == '/') {
					estado = 2;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 2:
				if(arquivo[indice] == '*'){ 
					estado = 3;
					indice = indice + 1;
				} else {
					indice++;
					if(indice == arquivo.length - 1){ 
						bool = true;
					}
				}
				break;
			case 3:
				if (arquivo[indice] == '/') {
					estado = 10;
					sb.append(arquivo[indice - 1]);
					sb.append(arquivo[indice]);
					token.setIndice(indice);
					indice = indice + 1;
				} else {
					estado = 2;
					indice++;
					if(indice == arquivo.length - 1){ 
						bool = true;
					}
				}
				break;
			case 4:
				if (arquivo[indice] == '/') {
					estado = 5;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 5:
				if(arquivo[indice] == '/'){ 
					estado = 6;
					indice = indice + 1;
				} else {
					indice++;
					if(indice == arquivo.length - 1){ 
						bool = true;
					}
				}
				break;
			case 6:
				if (arquivo[indice] == '/') {
					estado = 10;
					sb.append(arquivo[indice - 1]);
					sb.append(arquivo[indice]);
					token.setIndice(indice);
					indice = indice + 1;
				} else {
					estado = 5;
					indice++;
					if(indice == arquivo.length - 1){ 
						bool = true;
					}
				}
				break;
			case 7:
				if (arquivo[indice] == '@') {
					estado = 8;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 8:
				if(arquivo[indice] == '\r'){ 
					estado = 9;
					indice = indice + 1;
				}else{
					indice++;
				} 
				break;
			case 9:
				if (arquivo[indice] == '\n') {
					estado = 10;
					token.setIndice(indice);
					indice = indice + 1;
				} 
				break;	
			default:
				indice = arquivo.length;
				break;
			}

		}
		if (sb.length() >= 2) {
				if(bool){
				  throw new Erro("Erro Falta finalizar comentario");
				}
				token.setDescricao(sb.toString());
				token.setTipoToken(TipoToken.COMENTARIO);
					
				return token;
			
			
		}

		return null;

	}

}
