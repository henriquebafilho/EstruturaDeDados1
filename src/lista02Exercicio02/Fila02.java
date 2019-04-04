package lista02Exercicio02;

import filaCircularSimples.*;
import pilha.*;

public class Fila02 extends Fila{
	
	public static Pilha pilha1 = new Pilha(5);
	public static Pilha pilha2 = new Pilha(5);
	public static Fila02 fila = new Fila02(5);
	
	public Fila02(int tamanho) {
		super(5);
	}

	public static void main(String[] args) {
		//inserindo elementos na pilha 1
		pilha1.push('a');
		pilha1.push('b');
		pilha1.push('c');
		pilha1.push('d');
		pilha1.push('e');
		
		//Passando os elementos da pilha 1 para a pilha 2 (elementos ficarão invertidos e na ordem da fila)
		while(!pilha1.vazia()) {
			pilha2.push(pilha1.pop());
		}
		
		while(!pilha2.vazia()) {
			fila.insere(pilha2.pop());
		}
		
		//retornando elementos da fila
		while(!fila.vazia()) {
			System.out.print(fila.remove()+" ");
		}
	}

}
