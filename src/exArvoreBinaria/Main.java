package exArvoreBinaria;

public class Main
{
	public static void main(String[] args)
	{
		Arvbin<Integer> a1 = new Arvbin<Integer>(1),
				a2 = new Arvbin<Integer>(2),
				a3 = new Arvbin<Integer>(3,a1,a2),
				a4 = new Arvbin<Integer>(4),
				a5 = new Arvbin<Integer>(5),
				a6 = new Arvbin<Integer>(6),
				a7 = new Arvbin<Integer>(7,a5,a6),
				a8 = new Arvbin<Integer>(8),
				a9 = new Arvbin<Integer>(9),
				a10 = new Arvbin<Integer>(10,a8,a9);

				a4.defineEsq(a3);
				a4.defineDir(a7);
				a4.mostra();
				System.out.println();
				
		Arvbin<Integer> b1 = new Arvbin<Integer>(1),
		       b2 = new Arvbin<Integer>(2),
		       b3 = new Arvbin<Integer>(3,b1,b2),
		       b4 = new Arvbin<Integer>(4),
		       b5 = new Arvbin<Integer>(5),
		       b6 = new Arvbin<Integer>(6),
		       b7 = new Arvbin<Integer>(7,b5,b6),
		       b8 = new Arvbin<Integer>(8),
		       b9 = new Arvbin<Integer>(9),
		       b10 = new Arvbin<Integer>(10,b8,b9);
               
		       b4.defineEsq(b3);
		       b4.defineDir(b7);
		       b4.mostra();
		       System.out.println();
		                
		       System.out.println(a4.eIgual(b4));
		       
	}
}
