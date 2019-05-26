package lista06Exercicio02;

public class Main {

	public static void main(String[] args) throws Exception {
		ConjGenerico<Integer> universo = new ConjGenerico();
		ConjGenerico<Integer> conjunto = new ConjGenerico();
		
		universo.insere(1);
		universo.insere(2);
		universo.insere(3);
		
		conjunto.insere(1);
		conjunto.insere(4);
		
		conjunto.complementar(universo);
	}

}
