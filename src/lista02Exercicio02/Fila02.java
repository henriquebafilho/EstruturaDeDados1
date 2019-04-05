package lista02Exercicio02;

import filaCircularSimples.*;
import pilha.*;

public class Fila02 extends Fila {

	public static int tamanho;

	public Fila02(int tamanho) {
		super(tamanho);
	}

	public void insereFila(Pilha insercao) {
		Pilha remocao = new Pilha(insercao.getTamanho());

		// Passando os elementos da pilha 1 para a pilha 2 (elementos ficarão invertidos
		// e na ordem da fila)
		while (!insercao.vazia()) {
			remocao.push(insercao.pop());
		}
		
		//inserindo os elementos na Fila02
		while (!remocao.vazia()) {
			insere(remocao.pop());
		}
	}
	public void mostraPilha() {
		while(!vazia()) {
			System.out.print((char)remove()+" ");
		}
	}
}
