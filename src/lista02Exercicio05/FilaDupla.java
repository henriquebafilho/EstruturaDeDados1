package lista02Exercicio05;

public class FilaDupla extends FilaPessoa {
	public FilaDupla(int tam)
	{
		super(tam);
	}
	
	public boolean insereInicio(Pessoa elemento)
	{
		int inicio;
		
		if (!cheia())
		{
			inicio = (ini -1 + tamanho) % tamanho;
			vetor[inicio] = elemento;
			ini = inicio;
			n++;
			return true;
		} 
		else
			return false;
	}
	
	public Pessoa removeFim()
	{
		Pessoa elemento = null;
		int ultimo;

		if (!this.vazia())
		{
			ultimo = (ini + n - 1) % tamanho;
			elemento = vetor[ultimo];
			n--;
		} 
		
		return elemento;
}
}