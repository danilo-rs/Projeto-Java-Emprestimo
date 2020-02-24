package objetosemprestados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManipulaArquivo {
	Scanner sc = new Scanner(System.in);
	File novoArquivo;

	public File selecionarArquivo() {
		
		File arquivo = new File("C:/Users/Danilo/Documents/emprestimo.txt");
		try {
			// verifica se o arquivo ou diretório existe
			if (!arquivo.exists()) {
				// cria um arquivo (vazio)
				arquivo.createNewFile();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arquivo;
	}

	public void cadastrarNovosDadosCadastrais(DadosCadastrais dadosCadastrais) {

		String arquivo = dadosCadastrais.getObjeto() + "_" + dadosCadastrais.getTipo() + "_" + dadosCadastrais.getNome()
				+ "_" + dadosCadastrais.getContato() + "_" + dadosCadastrais.getData() + "_"
				+ dadosCadastrais.getDevolucao() + "_" + dadosCadastrais.getDescricao();
		// construtor que recebe também como argumento se o conteúdo será acrescentado
		// ao invés de ser substituído (append)
		try {
			FileWriter fw = new FileWriter(selecionarArquivo(), true);
			// construtor recebe como argumento o objeto do tipo FileWriter
			BufferedWriter bw = new BufferedWriter(fw);
			// escreve o conteúdo no arquivo
			bw.write(arquivo);

			// quebra de linha
			bw.newLine();
			// fecha os recursos
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void lerDadosCadastrais() {
		String linha = null;
		try {
			// construtor que recebe o objeto do tipo arquivo
			FileReader fr = new FileReader(selecionarArquivo());
			// construtor que recebe o objeto do tipo FileReader
			BufferedReader br = new BufferedReader(fr);
			// equanto houver mais linhas
			while ((linha = br.readLine()) != null) {

				System.out.println(linha);

			}
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterarDadosCadastrais() {
		ArrayList<DadosCadastrais> lista = carregarArrayDadosCadastrais();
		System.out.println("O que você deseja alterar?");
		System.out.println("1-Objeto");
		System.out.println("2-Tipo");
		System.out.println("3-Nome da pessoa");
		System.out.println("4-Contato");
		System.out.println("5-Data");
		System.out.println("6-Devolucao");
		System.out.println("7-Descricao");
		int i = 0;
		int op = sc.nextInt();
		switch (op) {
		case 1:

			System.out.println("Qual o nome do objeto atual?");
			String objetoAntigo = sc.next();
			System.out.println("Qual o novo nome?");
			String novoObjeto = sc.next();
			while (i != lista.size()) {
				if (lista.get(i).getObjeto().equals(objetoAntigo)) {

					lista.get(i).setObjeto(novoObjeto);
					reescreverArquivo(lista);
					break;
				}
				i++;
			}

			break;

		case 2:
			System.out.println("Qual o tipo do objeto atual?");
			String tipoAntigo = sc.next();
			System.out.println("Qual o novo tipo?");
			String novoTipo = sc.next();
			while (i != lista.size()) {
				if (lista.get(i).getTipo().equals(tipoAntigo)) {
					lista.get(i).setTipo(novoTipo);
					reescreverArquivo(lista);
					break;
				}
				i++;
			}
			break;

		case 3:
			System.out.println("Qual o nome da pessoa anterior?");
			String nomeAntigo = sc.next();
			System.out.println("Qual o nome da nova pessoa?");
			String novoNome = sc.next();
			while (i != lista.size()) {
				if (lista.get(i).getNome().equals(nomeAntigo)) {
					lista.get(i).setNome(novoNome);
					reescreverArquivo(lista);
					break;
				}
				i++;
			}
			break;
		case 4:
			System.out.println("Qual o número de contato da pessoa?");
			String contatoAntigo = sc.next();
			System.out.println("Qual o novo número de contato dessa pessoa?");
			String novoContato = sc.next();
			while (i != lista.size()) {
				if (lista.get(i).getContato().equals(contatoAntigo)) {
					lista.get(i).setContato(novoContato);
					reescreverArquivo(lista);
					break;
				}
				i++;
			}
			break;
		case 5:
			System.out.println("Qual foi a data do dia do empréstimo?");
			String dataAntigo = sc.next();
			System.out.println("Qual a nova data do empréstimo?");
			String novoData = sc.next();
			while (i != lista.size()) {
				if (lista.get(i).getData().equals(dataAntigo)) {
					lista.get(i).setData(novoData);
					reescreverArquivo(lista);
					break;
				}
				i++;
			}
			break;
		case 6:
			System.out.println("Qual foi a data de devolução anterior?");
			String devolucaoAntigo = sc.next();
			System.out.println("Qual a nova data da devolução?");
			String novoDevolucao = sc.next();
			while (i != lista.size()) {
				if (lista.get(i).getDevolucao().equals(devolucaoAntigo)) {
					lista.get(i).setDevolucao(novoDevolucao);
					reescreverArquivo(lista);
					break;
				}
				i++;
			}
			break;
		case 7:
			System.out.println("Qual a descrição anterior?");
			String descricaoAntigo = sc.next();
			System.out.println("Qual a nova descrição?");
			String novoDescricao = sc.next();
			while (i != lista.size()) {
				if (lista.get(i).getDescricao().equals(descricaoAntigo)) {
					lista.get(i).setDescricao(novoDescricao);
					reescreverArquivo(lista);
					break;
				}
				i++;
			}
			break;	
		default:
			break;
		}
	}

	public ArrayList<DadosCadastrais> carregarArrayDadosCadastrais() {
		String linha = null;
		ArrayList<DadosCadastrais> listaDados = new ArrayList<>();
		try {
			// construtor que recebe o objeto do tipo arquivo
			FileReader fr = new FileReader(selecionarArquivo());
			// construtor que recebe o objeto do tipo FileReader
			BufferedReader br = new BufferedReader(fr);
			// equanto houver mais linhas
			DadosCadastrais dadosCadastrais = new DadosCadastrais();
			while ((linha = br.readLine()) != null) {

				String[] vetorDadosCadastrais = linha.split("_");
				// Contato e = new Contato(vetorContato[0],vetorContato[1], vetorContato[2]);
				dadosCadastrais.setObjeto(vetorDadosCadastrais[0]);
				dadosCadastrais.setTipo(vetorDadosCadastrais[1]);
				dadosCadastrais.setNome(vetorDadosCadastrais[2]);
				dadosCadastrais.setContato(vetorDadosCadastrais[3]);
				dadosCadastrais.setData(vetorDadosCadastrais[4]);
				dadosCadastrais.setDevolucao(vetorDadosCadastrais[5]);
				dadosCadastrais.setDescricao(vetorDadosCadastrais[6]);

				listaDados.add(dadosCadastrais);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaDados;
	}

	public void reescreverArquivo(ArrayList<DadosCadastrais> listaDadosCadastrais) {
		File arquivo = selecionarArquivo();
		arquivo.delete();
		String arq;
		try {
			FileWriter fw = new FileWriter(arquivo);
			BufferedWriter bw = new BufferedWriter(fw);
			int i = 0;
			while (i <= listaDadosCadastrais.size() - 1) {
				arq = listaDadosCadastrais.get(i).getObjeto() + "_" + listaDadosCadastrais.get(i).getTipo() + "_"
						+ listaDadosCadastrais.get(i).getNome() + "_" + listaDadosCadastrais.get(i).getContato() + "_"
						+ listaDadosCadastrais.get(i).getData() + "_" + listaDadosCadastrais.get(i).getDevolucao() + "_"
						+ listaDadosCadastrais.get(i).getDescricao();
				bw.write(arq);
				bw.newLine();
				i++;
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluirDadosCadastrais(String objeto) {
		ArrayList<DadosCadastrais> lista = carregarArrayDadosCadastrais();

		int i = 0;

		while (i != lista.size()) {
			if (lista.get(i).getObjeto().equals(objeto)) {
				lista.remove(i);
				reescreverArquivo(lista);
				break;
			}
			i++;
		}
	}

}
