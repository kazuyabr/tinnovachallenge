package exercicios.fatorial;

import java.util.Scanner;

public class Fatorial {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o numero a ser fatorado:");

		int fatorial = sc.nextInt();
		int f = fatorial;

		System.out.print(fatorial + "! = ");
		while (fatorial > 1) {
			f = f * (fatorial - 1);
			fatorial--;

		}
		System.out.print(f + " ");

	}

}
