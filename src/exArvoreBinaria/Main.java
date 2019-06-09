package exArvoreBinaria;

public class Main
{
	public static void main(String[] args)
	{
		Arvbin<Integer> a1 = new Arvbin<Integer>(1),
				a2 = new Arvbin<Integer>(2),
				a3 = new Arvbin<Integer>(3,a1,a2),
				a4 = new Arvbin<Integer>(24),
				a5 = new Arvbin<Integer>(5),
				a6 = new Arvbin<Integer>(6),
				a7 = new Arvbin<Integer>(7,a5,a6);

				a4.defineEsq(a3);
				a4.defineDir(a7);
				a4.mostra();
				System.out.println();
				
		        System.out.println(a4.ArvoreSoma(a4));
	}
}
