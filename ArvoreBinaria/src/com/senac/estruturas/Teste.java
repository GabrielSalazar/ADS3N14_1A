package com.senac.estruturas;

public class Teste{

	public static void main(String[] args) {
		ArvoreBinaria<String> ab = new ArvoreBinaria<String>();

		/*ab.insere(new Nodo<String>("rafael"));
		ab.insere(new Nodo<String>("gabriel"));
		ab.insere(new Nodo<String>("ries"));
		ab.insere(new Nodo<String>("marcela"));
		ab.insere(new Nodo<String>("gastão"));
		ab.insere(new Nodo<String>("priscila"));*/
		
		ab.insere(new Nodo<String>("8"));
		ab.insere(new Nodo<String>("43"));
		ab.insere(new Nodo<String>("2"));
		ab.insere(new Nodo<String>("59"));
		ab.insere(new Nodo<String>("17"));
		ab.insere(new Nodo<String>("4"));
		ab.insere(new Nodo<String>("21"));
		ab.imprime();
	}
}