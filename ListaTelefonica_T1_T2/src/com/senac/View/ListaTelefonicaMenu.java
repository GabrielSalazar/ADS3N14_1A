package com.senac.View;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.senac.Model.ListaTelefonica;
import com.senac.Model.Pessoa;

public class ListaTelefonicaMenu {

		public void menuPrincipal() {

			boolean finalizar = true;

			try {

				ListaTelefonica agenda = new ListaTelefonica();
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				lerArquivo(agenda);

				do {
					System.out
							.println("   ------- BEM-VINDO  -------");
					System.out.println("1 - NOVO CONTATO");
					System.out.println("2 - LISTAR A AGENDA COMPLETA");
					System.out
							  .println("3 - LISTAR PELA INICIAL DO NOME");
					System.out.println("4 - LISTAR O PROXIMO CONTATO");
					System.out.println("5 - LISTAR O CONTATO ANTERIOR");
					System.out.println("6 - REMOVER UM CONTATO");
					System.out.println("7 - PESQUISA BINARIA\n\n");
					System.out.println("8 - SAIR DA AGENDA\n\n");
					System.out.print("DIGITE A SUA OPÇÃO:\n\n");

					int escolha = scanner.nextInt();

					switch (escolha) {
					case 1:
						agenda.insertPessoa(inserirPessoa());
						break;
					case 2:
						agenda.printList();
						break;
					case 3:
						agenda.listarInicialNome(getLetra());
						break;
					case 4:
						agenda.next();
						Pessoa p = agenda.getContatoAtual();
						if (p != null) {
							System.out.println(p);
						} else {
							System.out.println("A lista esta vazia!\n\n");
						}
						break;
					case 5:
						agenda.prev();
						Pessoa p1 = agenda.getContatoAtual();
						if (p1 != null) {
							System.out.println(p1);
						} else {
							System.out.println("A lista esta vazia!\n\n");
						}
						break;

					case 6:
						agenda.removePessoa();
						break;

					case 7:
						Pessoa p3 = new Pessoa();
						p3.setNome(getNomeBuscaBinaria());
						agenda.pesquisaBinaria(p3);
						break;
					case 8:
						System.out.println("AGENDA FINALIZADA!\n\n");
						finalizar = false;
						System.exit(0);
						break;
					default:
						System.out
								.println("TENTE NOVAMENTE, DIGITE UMA OPCAO :\n\n");
						break;
					}
				} while (finalizar);
			} catch (Exception e) {
				e.printStackTrace();
				menuPrincipal();
			}

		}

		public Pessoa inserirPessoa() throws IOException {

			BufferedWriter gravador = new BufferedWriter(new FileWriter(
					"C:\\agenda.txt", true));

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			Pessoa p = new Pessoa();
			System.out.print("Digite o nome: ");
			String nome = scanner.next();
			gravador.write((nome).toUpperCase());
			p.setNome(nome);

			gravador.newLine();

			System.out.print("Digite o telefone: ");
			String telefone = scanner.next();
			gravador.write(telefone);
			p.setTelefone(telefone);

			gravador.newLine();
			gravador.flush();
			gravador.close();

			return p;
		}

		public static String getLetra() {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print("Insira a letra por qual deseja procurar: ");
			String termo = scanner.next();
			return termo;
		}

		public static String getNomeBuscaBinaria() {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print("Digite o nome que deseja procurar: ");
			String nomeBusca = scanner.next();
			return nomeBusca;
		}

		public static void lerArquivo(ListaTelefonica agenda) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(
						"C:\\agenda.txt"));

				String nome;
				String telefone;

				while (reader.ready()) {
					nome = reader.readLine();
					telefone = reader.readLine();
					Pessoa p = new Pessoa(nome, telefone);
					agenda.insertPessoa(p);
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}
