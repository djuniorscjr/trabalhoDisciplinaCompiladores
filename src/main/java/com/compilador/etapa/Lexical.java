package com.compilador.etapa;

import java.util.ArrayList;
import java.util.List;

import com.compilador.modelo.TipoToken;
import com.compilador.modelo.Token;
import com.compilador.tipo.Comentario;
import com.compilador.tipo.Identificador;
import com.compilador.tipo.PalavraReservada;
import com.compilador.tipo.Simbolo;

public class Lexical {

	private char[] arquivo;
	private List<Token> tokens;
	private Integer indice;
	private Integer max;
	private Boolean encontrou;
	private Token token;

	public Lexical(char[] arquivo) {
		this.arquivo = arquivo;
		this.tokens = new ArrayList<Token>();
		indice = 0;
		max = arquivo.length - 1;
		encontrou = false;
	}

	public Token getToken() {

		while (indice <= max) {
			if (arquivo[indice] == '\n' || arquivo[indice] == '\r'
					|| arquivo[indice] == '\t'
					|| Character.isSpaceChar(arquivo[indice])) {
				indice++;
			} else {

				token = new Token();

				Comentario comentario = new Comentario();
				token = comentario.classificar(arquivo, indice);
				if (token == null) {
					Identificador identificador = new Identificador();
					token = identificador.classificar(arquivo, indice);
					if (token == null) {
						PalavraReservada palavraReservada = new PalavraReservada();
						token = palavraReservada.classificar(arquivo, indice);
						if (token == null) {
							Simbolo simbolo = new Simbolo();
							token = simbolo.classificar(arquivo, indice);

							if (token == null) {
								StringBuilder sb = new StringBuilder();
								sb.append(arquivo[indice]);
								token = new Token();
								token.setDescricao(sb.toString());
								token.setTipoToken(TipoToken.NAO_IDENTIFICADO);
								tokens.add(token);
								indice++;
							} else {
								indice = indice + token.getDescricao().length();
								tokens.add(token);
							}

						} else {
							indice = indice + token.getDescricao().length();
							tokens.add(token);
						}
					} else {
						indice = indice + token.getDescricao().length();
						tokens.add(token);
					}
				} else {
					indice = token.getIndice() + 1;
					tokens.add(token);
				}
			}
		}
		for (Token token1 : tokens) {
			System.out.println(token1.getTipoToken().getDecricao() + " - "
					+ token1.getDescricao());

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

	public void setToken(Token token) {
		this.token = token;
	}

}
