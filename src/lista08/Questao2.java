package lista08;

public boolean transformaHeapMaxima(Arvbin<Integer> arvore) throws Exception{
		boolean retorno = this.transformaArvorePrivada(arvore);
		if(retorno) {
			this.heapsort();
			return retorno;
		}
		this.fazVazia();
		throw new Exception("A �rvore n�o � completa");
		
	}
	
	private boolean transformaArvorePrivada(Arvbin<Integer> arv) {
		//Se ambos os n�s s�o nulo � folha
		if(arv.retornaDir() == null && arv.retornaEsq() == null) {
			this.insere(arv.retornaVal());
			return true;
		}
		this.insere(arv.retornaVal());
		boolean valoresq = false;
		boolean valordir = false;
		if(arv.retornaDir() != null) {
			valordir = this.transformaArvorePrivada(arv.retornaDir());
		}
		if(arv.retornaEsq() != null) {
			valoresq = this.transformaArvorePrivada(arv.retornaEsq());
		}
		return valoresq && valordir;
		
	}
