package lista01Exercicio01;

import java.util.Vector;

public class PilhaGenerica<T> {
	private int n;
	private Vector<T> vetor;
	private int topo;

	public PilhaGenerica(int tamanho) {
		n = tamanho;
		vetor = new Vector<T>(tamanho);
		topo = -1;
	}

	public boolean vazia() {
		return topo == -1 ? true : false;
	}

	public boolean cheia() {
		return topo == n - 1 ? true : false;
	}

	public T pop() {
		T elemento;

		if (!this.vazia()) {
			elemento = vetor.get(topo--);
			return elemento;
		} else {
			// Impressão para fins didáticos
			System.out.println("Pilha vazia: pop nao funcionou.");
			return null;
		}
	}

	public boolean push(T elemento) {
		if (!this.cheia()) {
			vetor.add(++topo, elemento);
			return true;
		} else {
			// Impressão para fins didáticos
			System.out.println("Pilha cheia: push nao funcionou.\n");
			return false;
		}
	}

	public boolean retornaTopo(T elemento) {
		if (!this.vazia()) {
			elemento = vetor.get(topo);
			return true;
		} else
			return false;
	}

	public Vector<T> getVetor() {
		return vetor;
	}

	public int getTamanho() {
		return n;
	}

	// 1) a. i.
	public void transferePilha(PilhaGenerica<T> p) {
		if (!p.vazia()) {
			PilhaGenerica<T> pilhaAux = new PilhaGenerica<>(p.getTamanho());

			while (!p.vazia()) {
				pilhaAux.push(p.pop());
			}
			while (!pilhaAux.vazia()) {
				p.push(pilhaAux.pop());
			}
		}
	}

	// 1) a. ii.
	public void transferePilhaRecursivo(PilhaGenerica<T> p) {
		if (!p.vazia()) {
			this.push(p.pop());
			transferePilhaRecursivo(p);
		}
	}

	// 1) b
	public void revertePilha() {
		PilhaGenerica<T> auxiliar = new PilhaGenerica<>(this.n);
		while (!this.vazia()) {
			auxiliar.push(this.pop());
		}
		System.out.println("Pilha invertida: " + auxiliar.getVetor());
	}
}