package entidades;

public class Series {
	
	private Long codSeries;
	private String nome;
	private String dataInicial;
	private String dataFinal;
	
	private Long projeto;

	public Long getCodSeries() {
		return codSeries;
	}

	public void setCodSeries(Long codSeries) {
		this.codSeries = codSeries;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Long getProjeto() {
		return projeto;
	}

	public void setProjeto(Long projeto) {
		this.projeto = projeto;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
