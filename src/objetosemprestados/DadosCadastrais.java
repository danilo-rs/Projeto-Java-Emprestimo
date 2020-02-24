package objetosemprestados;

public class DadosCadastrais {

	String objeto;
	String tipo;
	String nome;
	String contato;
	String data;
	String devolucao;
	String descricao;

	public DadosCadastrais() {
		super();
	}

	public DadosCadastrais(String objeto, String tipo, String nome, String contato, String data, String devolucao,
			String descricao) {
		super();
		this.objeto = objeto;
		this.tipo = tipo;
		this.nome = nome;
		this.contato = contato;
		this.data = data;
		this.devolucao = devolucao;
		this.descricao = descricao;

	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(String devolucao) {
		this.devolucao = devolucao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
