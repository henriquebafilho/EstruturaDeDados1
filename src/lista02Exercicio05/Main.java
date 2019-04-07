package lista02Exercicio05;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		FilaPreferencial idosos = new FilaPreferencial(5);
		
		idosos.inserePessoa(new Pessoa(25));
		idosos.inserePessoa(new Pessoa(36));
		idosos.inserePessoa(new Pessoa(89));
		idosos.inserePessoa(new Pessoa(95));
		idosos.inserePessoa(new Pessoa(42));
		
		System.out.println(idosos.retornaFila());
	}
}
