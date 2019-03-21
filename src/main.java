import java.util.*;

public class main {

	public static void main(String[] args) {

		PilhaGenerica pilha = new PilhaGenerica(5);
		PilhaGenerica p = new PilhaGenerica(5);

		pilha.push('p');
		pilha.push('i');
		pilha.push('l');
		pilha.push('h');
		pilha.push('a');

		// 1) a. i. 
		//p.transferePilha(pilha);

		// 1) a. ii.
		//p.transferePilhaRecursivo(pilha);
		
		//System.out.println(p.retornaVetor());
	}

}
