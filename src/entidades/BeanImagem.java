package entidades;

public class BeanImagem {
	
	private Long codImagem;
	private String imagem;
	private String tipoFile;
	
	public String getTipoFile() {
		return tipoFile;
	}
	
	public void setTipoFile(String tipoFile) {
		this.tipoFile = tipoFile;
	}
	
	public Long getCodImagem() {
		return codImagem;
	}
	
	public void setCodImagem(Long codImagem) {
		this.codImagem = codImagem;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
