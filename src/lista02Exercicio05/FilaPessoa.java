package lista02Exercicio05;

public class FilaPessoa {
	protected int tamanho;
	protected Pessoa[] vetor;
	protected int ini;
	protected int n;
	
	public FilaPessoa(int tam)
	{
		tamanho = tam;
		vetor = new Pessoa[tamanho];
		ini = 0;
		n = 0;
	}
	
	public boolean vazia()
	{
		return (n == 0);
	}
	
	public boolean cheia()
	{
		return (n == tamanho);
	}
	
	public Pessoa remove()
	{
		Pessoa elemento = null;
		
		if (!this.vazia())
		{
			elemento = vetor[ini];
			ini = (ini + 1) % tamanho;
			n--;
		} 

		return elemento;
	}
	public int getTamanho() {
		return this.tamanho;
	}
	
	public boolean insere(Pessoa elemento)
	{
	  int fim;
	  
	  if ( !cheia() ) {
	    fim = (ini + n) % tamanho;
	    vetor[fim] = elemento;
	    n++;
	    return true;
	  } 
	  else
	    return false;
	}
}
