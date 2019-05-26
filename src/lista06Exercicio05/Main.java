package lista06Exercicio05;

public class Main {

	public static void main(String[] args) {
		ConjGenerico<Integer> c1 = new ConjGenerico();
		ConjGenerico<Integer> c2 = new ConjGenerico();

		c1.insere(1);
		c1.insere(2);
		c1.insere(3);

		c2.insere(3);
		c2.insere(2);
		c2.insere(1);

		System.out.println(c1.igualdadeConjuntos(c2));

		// Analisar se são iguais a partir do conjunto que chamou a função
		/*
		 * int contador = 0; for(Elo p1 = this.prim; p1.prox != null; p1 = p1.prox) {
		 * for(Elo p2 = conj2.prim; p2.prox != null; p2 = p2.prox) { if(p1.dado ==
		 * p2.dado) { contador++; } } } if(this.tamanho() == contador) { return true;
		 * }else { return false; }
		 */
	}

}
