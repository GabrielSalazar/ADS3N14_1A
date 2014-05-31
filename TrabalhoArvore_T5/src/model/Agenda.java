package model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private Arvore<Pessoa> arvore;

	public Agenda() {
		this.arvore = new Arvore<Pessoa>();
	}

	public void inserePessoa(Pessoa p) {
		Nodo<Pessoa> nodo = new Nodo<Pessoa>(p);
		this.arvore.insere(nodo);
		System.out.println("Altura raiz: " + this.arvore.getAlturaArvore());
		List<Nodo<Pessoa>> listaNodos = this.arvore.travessiaPREfixa();
		System.out.println("A árvore contém " + listaNodos.size() + " nodos.");

	}

	public Pessoa buscaPessoa(Pessoa p) {
		Nodo<Pessoa> nodo = new Nodo<Pessoa>(p);
		Nodo<Pessoa> nodoPessoa = this.arvore.busca(nodo);
		System.out.println("Número de Comparacoes: " + this.arvore.getComparacoes());
		if (nodoPessoa == null) {
			return null;
		} else {
			System.out.println("Altura do nodo:"
					+ this.arvore.getAltura(nodoPessoa));
			return nodoPessoa.getData();
		}
	}

	public Pessoa buscaLargura(Pessoa p) {
		Nodo<Pessoa> nodoPessoa = new Nodo<Pessoa>(p);
		Nodo<Pessoa> nodoResultado = this.arvore.buscaLargura(nodoPessoa);
		System.out.println("Número de Comparacoes: " + this.arvore.getComparacoes());
		if (nodoResultado == null) {
			return null;
		}
		System.out.println("Altura do nodo: "
				+ this.arvore.getAltura(nodoResultado));
		return nodoResultado.getData();
	}
	
	public Pessoa buscaProfundidade(Pessoa p){
		Nodo<Pessoa> nodoPessoa = new Nodo<Pessoa>(p);
		Nodo<Pessoa> nodoResultado = this.arvore.buscaProfundidade(nodoPessoa);
		System.out.println("Número de Comparacoes: "+this.arvore.getComparacoes());
		if(nodoResultado == null){
			return null;
		}
		System.out.println("Altura do nodo: " +this.arvore.getAltura(nodoResultado));
		return nodoResultado.getData();
	}


	public void remove(Pessoa p) {
		Nodo<Pessoa> nodo = new Nodo<Pessoa>(p);
		Nodo<Pessoa> nodoRemover = this.arvore.busca(nodo);
		if (nodoRemover != null) {
			this.arvore.remover(nodoRemover);
		}
	}

	public List<Pessoa> travessiaPrefixa() {
		List<Nodo<Pessoa>> listNodoPessoa = this.arvore.travessiaPREfixa();
		return this.conversorListaNodoParaListaPessoa(listNodoPessoa);
	}

	
	public List<Pessoa> travessiaPosfixa() {
		List<Nodo<Pessoa>> listNodoPessoa = this.arvore.travessiaPOSfixa();
		return this.conversorListaNodoParaListaPessoa(listNodoPessoa);
	}


	public List<Pessoa> travessiaInfixa() {
		List<Nodo<Pessoa>> listNodoPessoa = this.arvore.travessiaINfixa();
		if (listNodoPessoa != null) {
			return this.conversorListaNodoParaListaPessoa(listNodoPessoa);
		}
		return null;
	}


	private List<Pessoa> conversorListaNodoParaListaPessoa(
			List<Nodo<Pessoa>> listaNodoPessoa) {
		List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		for (int i = 0; i < listaNodoPessoa.size(); i++) {
			listaPessoa.add(listaNodoPessoa.get(i).getData());
		}
		return listaPessoa;
	}

}
