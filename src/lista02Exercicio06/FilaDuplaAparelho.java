package lista02Exercicio06;

import pilha.PilhaGenerica;

public class FilaDuplaAparelho extends FilaAparelho {
	private PilhaGenerica<Object> pilha;

	public FilaDuplaAparelho(int tam) {
		super(tam);
		pilha = new PilhaGenerica<Object>(tam);
	}

	public boolean insereInicio(Object objeto) {
		int primeiro;

		if (!cheia()) {
			primeiro = (ini - 1 + tamanho) % tamanho;
			vetor[primeiro] = objeto;
			ini = primeiro;
			n++;
			return true;
		} else
			return false;
	}

	public Object removeFim() {
		Object elemento = null;
		int ultimo;

		if (!this.vazia()) {
			ultimo = (ini + n - 1) % tamanho;
			elemento = vetor[ultimo];
			n--;
		}
		return elemento;
	}

	public void insereSmartphone(Smartphone smartphone) {
		if (this.vazia()) {
			this.insere(smartphone);
		} else {
			Object primeiro = this.remove();
			if (primeiro instanceof Tablet) {
				this.insereInicio(primeiro);
				this.insereInicio(smartphone);
			} else if (((Smartphone) primeiro).getPreco() > smartphone.getPreco()) {
				this.insereInicio(primeiro);
				this.insereInicio(smartphone);
			} else {
				this.insereSmartphone(smartphone);
				this.insereInicio(primeiro);
			}
		}
	}

	public void insereTablet(Tablet tablet) {
		if (this.vazia()) {
			this.insere(tablet);
		} else {
			Object ultimo = this.removeFim();
			if (ultimo instanceof Smartphone) {
				this.insere(ultimo);
				this.insere(tablet);
			} else if (((Tablet) ultimo).getPreco() < tablet.getPreco()) {
				this.insere(ultimo);
				this.insere(tablet);
			} else {
				this.insereTablet(tablet);
				this.insere(ultimo);
			}
		}
	}
}
