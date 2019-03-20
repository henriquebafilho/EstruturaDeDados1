import java.util.*;

public class Pilha {

	private int tamanho;
	private char topo;
	private Vector<Character> vetor;

	public Pilha() {

	}
	
	public Pilha(int n) {
		tamanho = n;
	}
	
	public void push(char elemento){
		vetor.add(elemento);
		topo = elemento;
	}
	
	public void pop(char elemento) {
		vetor.remove(elemento);
		topo = vetor.get(vetor.size()-1);
	}
	
	public void adicionaPilha(String frase) {
		for(char letra : frase.toCharArray()) {
			vetor.add(letra);
		}
	}
	
	public void retornaPilha() {
		for(char elemento : vetor) {
			System.out.println(vetor);
		}
	}

}
