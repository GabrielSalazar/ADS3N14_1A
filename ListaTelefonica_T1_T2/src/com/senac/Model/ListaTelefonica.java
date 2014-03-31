package com.senac.Model;

import java.util.ArrayList;

import com.senac.Estruturas.ListaOrdenada;
import com.senac.Estruturas.Nodo;

public class ListaTelefonica {
	private ListaOrdenada<Pessoa> lista = new ListaOrdenada<Pessoa>();
	private Nodo<Pessoa> atual = null;
	private ArrayList<Pessoa> listaBinaria = null;

	public ListaTelefonica() {
		
	}
	
	public void insertPessoa(Pessoa p) {
		Nodo<Pessoa> nodoPessoa = new Nodo<Pessoa>(p);
		this.lista.append(nodoPessoa);
	}

	public void converteListaEncadeadaToArray() {
		this.listaBinaria = null;
		this.listaBinaria = new ArrayList<Pessoa>();
		Nodo<Pessoa> nodo = this.lista.getHead();
		while (nodo != null) {
			this.listaBinaria.add(nodo.getData());
			nodo = nodo.getNext();
		}
	}

	public void pesquisaBinaria(Pessoa p) {
		int comeco = 0;
		int fim = 0;
		int atual = 0;
		int comparacoes = 0;

		if (this.listaBinaria == null) {
			this.converteListaEncadeadaToArray();
		}

		fim = this.listaBinaria.size();

		if (fim == 0) {
			System.out.println("Lista vazia.");
			return;
		}

		while (comparacoes != (int) this.listaBinaria.size() / 2) {
			comparacoes++;
			atual = (int) (fim - comeco) / 2;
			atual += comeco;

			int find = this.listaBinaria.get(atual).compareTo(p);

			if (find == 0) {
				System.out.println(this.listaBinaria.get(atual).toString());
				System.out.println("Comparacoes: " + comparacoes);
				return;
			} else if (find < 0) {
				comeco = atual;

			} else if (find > 0) {
				fim = atual;
			}
		}

		System.out.println("Nenhum dado encontrado.");
	}


	public void removePessoa() {

		if (this.atual != null) {
			this.lista.excluiNodo(this.atual);
		}
	}

	public void listarInicialNome(String nome) {
		Nodo<Pessoa> nodoPessoa = this.lista.getHead();
		while (nodoPessoa != null) {
			if (nodoPessoa.getData().getNome().toUpperCase().charAt(0) == nome
					.toUpperCase().charAt(0)) {
				System.out.println(nodoPessoa.getData().toString());
			}
			nodoPessoa = nodoPessoa.getNext();
		}
	}

	public Pessoa getContatoAtual() {
		if (this.atual != null) {
			return this.atual.getData();
		}
		return null;
	}

	public void next() {
		this.atual = this.lista.getNext(this.atual);
	}

	public void prev() {
		this.atual = this.lista.getPrev(this.atual);
	}
	public void printList() {
		this.lista.ImprimeLista();
	}
}