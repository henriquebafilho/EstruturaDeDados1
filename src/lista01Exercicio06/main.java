package lista01Exercicio06;

import java.util.*;

public class main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String frase;
		
		System.out.println("Insira uma frase: ");
		frase = entrada.nextLine();
		
		PilhaGenerica pilha = new PilhaGenerica(frase.length());
		
		pilha.armazenaTexto(frase);
		System.out.println(pilha.retornaTextoOriginal());
		
	}

}
