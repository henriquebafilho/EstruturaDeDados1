package lista02Exercicio01;

import filaCircularSimples.Fila;

public class Main {
	public static void main(String[] args) {
		Fila f1 = new Fila(3);
		f1.insere(1);
		f1.insere(2);
		f1.insere(3);
		Fila f2 = new Fila(3);
		f2.insere(4);
		f2.insere(5);
		f2.insere(6);

		combinaFilas(f1, f2);
	}

	public static void combinaFilas(Fila f1, Fila f2) {
		Fila filaMista = new Fila(f1.getTamanho() + f2.getTamanho());
		int elemento1, elemento2;

		// Adicionando os elementos das filas à fila mista
		for (int i = 0; i < filaMista.getTamanho(); i++) {
			elemento1 = f1.remove();
			elemento2 = f2.remove();
			if(elemento1 != Integer.MIN_VALUE) {
				filaMista.insere(elemento1);
			}
			if(elemento2 != Integer.MIN_VALUE) {
				filaMista.insere(elemento2);
			}
		}

		// Removendo elementos da fila mista (para mostrar como ela estava preenchida)
		for (int i = 0; i < filaMista.getTamanho(); i++) {
			System.out.print(filaMista.remove() + " ");
		}
	}
}
