package vetorCaracteristico;

public class VetorCaracteristico {

	boolean[] vetor;
	int n, tamanho = 0;

	public VetorCaracteristico(int n) {

		this.vetor = new boolean[n + 1];
		this.n = n + 1;
	}

	public boolean[] getVetor() {
		return vetor;
	}

	// Cardinalidade
	public int cardinalidade() {
		return this.tamanho;
	}

	public int getN() {
		return n;
	}

	// União
	public VetorCaracteristico uniao(VetorCaracteristico A, VetorCaracteristico B) {

		VetorCaracteristico resposta;

		if (A.getN() > B.getN()) {
			for (int i = 0; i < B.getN(); i++) {
				if ((B.getVetor()[i] == true && A.getVetor()[i] == false)) {
					A.getVetor()[i] = true;

				}
			}
			resposta = A;
		} else {
			for (int i = 0; i < A.getN(); i++) {
				if ((A.getVetor()[i] == true && B.getVetor()[i] == false)) {
					B.getVetor()[i] = true;

				}
			}
			resposta = B;
		}
		return resposta;
	}

	// Interseção
	public VetorCaracteristico intersecao(VetorCaracteristico A, VetorCaracteristico B) {

		VetorCaracteristico resposta;

		if (A.getN() > B.getN()) {
			resposta = new VetorCaracteristico(B.getN());
		} else {
			resposta = new VetorCaracteristico(A.getN());
		}

		if (A.getN() > B.getN()) {
			for (int i = 0; i < B.getN(); i++) {
				if ((B.getVetor()[i] == true && A.getVetor()[i] == true)) {
					resposta.vetor[i] = true;

				}
			}
		} else {
			for (int i = 0; i < A.getN(); i++) {
				if ((B.getVetor()[i] == true && A.getVetor()[i] == true)) {
					resposta.vetor[i] = true;

				}
			}
		}

		return resposta;
	}

	// Adicionar elemento
	public boolean adiciona(int elem) {

		if (elem < 0 || elem > n - 1) {
			return false;
		}

		this.vetor[elem] = true;
		this.tamanho++;

		return true;

	}

	// Remover elemento
	public boolean remove(int elem) {
		if (elem < 0 || elem > n - 1 || this.vetor[elem] == false) {
			return false;
		}

		this.vetor[elem] = false;
		this.tamanho--;

		return true;

	}

	// Verificar pertinência de um elemento
	public boolean pertence(int elem) {

		if (elem > this.n - 1 || elem < 0) {
			return false;
		}

		if (this.vetor[elem] == true) {
			return true;
		} else {
			return false;
		}
	}

	// Tornar conjunto vazio
	public void tornarVazio() {
		this.vetor = new boolean[n - 1];
		this.tamanho = 0;
	}

	// Testar se o conjunto é vazio
	public boolean vazio() {
		if (this.tamanho > 0) {
			return false;
		} else {
			return true;
		}
	}

	// Testar se o conjunto é o universo
	public boolean universo() {
		if (this.tamanho == n - 1) {
			return true;
		} else {
			return false;
		}
	}
	
	//Testa se A é subconjunto próprio de B ou vice versa
	public static boolean subconjuntoProprio(VetorCaracteristico A, VetorCaracteristico B) {
		if (A.getN() == B.getN())
			return false;

		if (A.getN() > B.getN()) {
			for (int i = 0; i < B.getN(); i++) {
				if (B.getVetor()[i] != A.getVetor()[i])
					return false;
			}
		} else {
			for (int i = 0; i < A.getN(); i++) {
				if (B.getVetor()[i] != A.getVetor()[i])
					return false;
			}
		}
		return true;
	}

	//Retorna maior elemento do vetor
	public int maior() {
		for (int i = this.getN(); i >= 0; i--) {
			if (this.getVetor()[i] = true) {
				return i + 1;
			}
		}
		return 0;
	}

	//Retorna menor elemento do vetor
	public int menor() {
		for (int i = 0; i < this.getN(); i++) {
			if (this.getVetor()[i] = true) {
				return i + 1;
			}
		}
		return 0;
	}

	// Testar se é subconjunto
	public boolean subconjunto(VetorCaracteristico A, VetorCaracteristico B) {
		// se os conjuntos forem do mesmo tamanho (precisam ser iguais)
		if (A.getN() == B.getN()) {
			for (int i = 1; i < B.getN(); i++) {
				if (A.getVetor()[i] != B.getVetor()[i]) {
					return false;
				}
			}
		}
		// Se A for maior que B
		else if (A.getN() > B.getN()) {
			for (int i = 1; i < B.getN(); i++) {
				if (A.getVetor()[i] != B.getVetor()[i]) {
					return false;
				}
			}
		}
		// Se B for maior que A
		else {
			for (int i = 1; i < A.getN(); i++) {
				if (A.getVetor()[i] != B.getVetor()[i]) {
					return false;
				}
			}
		}
		return true;
	}
}
