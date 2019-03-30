package lista01Exercicio04;

public class Frase {
	PilhaGenerica<Pilha> pilhaPalavras;
	
	public static void main(String[] args) {
		Frase pilhaLetras = new Frase("A maçã está podre");
		
		System.out.println(pilhaLetras.invertePalavra());
	}

	public Frase(String texto) {
		String[] palavras = texto.split(" ");
		pilhaPalavras = new PilhaGenerica<>(palavras.length);
		
		for(String palavra : palavras) {
			Pilha pilhaPalavra = new Pilha(palavra.length());
			for(char h : palavra.toCharArray()) {
				pilhaPalavra.push(h);
			}
		pilhaPalavras.push(pilhaPalavra);
		}
	}
	
	public String invertePalavra() {
		String palavra = fraseInvertida(this.pilhaPalavras.pop());
		if(pilhaPalavras.vazia()) {
			return palavra;
		}
		
		return invertePalavra() + " " + palavra;
	}
	
	private String fraseInvertida(Pilha p) {
		String palavra = "";
		while(!p.vazia()) {
			palavra += p.pop();
		}
		return palavra;
	}
}
