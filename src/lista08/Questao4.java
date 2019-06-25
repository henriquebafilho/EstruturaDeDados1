package lista08;

public class Referencia <extends Comparable<T>>{

  private int prioridade;
  private String acao;  
  

public int compareTo(Referencia heapref){
    
    if(this.prioridade > heapref.getPrioridade()){
      return 1;
    }
  	if(this.prioridade == heapref.getPrioridade()){
      return 0;
    }
  	if(this.prioridade < heapref.getPrioridade()){
      return -1;
    }
    
  }

  public int getPrioridade() {

      return this.prioridade;

  }
  
  public String getAcao() {
    
    return acao;
    
  }
  
}


public class ReferenciaSO extends Referencia{
  
    public ReferenciaSO(int prio, String acao){

        prioridade = 1000 + prio;
        this.acao = acao;
    }

}


public class ReferenciaAPP extends Referencia{

    public ReferenciaAPP(int prio, String acao){
      
      prioridade = prio;
    	this.acao = acao;
    }
}

public class BinMaxHeap<T>{
	private int n;               /* Numero de elementos no heap. */   
	private int tam;             /* Tamanho m�ximo do heap. */
	private T[] vetor;          /* Vetor com elementos. */

	/* Constr�i heap vazio. */
	public BinMaxHeap(int tamanho){
		n = 0;
		tam = tamanho;
		vetor = new T[tamanho+1];
	}

	/* Constr�i heap a partir de vetor v. */
	public BinMaxHeap(int tamanho, int[] v){
		tam = tamanho;
		vetor = new T[tamanho+1];
		n = tamanho;

		for( int i = 0; i < tamanho; i++ )
			vetor[ i + 1 ] = v[ i ];

		constroiHeap();
	}

	/* Testa se a fila de prioridade est� logicamente vazia.
	   Retorna true se vazia, false, caso contr�rio. */
	public boolean vazia(){
		return n == 0;
	}

	/* Faz a lista de prioridades logicamente vazia. */
	public void fazVazia(){
		n = 0;
	}

	/* Imprime os elementos da heap. */
	public void imprime(){
		for(int i = 1; i <= n; i++)
			System.out.print(vetor[i] + " ");

		System.out.println();
	}

	/* Busca o maior item na fila de prioridades.
	   Retorna o maior item em itemMin e true, ou falso se a heap estiver vazia. */
	public int max(){
		if (this.vazia()){
			System.out.println("Fila de prioridades vazia!");
			return Integer.MAX_VALUE;
		}

		return vetor[1];
	}

	/* Remove o menor item da fila de prioridades. */
	/*public void removeMin()
	{
		if(this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return;
		}

		vetor[1] = vetor[n];
		n--;
		refaz(1, n);
	}*/

	/* Remove o menor item da lista de prioridades e coloca ele em itemMin. */
	public int removeMin()
	{
		int itemMin;
		
		if(this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return Integer.MAX_VALUE;
		}

		itemMin = vetor[1];
		vetor[1] = vetor[n];
		n--;
		refaz(1);
		
		return itemMin;
	}

	/* M�todo auxiliar que estabelece a propriedade de ordem do heap a 
	 * partir de um vetor arbitr�rio dos itens. */
	private void constroiHeap()
	{
		/* As posi��es n at� a posi��o (n / 2) + 1 j� constituem uma heap,
		 * pois s�o folhas. */
		for( int i = n / 2; i > 0; i-- )
			refaz(i);
	}

	/* M�todo auxiliar para restaurar a propriedade de heap que
	 * n�o est� sendo respeitada pelo n� i. */
	private void refaz(int i)
	{
		int x = vetor[ i ];

		while(2*i <= n)
		{
			int filhoEsq, filhoDir, maiorFilho;
			
			filhoEsq = 2*i;
			filhoDir = 2*i + 1;
			
			/* Por enquanto, o maior filho � o da esquerda. */
			maiorFilho = filhoEsq;
			
			/* Verifica se o filho direito existe e, caso positivo, verifica
			 * se � maior que o filho esquerdo. */
			if((filhoEsq != n) && (vetor[ filhoDir ].compareTo(vetor[ filhoEsq ])>=1))
				maiorFilho = filhoDir;

			if(vetor[ maiorFilho ].compareTo(x) >= 1)
				vetor [ i ] = vetor[ maiorFilho ];
			else
				break;
			
			/* Como o elemento x que estava na posi��o "i" desceu para o n�vel de baixo, a pr�xima
			 * itera��o vai verificar a possibilidade de trocar esse elemento x (agora na 
			 * posi��o "maiorFilho") com um de seus novos filhos. */
			i = maiorFilho;
		}
		
		vetor[ i ] = x;
	}

	/* Insere item x na fila de prioridade, mantendo a propriedade do heap.
	 * S�o permitidas duplicatas. */
	public void insere(int x)
	{
		if (tam == n)
		{
			System.out.println("Fila de prioridades cheia!");
			return;
		}

		/* O elemento � inicialmente inserido na primeira posi��o dispon�vel
		 * na �rvore, considerando de cima para baixo, da esquerda para a direita. */
		n++;
		int pos = n;
		
		/* Sentinela utilizada para tratar o caso do pai do n� raiz (de �ndice 1). */
		vetor[0] = x;

		/* Refaz heap (sobe elemento). */
		while(x.compareTo(vetor[pos/2])>0)
		{
			vetor[pos] = vetor[ pos/2 ];
			pos /= 2;
		}
		
		vetor[pos] = x;
	}

	/* Implementa o algoritmo de ordena��o Heapsort. */
	public void heapsort()
	{
		int x;           
		int resta = n;
		int raiz = 1;
		constroiHeap();
		
		while (resta > 1)
		{
			x = vetor[raiz];
			vetor[raiz] = vetor[resta];
			vetor[resta] = x;
			resta--;
			refaz(raiz);
		}
	}
	
}



