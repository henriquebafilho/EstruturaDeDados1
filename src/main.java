import java.util.*;

public class main {

	public static void main(String[] args) {

		PilhaGenerica pilha1 = new PilhaGenerica(5);
		PilhaGenerica pilha2 = new PilhaGenerica(5);

		pilha1.push('p');
		pilha1.push('i');
		pilha1.push('l');
		pilha1.push('h');
		pilha1.push('a');

		// 1) a. i. 
		//pilha2.transferePilha(pilha1);

		// 1) a. ii.
		//pilha2.transferePilhaRecursivo(pilha1);
		
		// 1) b.
		pilha1.revertePilha();
		
	}

}
