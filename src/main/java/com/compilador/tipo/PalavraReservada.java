package com.compilador.tipo;

import java.util.ArrayList;
import java.util.List;

import com.compilador.Classificacao;
import com.compilador.modelo.TipoToken;
import com.compilador.modelo.Token;

public class PalavraReservada implements Classificacao{
	
	private static List<String> palavraReservada = new ArrayList<String>();
	
	public Token classificar(char[] arquivo, Integer indice) {
		int estado = 0;
		StringBuilder sb = new StringBuilder();
		this.alimentarpalavraReservadaaDePalavraReservada();
		
		while (indice <= arquivo.length - 1) {
			switch (estado) {
			case 0:
				if (Character.isLetter(arquivo[indice])) {
					estado = 1;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 1:
				if (Character.isLetter(arquivo[indice])) {
					estado = 1;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else if (arquivo[indice] == '_') {
					estado = 2;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			case 2:
				if (Character.isLetter(arquivo[indice])) {
					estado = 1;
					sb.append(arquivo[indice]);
					indice = indice + 1;
				} else {
					indice = arquivo.length;
				}
				break;
			default:
				break;
			}

		}
		if (sb.length() > 0 && palavraReservada.contains(sb.toString())) {
			Token token = new Token();
			token.setDescricao(sb.toString());
			token.setTipoToken(TipoToken.PALAVRA_RESEVADA);
				
			return token;
		}

		return null;

	}
	
	private void alimentarpalavraReservadaaDePalavraReservada() {
		palavraReservada.add("programa");
		palavraReservada.add("se");
		palavraReservada.add("entao");
		palavraReservada.add("senao");
		palavraReservada.add("enquanto");
		palavraReservada.add("faca");
		palavraReservada.add("ate");
		palavraReservada.add("repita");
		palavraReservada.add("inteiro");
		palavraReservada.add("real");
		palavraReservada.add("caractere");
		palavraReservada.add("caso");
		palavraReservada.add("escolha");
		palavraReservada.add("fim_escolha");
		palavraReservada.add("procedimento");
		palavraReservada.add("funcao");
		palavraReservada.add("de");
		palavraReservada.add("para");
		palavraReservada.add("leia");
		palavraReservada.add("imprima");
		palavraReservada.add("fim");
		palavraReservada.add("logico");
		palavraReservada.add("tipo");
		palavraReservada.add("e");
		palavraReservada.add("ou");
		palavraReservada.add("nao");
	}

}
