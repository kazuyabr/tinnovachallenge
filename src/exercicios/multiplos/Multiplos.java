package exercicios.multiplos;

import java.util.Scanner;

public class Multiplos {

	public static void main(String[] args) {

		int tres = 3;
		int cinco = 5;
		int res = 0;
		int parametro;

		@SuppressWarnings("resource")
		Scanner tc = new Scanner(System.in);
		System.out.println("Digite o parametro: ");
		parametro = tc.nextInt();

		for (int i = 0; i < parametro; i++) {
			if (i % tres == 0 || i % cinco == 0) {
				res += i;
			}
		}

		System.out.println("A soma dos multiplos de 1 e 3 até o parametro, é: " + res);
	}

}
