package lista05Exercicio03;

public class ListaDuplamente {
	/* Referência para primeiro elemento */
	protected Elo prim;

	protected class Elo {
		protected int dado;
		protected Elo ant;
		protected Elo prox;

		public Elo() {
			ant = null;
			prox = null;
		}

		public Elo(int elem) {
			dado = elem;
			ant = null;
			prox = null;
		}

		public Elo(int elem, Elo antElem, Elo proxElem) {
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}
	}

	public ListaDuplamente() {
		prim = null;
	}

	/* Testa se a lista está vazia. */
	public boolean vazia() {
		return prim == null;
	}

	/* Insere elemento no início da lista. */
	public void insere(int novo) {
		Elo p;

		p = new Elo(novo);

		p.prox = prim;

		p.ant = null;

		if (prim != null)
			prim.ant = p;

		prim = p;
	}

	/* Método auxiliar para busca. */
	private Elo busca(int elem) {
		Elo p = null;

		for (p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
			;

		return p;
	}

	/*
	 * Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se
	 * removeu.
	 */
	public boolean remove(int elem) {
		Elo p = null;
		p = busca(elem);

		if (p == null)
			return false;

		/* Retira primeiro elemento */
		if (p == prim)
			prim = prim.prox;
		else
			/* Retira elemento do meio */
			p.ant.prox = p.prox;

		/* Testa se é ultimo elemento */
		if (p.prox != null)
			p.prox.ant = p.ant;

		p = null;

		return true;
	}

	/* Imprime todos os elementos da lista. */
	public void imprime() {
		Elo p;

		System.out.println("Elementos da lista:");

		for (p = prim; p != null; p = p.prox) {
			System.out.print(p.dado + " ");
		}

		System.out.println();
	}

	/* Imprime todos os elementos da lista em ordem reversa. */
	public void imprimeReversa() {
		Elo p;
		Elo ult = null;

		System.out.println("Elementos da lista em ordem reversa:");

		p = prim;

		while (p != null) {
			ult = p;
			p = p.prox;
		}

		for (p = ult; p != null; p = p.ant) {
			System.out.print(p.dado + " ");
		}

		System.out.println();
	}

	/*
	 * 3) Crie na classe ListaDuplamente um método public void trocaElos(int
	 * indiceElo1, int indiceElo2) que troque a posição de dois elos cujas posições
	 * na lista foram dadas.
	 */
	public void trocaElos(int indiceElo1, int indiceElo2) {
		Elo p = prim, p1 = null, p2 = null, p1prox = null, p2prox = null;
		int indice = 0;

		//identificando os elos dos índices
		while (p != null) {
			indice += 1;

			if (indice == indiceElo1) {
				p1 = p;
				p1prox = p.prox;
			}
			if (indice == indiceElo2) {
				p2 = p;
				p2prox = p.prox;
			}
			p = p.prox;
		}
		//testando qual situação se encaixa para fazer a troca entre os elos
		//se forem consecutivos
		if (indiceElo1 == indiceElo2 - 1) {
			//se o primeiro indice for 1
			if(indiceElo1 == 1) {
				p1.prox = p2.prox;
				prim = p2;
				p2.prox = p1;
			}else {
				p1.ant.prox = p2;
				p2.ant.prox = p2.prox;
				p2.prox = p1;
			}
		}
		//se não forem consecutivos
		else {
			//se o índice for um
			if(indiceElo1 == 1) {
				//se for o primeiro e o último
				if(indiceElo2 == indice) {
					p2.ant.prox = p1;
					p2.prox = p1.prox;
					p1.prox = null;
					prim = p2;
				}
				//se for o primeiro e outro qualquer
				else {
					p2.prox = p1.prox;
					p2.ant.prox = p1;
					p1.prox = p2prox;
					prim = p2;
				}
			}//se forem outros quaisquer
			else {
				p1.ant.prox = p2;
				p2.ant.prox = p1;
				p1.prox = p2.prox;
				p2.prox = p1prox;
			}
		}
	}
}