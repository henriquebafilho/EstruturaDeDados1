package L01E05;

import java.util.*;

public class pilhaNumerica extends PilhaGenericaTamanhoDinamico<Integer> {
	private PilhaGenericaTamanhoDinamico<Integer> pilhaDinamica;

	public static void main(String args[]) {
		pilhaNumerica pilha = new pilhaNumerica();

		pilha.ordenaPilha(13);
		pilha.ordenaPilha(95);
		pilha.ordenaPilha(89);
		pilha.ordenaPilha(56);
		pilha.ordenaPilha(45);
		pilha.ordenaPilha(53);
		pilha.ordenaPilha(85);
		pilha.ordenaPilha(32);
		pilha.ordenaPilha(44);
		pilha.ordenaPilha(56);

		System.out.println(pilha.getVetor());
	}

	public pilhaNumerica() {
		this.pilhaDinamica = new PilhaGenericaTamanhoDinamico<Integer>();
	}

	public void ordenaPilha(int numero) {
		if (!this.vazia() && numero < super.retornaTopo()) {
			do {
				pilhaDinamica.push(super.pop());
			} while (numero < super.retornaTopo());
			super.push(numero);
			while (!pilhaDinamica.vazia()) {
				super.push(pilhaDinamica.pop());
			}

		} else {
			super.push(numero);
		}

	}
}