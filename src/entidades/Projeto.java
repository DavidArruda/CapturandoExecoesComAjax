package entidades;

import java.util.ArrayList;
import java.util.List;

public class Projeto {

	private Long codProjeto;
	private String nome;
	
	private List<Series> listaSeries = new ArrayList<Series>();
	
	public List<Series> getListaSeries() {
		return listaSeries;
	}
	
	public void setListaSeries(List<Series> listaSeries) {
		this.listaSeries = listaSeries;
	}
	
	public Long getCodProjeto() {
		return codProjeto;
	}

	public void setCodProjeto(Long codProjeto) {
		this.codProjeto = codProjeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
