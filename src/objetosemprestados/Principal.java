package objetosemprestados;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		ManipulaArquivo manArquivo = new ManipulaArquivo();
		Scanner entrada = new Scanner(System.in);
		int op = 0;
		
		while(op!=5) {
		System.out.println("----------------------------------------");	
		System.out.println("**********EMPR�STIMO DE OBJETOS**********");
		System.out.println("----------------------------------------");
		System.out.println("Escolha a op��o que deseja realizar");
		System.out.println("1 - Cadastrar um novo empr�stimo");
		System.out.println("2 - Alterar empr�stimo");
		System.out.println("3 - Excluir empr�stimo");
		System.out.println("4 - Listar todos os empr�stimos");
		System.out.println("5 - Sair da opera��o");
		System.out.println("----------------------------------------");	
		
		op = entrada.nextInt();
		switch (op) {
		case 1:
			DadosCadastrais e = new DadosCadastrais();
			System.out.println("Qual o nome do objeto?");
			e.setObjeto(entrada.next());
			System.out.println("Qual o tipo desse objeto?");
			e.setTipo(entrada.next());
			System.out.println("Qual o nome da pessoa que emprestou?");
			e.setNome(entrada.next());
			System.out.println("Qual o contato dessa pessoa?");
			e.setContato(entrada.next());
			System.out.println("Qual a data do empr�stimo?");
			e.setData(entrada.next());
			System.out.println("Qual ser� o dia devolu��o?");
			e.setDevolucao(entrada.next());
			System.out.println("Deseja incluir alguma descri��o?");
			e.setDescricao(entrada.next());
			
			manArquivo.cadastrarNovosDadosCadastrais(e);
			break;
		case 2:
			manArquivo.alterarDadosCadastrais();
			System.out.println("");
			break;
		case 3:
			System.out.println("Qual o nome do objeto que deseja excluir?");
			String objeto = entrada.next();
			manArquivo.excluirDadosCadastrais(objeto);
			break;
		case 4:
			manArquivo.lerDadosCadastrais();
			break;
		case 5:
			System.out.println("Opera��o encerrada.");
			break;
		default:
			break;
		}
		}
	}
}
