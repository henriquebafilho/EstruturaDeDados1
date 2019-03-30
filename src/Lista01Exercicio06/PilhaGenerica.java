package Lista01Exercicio06;

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

	public Vector<T> getVetor() {
		return vetor;
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

	public void armazenaTexto(String texto) {
		PilhaGenerica<PilhaGenerica> pilhaPrincipal = new PilhaGenerica<>(texto.length());

		String[] palavras = texto.split(" ");

		for (int i = 0; i < palavras.length; i++) {
			PilhaGenerica<String> pilhaSecundaria = new PilhaGenerica<>(texto.length());
			while (!pilhaSecundaria.vazia()) {
				pilhaSecundaria.pop();
			}
			char[] letras = palavras[i].toCharArray();
			for (char aux : letras) {
				String letra = Character.toString(aux);
				pilhaSecundaria.push(letra);
			}
			pilhaPrincipal.push(pilhaSecundaria);
			
			//mostra as pilhas secundárias com as palavras separadas pro letras
			System.out.println(pilhaSecundaria.getVetor());
		}
		//mostra a pilha principal, cujos elementos são pilhas secundárias
		System.out.println(pilhaPrincipal.getVetor());
	}

	public String retornaTextoOriginal() {
		return "";
	}

	public String retornaTexto() {
		return "";
	}
}