package lista02Exercicio06;

import filaCircularDupla.*;
import filaCircularSimples.*;

public class FilaAparelho {
	protected int tamanho;
	protected Object[] vetor;
	protected int ini;
	protected int n;

	public FilaAparelho(int tam) {
		tamanho = tam;
		vetor = new Object[tamanho];
		ini = 0;
		n = 0;
	}

	public boolean vazia() {
		return (n == 0);
	}

	public boolean cheia() {
		return (n == tamanho);
	}

	public Object remove() {
		Object elemento = null;

		if (!this.vazia()) {
			elemento = vetor[ini];
			ini = (ini + 1) % tamanho;
			n--;
		}

		return elemento;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public boolean insere(Object elemento) {
		int fim;

		if (!cheia()) {
			fim = (ini + n) % tamanho;
			vetor[fim] = elemento;
			n++;
			return true;
		} else
			return false;
	}
}
