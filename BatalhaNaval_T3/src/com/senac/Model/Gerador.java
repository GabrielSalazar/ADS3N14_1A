package com.senac.Model;
import java.util.Random;

public class Gerador {
	
	Random r = new Random();

	public int gerarNumero() {

		return r.nextInt(10);
	}

}