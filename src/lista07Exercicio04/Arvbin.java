package lista07Exercicio04;

public class Arvbin<T extends Comparable<T>> {
	private T val; /* Valor armazenado na raiz. */

	/* Referências para sub-árvores. */
	private Arvbin<T> esq, dir;

	/*
	 * Construtor de árvore sem sub-ávores (dir = esq = null). É fornecido apenas o
	 * valor da raiz.
	 */
	public Arvbin(T valor) {
		val = valor;
		esq = null;
		dir = null;
	}

	/*
	 * Construtor de árvore com sub-ávores. São fornecidos o valor da raiz e as
	 * sub-árvores, que devem ter sido construídas previamente.
	 */
	public Arvbin(T valor, Arvbin<T> arvEsq, Arvbin<T> arvDir) {
		val = valor;
		esq = arvEsq;
		dir = arvDir;
	}

	/* Retorna o valor armazenado na raiz. */
	public T retornaVal() {
		return val;
	}

	/*
	 * Retorna a sub-árvore esquerda (ou null se não houver).
	 */
	public Arvbin<T> retornaEsq() {
		return esq;
	}

	/*
	 * Retorna a sub-árvore direita (ou null se não houver).
	 */
	public Arvbin<T> retornaDir() {
		return dir;
	}

	/* Modifica o valor armazenado na raiz. */
	public void defineVal(T valor) {
		val = valor;
	}

	/* Redefine a sub-árvore esquerda, apagando a antiga se houver. */
	public void defineEsq(Arvbin<T> filho) {
		esq = filho;
	}

	/* Redefine a sub-árvore direita, apagando a antiga se houver. */
	public void defineDir(Arvbin<T> filho) {
		dir = filho;
	}

	/* Imprime o conteúdo da árvore em pré-ordem */
	public void mostra() {
		System.out.print("(" + val);
		if (esq != null)
			esq.mostra();
		if (dir != null)
			dir.mostra();
		System.out.print(")");
	}

	/* Calcula e retorna o número de nós na árvore. */
	public int contaNos() {
		if ((esq == null) && (dir == null))
			return 1;

		int nosEsq = 0, nosDir = 0;

		if (esq != null)
			nosEsq = esq.contaNos();

		if (dir != null)
			nosDir = dir.contaNos();

		return 1 + nosEsq + nosDir;
	}

	/* Calcula e retorna a altura da árvore. */
	public int calculaAltura() {
		if ((esq == null) && (dir == null))
			return 0;

		int altEsq = 0, altDir = 0;

		if (esq != null)
			altEsq = esq.calculaAltura();

		if (dir != null)
			altDir = dir.calculaAltura();

		return 1 + Math.max(altEsq, altDir);
	}

	/* Calcula e retorna o maior valor contido na árvore. */
	public T calculaMaximo() {
		if ((esq == null) && (dir == null))
			return val;

		T maiorFilhos, maiorEsq, maiorDir;

		if ((esq != null) && (dir == null)) {
			maiorFilhos = esq.calculaMaximo();
		} else if ((esq == null) && (dir != null)) {
			maiorFilhos = dir.calculaMaximo();
		} else {
			maiorEsq = esq.calculaMaximo();
			maiorDir = dir.calculaMaximo();

			if (maiorEsq.compareTo(maiorDir) > 0)
				maiorFilhos = maiorEsq;
			else
				maiorFilhos = maiorDir;
		}

		if (maiorFilhos.compareTo(val) > 0)
			return maiorFilhos;

		return val;
	}

	/* Calcua a soma dos valores dos nós de uma árvore de inteiros. */
	public static int calculaSoma(Arvbin<Integer> no) {
		if (no == null)
			return 0;

		int acumulado = 0;

		acumulado += calculaSoma(no.esq);

		acumulado += calculaSoma(no.dir);

		acumulado += no.val;

		return acumulado;
	}

	/*
	 * Calcula e retorna o diâmetro da árvore, isto é, o número de nós contido no
	 * maior caminho de um nó para outro nó da árvore.
	 */
	public int calculaDiametro() {
		/* Caso base, quando é uma folha. */
		if ((esq == null) && (dir == null)) {
			return 1;
		}

		/* Calcula a altura das sub-árvores esquerda e direita do nó. */
		int alturaEsq = 0, alturaDir = 0;

		if (esq != null)
			alturaEsq = esq.calculaAltura();

		if (dir != null)
			alturaDir = dir.calculaAltura();

		int maxDistanciaNo = alturaEsq + alturaDir + 1;

		/*
		 * Nesse ponto, temos a maior distância entre dois nós da árvore que passa pelo
		 * nó corrente (this). Agora devemos calcular esse valor para as sub-árvores
		 * esquerda e direita, comparando depois.
		 */

		int maxDistanciaEsq = 0, maxDistanciaDir = 0;

		if (esq != null)
			maxDistanciaEsq = esq.calculaDiametro();

		if (dir != null)
			maxDistanciaDir = dir.calculaDiametro();

		int maxDistanciaFilhos = Math.max(maxDistanciaEsq, maxDistanciaDir);

		if (maxDistanciaNo > maxDistanciaFilhos)
			return maxDistanciaNo;
		else
			return maxDistanciaFilhos;
	}

	/*
	 * Verifica se um valor está na árvore. Se estiver, retorna um ponteiro para o o
	 * nó que tem esse valor. Caso contrário, retorna null.
	 */
	public Arvbin<T> busca(T valor) {
		Arvbin<T> ret;

		System.out.println("valor atual: " + val);

		/*
		 * Se é igual ao valor armazenado, não precisa procurar mais. O nó é a raiz.
		 */
		if (valor.compareTo(val) == 0) {
			return this;
		}

		/* Senão, começa procurando na sub-árvore esquerda. */
		if (esq != null) {
			ret = esq.busca(valor);
			if (ret != null)
				return ret;
		}

		/*
		 * Se chega a esse ponto, estará na árvore se, e somente se, estiver na
		 * sub-árvore direita
		 */
		if (dir != null)
			return dir.busca(valor);
		return null;

	}

	public int contaNosIntervalo(T min, T max) {
		int contador = 0;

		if (this.val.compareTo(min) >= 0 && this.val.compareTo(max) <= 0) {
			contador++;
		}

		int nosEsq = 0, nosDir = 0;

		if (esq != null) {
			nosEsq = esq.contaNosIntervalo(min, max);
		}

		if (dir != null) {
			nosDir = dir.contaNosIntervalo(min, max);
		}

		return contador + nosDir + nosEsq;
	}

	public boolean eIgual(Arvbin outra) {

		System.out.println("this: " + val);
		System.out.println("outra: " + outra.val);

		if (outra.val.compareTo(val) != 0) {
			System.out.println("deu ruim aqui");
			return false;
		}

		if (esq != null) {
			if (!esq.eIgual(outra.esq)) {
				return false;
			}
		}

		if (dir != null) {
			if (!dir.eIgual(outra.dir)) {
				return false;
			}
		}
		return true;
	}

	public boolean eFolha(Arvbin no) {
		if (no.esq == null && no.dir == null) {
			return true;
		}
		return false;
	}

	public Arvbin criaNovaArvore(T valor) {
		Arvbin<T> novaArvore = new Arvbin<T>(null);

		// se o valor for o atual
		if (this.val.compareTo(valor) == 0) {
			// Um nó só pode ter filho único se for à esquerda
			if (esq == null || eFolha(this)) {
				this.defineEsq(novaArvore);
			} else if (dir == null) {
				this.defineDir(novaArvore);
			} else if (esq != null && dir != null) {
				System.out.println("Erro: O nó já tem um filho à esquerda e à direita.");
				return null;
			}
			return novaArvore;
		}

		if(esq != null) {
			novaArvore = esq.criaNovaArvore(valor);
		}
		
		if(dir != null) {
			novaArvore = dir.criaNovaArvore(valor);
		}

		return novaArvore;
	}
}