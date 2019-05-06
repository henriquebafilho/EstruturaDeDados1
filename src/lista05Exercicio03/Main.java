package lista05Exercicio03;

import listaDuplamente.*;

public class Main {

	public static void main(String[] args) {
		ListaDuplamente lista = new ListaDuplamente();
		
		lista.insere(9);
		lista.insere(53);
		lista.insere(51);
		lista.insere(12);
		lista.insere(15);
		
		lista.trocaElos(1, 4);
		
		lista.imprime();
	}
}
