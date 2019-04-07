package lista02Exercicio05;

import pilha.PilhaGenerica;

public class FilaPreferencial extends FilaDupla {
	private PilhaGenerica<Pessoa> pilhaGenerica;

	public FilaPreferencial(int tam) {
		super(tam);
		pilhaGenerica = new PilhaGenerica<Pessoa>(tam);
	}

	public void inserePessoa(Pessoa pessoa) {
		if (!this.vazia()) {
			Pessoa ultima = this.removeFim();
			if (pessoa.getIdade() >= 60 && ultima.getIdade() < 60) {
				inserePessoa(pessoa);
				this.insere(ultima);
			} else {
				this.insere(ultima);
				this.insere(pessoa);

			}
		} else {
			this.insere(pessoa);
		}
	}

	public int[] retornaFila() {
		int[] fila = new int[this.getTamanho()];
		for (int i = 0; i <= (ini + n - 1) % tamanho; i++) {
			fila[i] = this.remove().getIdade();
		}
		return fila;
	}
}
