package lista02Exercicio06;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		FilaDuplaAparelho fila = new FilaDuplaAparelho(20);
		Random rad = new Random();
		for (int i = 0; i < 20; i++) {
			int preco = rad.nextInt(1000);
			if (preco % 2 == 0) {
				fila.insereSmartphone(new Smartphone("Iphone", preco));
			} else {
				fila.insereTablet(new Tablet("Ipad", preco));
			}
		}
	}
}
