package L01E03;

import java.util.*;

public class Parenteses {

	private static char[] abridores = { '(', '[', '{' };
	private static char[] fechadores = { ')', ']', '}' };
	Pilha pilha = new Pilha();
	String txt;

	Parenteses(String texto) {
		this.pilha = new Pilha(texto.length());
		this.txt = texto;
	}

	public static void main(String[] args) {
		Parenteses sequencia1 = new Parenteses("[()]{}{[()()]()}");
		Parenteses sequencia2 = new Parenteses("[(])");

		System.out.println("Sequência 1: "+sequencia1.avaliaParenteses());
		System.out.println("Sequência 2: "+sequencia2.avaliaParenteses());

	}

	public boolean avaliaParenteses() {
		for (char j : this.txt.toCharArray()) {
			if (indexOf(j, abridores) > -1) {
				pilha.push(j);
			} else if (indexOf(j, fechadores) > -1) {
				int i = indexOf(j, fechadores);

				if (abridores[i] != pilha.pop()) {
					return false;
				}
			}
		}
		return true;
	}

	private static int indexOf(char j, char[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == j) {
				return i;
			}
		}
		return -1;
	}
}
