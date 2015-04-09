package com.compilador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.compilador.etapa.Sintatica;
import com.compilador.etapa.Lexical;
import com.compilador.modelo.Token;

public class Main {
	
	public static void main(String[] args) throws IOException{
		String readArquivo = new String(Files.readAllBytes(Paths.get("C:/Users/Domingos Junior/Desktop/texto.txt")));
		char[] charArray = readArquivo.toCharArray();
		
		Lexical lexico = new Lexical(charArray);
		Token token = lexico.getToken();
		Sintatica sintatico = new Sintatica();
		
	}
}
