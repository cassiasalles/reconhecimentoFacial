package model;

public class Informacoes {
	private String usuario;
	private String nome;
	private int nvl_acesso;
	private String cargo;
	private String[] acoes_permitidas;
	private String arquivo_capturado;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNvl_acesso() {
		return nvl_acesso;
	}
	public void setNvl_acesso(int nvl_acesso) {
		this.nvl_acesso = nvl_acesso;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String[] getAcoes_permitidas() {
		return acoes_permitidas;
	}
	public void setAcoes_permitidas(String[] acoes_permitidas) {
		this.acoes_permitidas = acoes_permitidas;
	}
	public String getArquivo_capturado() {
		return arquivo_capturado;
	}
	public void setArquivo_capturado(String arquivo_capturado) {
		this.arquivo_capturado = arquivo_capturado;
	}
}
