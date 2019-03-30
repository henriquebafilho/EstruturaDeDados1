package Lista01Exercicio05;

import java.util.*;

public class PilhaGenericaTamanhoDinamico<T> {
	private Vector<T> vetor;
	protected int topo;

	public PilhaGenericaTamanhoDinamico() {
		vetor = new Vector<T>();
		topo = -1;
	}

	public Vector<T> getVetor() {
		return vetor;
	}

	public int getTopo() {
		return topo;
	}

	public boolean vazia() {
		return topo == -1 ? true : false;
	}

	public T pop() {
		T elemento;

		if (!this.vazia()) {
			elemento = vetor.remove(topo--);
			return elemento;
		} else {
			return null;
		}
	}

	public void push(T elemento) {
		vetor.add(++topo, elemento);
	}

	public T retornaTopo() {

		if(this.vazia()) {
			return null;
		}else {
			return vetor.get(topo);
		}
	}
}
