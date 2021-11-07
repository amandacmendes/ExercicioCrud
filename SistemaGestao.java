package exercicioCrud.ExercicioCrud;

public class SistemaGestao {

	private static int POSICOES = 0;
	static Pessoa[] pessoas = new Pessoa[10];

	public static void main(String[] args) {
		System.out.println("SISTEMA DE GESTÃO DE PESSOAS");
		menu();
	}

	public static void menu() {
		System.out.println("\nMenu:");
		System.out.println("(1) Cadastrar uma pessoa ");
		System.out.println("(2) Alterar um cadastro ");
		System.out.println("(3) Excluir cadastro");
		System.out.println("(4) Consultar todos os cadastros ");
		System.out.println("(5) Consultar cadastro por CPF ");
		System.out.println("(6) Sair");
		int opcao = Teclado.lerInteiro("Digite o numero correspondente a opção desejada: ");

		switch (opcao) {
		case 1:
			incluirPessoa();
			break;
		case 2:
			alterarPessoa();
			break;
		case 3:
			excluirPessoa();
		case 4:
			consultarPessoas();
			break;
		case 5:
			consultarPorCpf();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("Opção não disponível. \n");
			menu();
		}
	}

	public static void incluirPessoa() {

		if (POSICOES < 10) {

			System.out.println("\nCADASTRAR");

			String nome = Teclado.lerString("Digite o nome: ");
			String cpf = Teclado.lerString("Digite o CPF: ");
			String dataNasc = Teclado.lerString("Digite a data de nascimento: ");
			String email = Teclado.lerString("Digite o e-mail: ");
			String telefone = Teclado.lerString("Digite o telefone: ");

			pessoas[POSICOES] = new Pessoa(nome, cpf, dataNasc, email, telefone);
			POSICOES++;

			System.out.println("Cadastro realizado com sucesso! ");

			String repetir = Teclado.lerString("Cadastrar novamente? (S/N)");
			switch (repetir) {
			case "S":
			case "s":
				incluirPessoa();
				break;
			case "N":
			case "n":
				menu();
				break;
			default:
				System.out.println("Opção inválida:");
				menu();
				break;
			}
		} else {
			System.out.println("A agenda já está cheia!");
			menu();
		}
	}

	public static void alterarPessoa() {

		System.out.println("\nALTERAR");

		imprimirListaPessoas();
		int idAlt = Teclado.lerInteiro("\nInforme o índice de quem deseja alterar as informações: ") - 1;

		pessoas[idAlt].setNome(Teclado.lerString("Digite o nome: "));
		pessoas[idAlt].setCpf(Teclado.lerString("Digite o CPF: "));
		pessoas[idAlt].setDataNasc(Teclado.lerString("Digite a data de nascimento: "));
		pessoas[idAlt].setEmail(Teclado.lerString("Digite o e-mail: "));
		pessoas[idAlt].setTelefone(Teclado.lerString("Digite o telefone: "));

		System.out.println("Alterado com sucesso!");

		menu();
	}

	public static void excluirPessoa() {
		if (POSICOES > 0) {
			System.out.println("\nEXCLUIR");

			imprimirListaPessoas();
			int idExc = Teclado.lerInteiro("\nInforme o índice de quem deseja excluir: ");

			for (int i = idExc - 1; i < POSICOES - 1; i++) {
				pessoas[i] = pessoas[i + 1];
			}
			POSICOES--;

			System.out.println("Excluido com sucesso! ");
			imprimirListaPessoas();

			String repetir = Teclado.lerString("Excluir novamente? (S/N)");
			switch (repetir) {
			case "S":
			case "s":
				excluirPessoa();
				break;
			case "N":
			case "n":
				menu();
				break;
			default:
				System.out.println("Opção inválida:");
				menu();
				break;
			}
		} else {
			System.out.println("Lista de cadastro vazia!");
			menu();
		}
	}

	public static void consultarPessoas() {
		imprimirListaPessoas();
		menu();
	}

	public static void consultarPorCpf() {
		String buscaCpf = Teclado.lerString("Digite o CPF: ");
		boolean achou = false;

		for (int i = 0; i < POSICOES; i++) {
			Pessoa x = pessoas[i];
			if (x.getCpf().equals(buscaCpf)) {
				achou = true;
				System.out.println("ÍNDICE\t| NOME\t\t| CPF\t\t| DATA DE NASCIMENTO\t| EMAIL\t\t| TELEFONE");
				System.out.println(i + 1 + "\t" + x.getNome() + "\t" + x.getCpf() + "\t" + x.getDataNasc() + "\t\t"
						+ x.getEmail() + "\t" + x.getTelefone());
			}
		}

		if (!achou) {
			System.out.println("Usuário com o CPF " + buscaCpf + " não foi encontrado.\n");
		}

		String repetir = Teclado.lerString("Buscar novamente? (S/N)");
		switch (repetir) {
		case "S":
		case "s":
			consultarPorCpf();
			break;
		case "N":
		case "n":
			menu();
			break;
		default:
			System.out.println("Opção inválida:");
			menu();
			break;
		}

	}

	public static void imprimirListaPessoas() {
		System.out.println("ÍNDICE\t| NOME\t\t| CPF\t\t| DATA DE NASCIMENTO\t| EMAIL\t\t| TELEFONE");

		for (int i = 0; i < POSICOES; i++) {
			Pessoa x = pessoas[i];
			System.out.println(i + 1 + "\t" + x.getNome() + "\t" + x.getCpf() + "\t" + x.getDataNasc() + "\t\t"
					+ x.getEmail() + "\t" + x.getTelefone());
		}
	}

}
