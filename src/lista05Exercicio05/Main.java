package lista05Exercicio05;

public class Main {
	public static void main(String[] args) { 
		ListaDuplamente l1 = new ListaDuplamente();
		ListaDuplamente l2 = new ListaDuplamente();
		
		l1.insere(3);
		l1.insere(2);
		l1.insere(1);
		
		l2.insere(3);
		l2.insere(2);
		l2.insere(1);
		
		System.out.println(l1.iguaisRecursivo(l1, l2));
	}

}
