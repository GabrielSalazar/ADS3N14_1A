package com.senac;
public class Ordenacao {
	private int numeroComparacoes;
	private int trocaElementos;

	public static void main(String[] args) {
		(new Ordenacao()).run();
	}

	public void run() {
		int vetorSelection[] = { 5, 144, 8, 13, 2, 21,55, 89, 1, 34, 3 };
		int vetorQuick[]     = { 5, 144, 8, 13, 2, 21,55, 89, 1, 34, 3 };
		int[] vetorOrganizado = new int[vetorSelection.length];
		
		System.out.println("[SELECTION SORT]");
		System.out.println();
		System.out.println("Vetor a ordenar do SelectionSort:");
		exibeVetor(vetorSelection);
		System.out.println();
		vetorOrganizado = selectionSort(vetorSelection);
		imprime();
		
		System.out.println();
		System.out.println("Vetor ordenado:");
		exibeVetor(vetorOrganizado);
		System.out.println("----------------------------------");
		System.out.println();
		
		System.out.println("[QUICK SORT]");
		System.out.println();
		System.out.println("Vetor a ordenar do QuickSort:");
		exibeVetor(vetorQuick);
		System.out.println();
		vetorOrganizado = retornaVetorQuickSort(vetorQuick);
		imprime();
		
		System.out.println();
		System.out.println("Vetor ordenado:");
		exibeVetor(vetorOrganizado);
	}

		public int[] selectionSort(int[] vetor ) {
		int auxiliar;
		int menor;
			for (int i = 0; i < (vetor.length - 1); i++) 
			{
				menor = i;
				for (int j = (i + 1); j < vetor.length; j++) 
				{
					if (vetor[j] < vetor[menor]) {
						menor = j;
					}
				numeroComparacoes++;	
				}
			auxiliar = vetor[i];
			vetor[i] = vetor[menor];
			vetor[menor] = auxiliar;
			trocaElementos++;	
			}

			return vetor;
		}
		
	public int[] retornaVetorQuickSort(int[] vetor) {
		quickSort(vetor, 0, vetor.length - 1);
		return vetor;
	}

	private void quickSort(int[] vetor, int inicio, int fim) {
		int meio;

		if (inicio < fim) {
			numeroComparacoes++;
			meio = partition(vetor, inicio, fim);
			quickSort(vetor, inicio, meio);
			quickSort(vetor, meio + 1, fim);
		}
	}

	private int partition(int[] vetor, int ini, int fim) {
		int pivot, topo, i;
		pivot = vetor[ini];
		topo = ini;

		for (i = ini + 1; i <= fim; i++) {
			if (vetor[i] < pivot) {
				numeroComparacoes++;
				vetor[topo] = vetor[i];
				vetor[i] = vetor[topo + 1];
				topo++;
				trocaElementos += 2;
			}
		}
		vetor[topo] = pivot;
		trocaElementos++;
		return topo;
	}

	public void exibeVetor(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(" " + vetor[i]);
		}
		System.out.println();
	}

	public void imprime() {
		System.out.println("Número de Comparações: " + numeroComparacoes);
		System.out.println("Número de trocas: " + trocaElementos);
	}

}