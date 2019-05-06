package lista05Exercicio06;

public class ListaCircular extends Lista {
	/* Imprime todos os elementos da lista */
	public void imprime() {
		Elo p;
		System.out.println("Elementos da lista");

		p = prim;

		if (p != null) {
			do {
				System.out.print(p.dado + " ");
				p = p.prox;

			} while (p != prim);
		}

		System.out.println();
	}

	public void imprimeRecursivo() {
		System.out.println("Elementos da lista:");

		if (this.vazia())
			return;

		imprimeRecursivo(prim);

		System.out.println();
	}

	private void imprimeRecursivo(Elo p) {
		System.out.print(p.dado + " ");

		if (p.prox == prim)
			return;

		imprimeRecursivo(p.prox);
	}

	/* Insere elemento no fim da lista. */
	public void insere(int novo) {
		Elo p, q;
		q = new Elo(novo);
		p = prim;

		if (p != null) {
			/* Percorre até alcancar o início. */
			while (p.prox != prim) {
				p = p.prox;
			}

			p.prox = q;
			q.prox = prim;
		} else {
			prim = q;
			prim.prox = q;
		}
	}

	public boolean remove(int elem) {
		Elo p = null;
		Elo ant = null;

		if (prim == null)
			return false;

		for (p = prim; ((p.prox != prim) && (p.dado != elem)); p = p.prox)
			ant = p;

		/* Achou */
		if (p.dado == elem) {
			/* É o primeiro */
			if (p == prim) {
				/* É o único */
				if (prim == prim.prox) {
					prim = null;
				} else {
					/* Guarda o anterior ao primeiro */
					for (ant = prim; (ant.prox != prim); ant = ant.prox)
						;

					ant.prox = prim.prox;
					prim = prim.prox;
				}
			} else {
				/* No meio */
				ant.prox = p.prox;
			}

			/*
			 * Remove a última referência para o elo a ser removido. Dessa forma, o Garbage
			 * Collector irá liberar essa memória.
			 */
			p = null;

			return true;
		} else
			return false;
	}

	/*
	 * Na classe de Lista Circular, crie um método para concatenar alternadamente
	 * elementos das listas dadas como argumentos do método. Use o esqueleto “public
	 * void mergeListaCircular(ListaCircular lista1, ListaCircular lista2){}”
	 */
	public static ListaCircular mergeListaCircular(ListaCircular lista1, ListaCircular lista2) {
		ListaCircular resultado = new ListaCircular();

		Elo p, q;
		int cont = 0;
		boolean alterna = false;

		p = lista1.prim;
		q = lista2.prim;

		while (cont > -1) {
			if (p == null && q == null) {
				break;
			}
			if (p == lista1.prim && q == lista2.prim && alterna == true) {
				break;
			}
			if (alterna == false) {
				if (q != null) {
					resultado.insere(q.dado);
					q = q.prox;
				}
				if (p != null) {
					resultado.insere(p.dado);
					p = p.prox;
				}
				alterna = true;
			}
			if (p != lista1.prim) {
				resultado.insere(p.dado);
				p = p.prox;
			}
			if (q != lista2.prim) {
				resultado.insere(q.dado);
				q = q.prox;
			}
		}
		return resultado;
	}
}