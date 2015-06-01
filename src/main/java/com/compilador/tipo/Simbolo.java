package com.compilador.tipo;

import java.util.ArrayList;
import java.util.List;

import com.compilador.Classificacao;
import com.compilador.modelo.TipoToken;
import com.compilador.modelo.Token;

public class Simbolo implements Classificacao{
	
	private static List<Character> simbolo = new ArrayList<Character>();
	
	public Token classificar(char[] arquivo, Integer indice) {
		int estado = 0;
		StringBuilder sb = new StringBuilder();
		this.alimentarsimboloaDesimbolo();
		
		while (indice <= arquivo.length - 1) {
			switch (estado) {
			case 0:
				if (simbolo.contains(arquivo[indice])) {
					estado = 100;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else if (arquivo[indice] == ':') {
					estado = 2;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else if (arquivo[indice] == '<') {
					estado = 4;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else if (arquivo[indice] == '>') {
					estado = 2;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else if (arquivo[indice] == '+') {
					estado = 8;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else if (arquivo[indice] == '-') {
					estado = 10;
					sb.append(arquivo[indice]);
					indice = indice + 1;	
				} else {
					indice = arquivo.length;
				}
				break;
			case 2:
				if (arquivo[indice] == '=') {
					estado = 100;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 4:
				if (arquivo[indice] == '>' || arquivo[indice] == '=') {
					estado = 100;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 8:
				if (arquivo[indice] == '+') {
					estado = 100;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 10:
				if (arquivo[indice] == '-') {
					estado = 100;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			default:
				indice = arquivo.length;
				break;
			}

		}
		if (sb.length() > 0) {
			Token token = new Token();
			token.setDescricao(sb.toString());
			token.setTipoToken(TipoToken.SIMBOLO_ESPECIAL);
				
			return token;
		}

		return null;

	}
	
	private void alimentarsimboloaDesimbolo() {
		simbolo.add('.');
		simbolo.add(',');
		simbolo.add(';');
		simbolo.add('*');
		simbolo.add('(');
		simbolo.add(')');
		simbolo.add('{');
		simbolo.add('}');
		simbolo.add('/');
		simbolo.add('@');
		simbolo.add('=');	}

}
