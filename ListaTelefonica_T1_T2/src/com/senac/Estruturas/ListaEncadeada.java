package com.senac.Estruturas;

public class ListaEncadeada<T extends Comparable<T>> {

	protected Nodo<T> head;
	protected Nodo<T> tail;

	public Nodo<T> getHead() {
		return head;
	}

	public void setHead(Nodo<T> nodo) {
		this.head = nodo;
	}

	public void insert(Nodo<T> novo) {
		novo.setNext(head);
		head = novo;
		if (tail == null)
			tail = head;
	}

	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		if (anterior == tail) {
			tail.setNext((Nodo<T>) novo);
			tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}

	public void append(Nodo<T> novo) {
		tail.setNext(novo);
		tail = novo;
	}

	public void ImprimeLista() {
		Nodo<?> nodo = head;
		do {
			System.out.println(nodo.getData());
			nodo = nodo.getNext();
		} while (nodo != null);
	}

}
