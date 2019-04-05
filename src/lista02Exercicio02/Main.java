package lista02Exercicio02;

import filaCircularSimples.*;
import pilha.*;

public class Main {
	public static void main(String[] args) {
		Pilha pilha = new Pilha(5);
		Fila02 fila = new Fila02(pilha.getTamanho());
		
		// inserindo elementos na pilha 1
		pilha.push('a');
		pilha.push('b');
		pilha.push('c');
		pilha.push('d');
		pilha.push('e');
		
		fila.insereFila(pilha);
		fila.mostraPilha();
	}

}
