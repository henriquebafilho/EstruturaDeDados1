package lista02Exercicio08;

public class Fila08 {
	protected int tamanho;
	protected Object[] vetor;
	protected int ini;
	protected int n;

	public Fila08(int tam) {
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

	public boolean insere(Object elemento) {
		int fim;

		if ((!cheia()) && (elemento != null)) {
			fim = (ini + n) % tamanho;
			vetor[fim] = elemento;
			n++;
			return true;
		} else
			return false;
	}
}