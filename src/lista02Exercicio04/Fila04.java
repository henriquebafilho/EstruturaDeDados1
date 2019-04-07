package lista02Exercicio04;

import filaCircularSimples.*;
import filaCircularDupla.*;

public class Fila04 extends FilaDupla {
	
	public Fila04(int tam) {
		super(tam);
	}

	public int removeFim() {
		int elemento = Integer.MIN_VALUE;
		if (!this.vazia()) {
			int ultimo = (ini + n - 1) % tamanho;
			elemento = this.vetor[ultimo];
			n--;
		}
		return elemento;
	}

	public boolean insereInicio(int num) {
		if (!this.cheia()) {
			int primeiro = (ini - 1 + tamanho) % tamanho;
			vetor[primeiro] = num;
			ini = primeiro;
			return true;
		}
		return false;
	}

}
