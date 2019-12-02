package entidades;

public class Usuario {
	
	private String nome;
	private String senha;
	private Long codUsuario;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}

}
