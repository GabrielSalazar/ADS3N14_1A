package com.senac.Controller;
import com.senac.Model.Tabuleiro;
import com.senac.View.UtilScan;



public class Main {

	public static void main(String[] args) {

		Tabuleiro tb = new Tabuleiro();
		UtilScan us = new UtilScan();

		int pontos = 15;

		while (pontos > 0) {

			tb.montarTabuleiro();

			System.out.println("Digite uma linha de [0-9]: ");
			int linha = us.scanInt();
			System.out.println("Digite uma coluna de [0-9]: ");
			int coluna = us.scanInt();

			boolean cond = tb.atacar(linha, coluna);
			pontos--;

			System.out.println(cond);
			if (cond) {
				pontos += 3;
			}

		}
		tb.mostrarCampo();
		System.out.println("FIM DE JOGO");
	}
}