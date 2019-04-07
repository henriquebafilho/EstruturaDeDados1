package lista02Exercicio08;

import lista02Exercicio06.*;
import pilha.*;

public class Exercicio08 extends Fila08 {
	private Pilha pilha;
	private Pilha pilhaInversa;

	public Exercicio08(int tam) {
		super(tam);
		this.pilha = new Pilha(tam);
		this.pilhaInversa = new Pilha(tam);
	}

	public void insereproduto(Smartphone smartphone) {
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
				this.insereproduto(smartphone);
				this.insereInicio(primeiro);
			}
		}
	}

	public void insereproduto(Tablet tablet) {
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
				this.insereproduto(tablet);
				this.insere(ultimo);
			}
		}
	}

	public Object removeFim() {
		Object ultimo = null;

		if (n == 1) {
			ultimo = this.remove();
		} else {
			Object[] elementosOrdenados = new Object[n];

			for (int i = 0; i < elementosOrdenados.length; i++) {
				elementosOrdenados[i] = this.remove();
			}
			for (int i = 0; i < elementosOrdenados.length - 1; i++) {
				this.insere(elementosOrdenados[i]);
			}
			ultimo = elementosOrdenados[elementosOrdenados.length - 1];
		}
		return ultimo;
	}

	public void insereInicio(Object elemento) {
		if (this.vazia()) {
			this.insere(elemento);
		} else {
			Object[] elementosOrdenados = new Object[n + 1];
			for (int i = 1; i < elementosOrdenados.length; i++) {
				elementosOrdenados[i] = this.remove();
			}
			elementosOrdenados[0] = elemento;
			for (int i = 0; i < elementosOrdenados.length; i++) {
				this.insere(elementosOrdenados[i]);
			}
		}

	}
}
