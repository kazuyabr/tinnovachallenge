package exercicios.eleitores;

public class PercentualVotos {

	public static void main(String[] args) {

		Eleitores e;
		e = new Eleitores();
		int percentualVotosValidos = e.percentualDeVotosValidos();
		System.out.println(percentualVotosValidos + "% de votos v�lidos em rela��o aos eleitores.");

		int percentualVotosBrancos = e.percentualDeVotosBrancos();
		System.out.println(percentualVotosBrancos + "% de votos brancos em rela��o aos eleitores.");

		int percentualVotosNulos = e.percentualDeVotosNulos();
		System.out.println(percentualVotosNulos + "% de votos brancos em rela��o aos eleitores.");

	}

}
