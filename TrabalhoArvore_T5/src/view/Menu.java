package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.Agenda;
import model.Pessoa;


public class Menu {

	public static final String ARQUIVO = "agenda.txt";

	public void menuPrincipal() {

		boolean finalizar = true;

		try {

			Agenda agenda = new Agenda();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			lerArquivo(agenda);

			do {
				System.out.println();
				System.out.println("Menu");
				System.out.println("1 - Cadastrar contato");
				System.out.println("2 - Imprime Prefixa");
				System.out.println("3 - Imprime Posfixa");
				System.out.println("4 - Imprime Infixa");
				System.out.println("5 - Pesquisar nome");
				System.out.println("6 - Remover um contato");
				System.out.println("7 - Busca em largura [-] ");
				System.out.println("8 - Busca em Profundidade [|] ");
				System.out.println("0 - Sair\n\n");
				System.out.print("DIGITE A SUA OPÇÃO:\n\n");

				int opcao = scanner.nextInt();

				switch (opcao) {
				case 1:
					Pessoa p = inserirPessoa();
					agenda.inserePessoa(p);
					break;

				case 2:
					List<Pessoa> pessoasPreFixa = agenda
							.travessiaPrefixa();

					imprimeAgenda(pessoasPreFixa);

					break;

				case 3:
					List<Pessoa> pessoasPosFixa = agenda
							.travessiaPosfixa();

					imprimeAgenda(pessoasPosFixa);

					break;
				case 4:
					List<Pessoa> pessoasInFixa = agenda
							.travessiaInfixa();

					imprimeAgenda(pessoasInFixa);

					break;
				case 5:
					Pessoa pSearch = armazenaNome();
					Pessoa pReturn = agenda.buscaPessoa(pSearch);
					System.out.println(pReturn);

					break;

				case 6:
					Pessoa pDelete = armazenaNome();

					agenda.remove(pDelete);

					break;

				case 7:
					Pessoa pBuscar2 = armazenaNome();
					Pessoa pResultado2 = agenda.buscaLargura(pBuscar2);
					System.out.println(pResultado2);
					break;

				case 8:
					Pessoa pBuscar3 = armazenaNome();
					Pessoa pResultado3 = agenda.buscaProfundidade(pBuscar3);
					System.out.println(pResultado3);
					break;

				case 0:
					escreverArquivo(agenda);
					System.out.println("Encerrando...\n\n");
					finalizar = false;
					System.exit(0);
					break;
				default:
					System.out
							.println("Por favor, tente novamente!\n\n");
					break;
				}
			} while (finalizar);
		} catch (Exception e) {

			System.out.println("Por favor, tente novamente!\n\n");
			menuPrincipal();
		}

	}

	public Pessoa inserirPessoa() {

		Pessoa p = new Pessoa();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o nome:\n\n");
		String nome = scanner.next();
		p.setNome(nome);

		System.out.print("Digite o telefone:\n\n");
		String telefone = scanner.next();
		p.setTelefone(telefone);

		return p;
	}

	private static Pessoa armazenaNome() {

		Pessoa p = new Pessoa();

		System.out.print("Digite um nome:\n\n");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.next();

		p.setNome(nome);

		return p;

	}

	private static void imprimeAgenda(List<Pessoa> pessoas) {

		if (pessoas != null) {

			for (int i = 0; i < pessoas.size(); i++) {

				System.out.println(pessoas.get(0));

			}

		} else {

			System.out.println("Nome inexistente!");

		}

	}

	public static void escreverArquivo(Agenda agenda) {
		try {

			List<Pessoa> pessoas = agenda.travessiaPrefixa();

			if (pessoas != null) {

				BufferedWriter writer = new BufferedWriter(new FileWriter(
						ARQUIVO));

				for (int i = 0; i < pessoas.size(); i++) {

					Pessoa p = pessoas.get(i);
					writer.write(p.getNome());
					writer.newLine();
					writer.write(p.getTelefone());
					writer.newLine();
					writer.flush();
				}

				writer.close();

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void lerArquivo(Agenda agenda) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					ARQUIVO));

			String nome;
			String telefone;

			while (reader.ready()) {
				nome = reader.readLine();
				telefone = reader.readLine();
				Pessoa p = new Pessoa(nome, telefone);
				agenda.inserePessoa(p);
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
