package com.senac.Model;

public class Tabuleiro {

	private String[][] campo = new String[10][10];
	private String[] colunas = { "     ", "[ A ]", "[ B ]", "[ C ]", "[ D ]",
			"[ E ]", "[ F ]", "[ G ]", "[ H ]", "[ I ]", "[ J ]" };

	public Tabuleiro() {
		iniciarCampo();
	}

	public void montarTabuleiro() {

		for (int i = 0; i < colunas.length; i++) {
			System.out.print(colunas[i]);
		}
		System.out.println();

		for (int l = 0; l < campo.length; l++) {
			System.out.print("[ " + l + " ]");
			for (int c = 0; c < campo.length; c++) {

				if (campo[l][c] == "[ O ]") {

					System.out.print("[ O ]");

				} else if (campo[l][c] == "[ - ]") {

					System.out.print("[ - ]");

				} else {

					System.out.print("[ . ]");
				}

			}
			System.out.println();
		}
	}

	private void iniciarCampo() {

		Gerador g = new Gerador();

		int countSubmarino = 0;
		int countTorpedeiro = 0;
		int countFragata = 0;
		int countDestroyer = 0;
		int countPortaAviao = 0;

		int linha, coluna;

		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {

				linha = g.gerarNumero();
				coluna = g.gerarNumero();

				if (campo[linha][coluna] == null && countSubmarino < 5) {

					campo[linha][coluna] = "[SUB]";
					countSubmarino++;

				} else if (campo[linha][coluna] == null && countTorpedeiro < 3) {

					campo[linha][coluna] = "[TOR]";

					countTorpedeiro++;
				} else if (campo[linha][coluna] == null && countFragata < 2) {

					campo[linha][coluna] = "[FRA]";

					countFragata++;
				} else if (campo[linha][coluna] == null && countDestroyer < 2) {

					campo[linha][coluna] = "[DES]";

					countDestroyer++;
				} else if (campo[linha][coluna] == null && countPortaAviao < 1) {

					campo[linha][coluna] = "[POR]";

					countPortaAviao++;
				}
			}

		}
	}

	public void mostrarCampo() {

		for (int i = 0; i < colunas.length; i++) {
			System.out.print(colunas[i]);
		}
		System.out.println();

		for (int i = 0; i < campo.length; i++) {
			System.out.print("[ " + i + " ]");
			for (int j = 0; j < campo.length; j++) {

				if (campo[i][j] == null) {

					System.out.print("[ . ]");

				} else

					System.out.print(campo[i][j]);
			}
			System.out.println();
		}
	}

	public boolean atacar(int linha, int coluna) {

		boolean flag = false;

		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				if (linha == i && coluna == j) {

					if (campo[linha][coluna] != null) {
						flag = true;
						campo[i][j] = "[ O ]";
					} else {
						flag = false;
						campo[i][j] = "[ - ]";
					}
				}
			}
		}
		return flag;
	}
}

