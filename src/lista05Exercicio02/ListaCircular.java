package lista05Exercicio02;

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

	// 2) Faça um método que inverta a ordem de uma lista circular e retorne o
	// primeiro elo
	// da lista invertida. Use o esqueleto: public Elo inverteLista(){}
	public Elo inverteLista() {
		Elo ant, p, ult;
		if (prim == null) {
			System.out.print("Lista vazia");
			return null;
		}
		ult = prim;
		ant = prim;
		p = prim.prox;
		prim = prim.prox;
		while (prim != ult) {
			prim = prim.prox;
			p.prox = ant;
			ant = p;
			p = prim;
		}
		p.prox = ant;
		prim = ant;
		return prim;

	}
}