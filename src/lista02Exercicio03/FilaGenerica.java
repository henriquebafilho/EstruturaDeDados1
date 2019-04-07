package lista02Exercicio03;

import java.util.Vector;
import filaCircularSimples.*;
import filaCircularDupla.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kinoplex
 */
public class FilaGenerica<T> {
	private int inicio;
	private int num;
	private int tamanho;
	private Vector<T> vetor;

	FilaGenerica(int tamanho) {
		vetor = new Vector<>(tamanho - 1);
		inicio = 0;
		num = 0;
		this.tamanho = tamanho;

	}

	public boolean vazia() {
		return num == 0 ? true : false;
	}

	public boolean cheia() {
		return num == tamanho ? true : false;
	}

	public T remove() {
		T elemento = null;

		if (!this.vazia()) {
			elemento = vetor.get(inicio);
			inicio = (inicio + 1) % tamanho;
			num--;
		}
		return elemento;

	}

	public boolean insere(T elemento) {
		int fim = 0;

		if (!this.cheia()) {
			fim = (inicio + num) % tamanho;
			vetor.add(fim, elemento);
			num++;
			return true;
		}
		return false;
	}

}
