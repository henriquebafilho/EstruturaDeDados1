package lista08;

public BinMinHeap(BinMaxHeap heap) {
		
		n = 0;
		tam = heap.getTamanho();
		vetor = new int[tam+1];
		
		for(int i = heap.getN();i>=1;i--) {
			this.insere(heap.getVetor()[i]);
		}
		
}

	public int getN() {

		return this.n;
	}

	public int[] getVetor() {

		return this.vetor;
	}
	
	public int getTamanho() {

		return this.tam;
	}

// ------------------------------------------------------------------

public BinMaxHeap(BinMinHeap heap) {
		
		n = 0;
		tam = heap.getTamanho();
		vetor = new int[tam+1];
		
		for(int i = heap.getN();i>=1;i--) {
			this.insere(heap.getVetor()[i]);
		}
		
}

	public int getN() {

		return this.n;
	}

	public int[] getVetor() {

		return this.vetor;
	}
	
	public int getTamanho() {

		return this.tam;
	}