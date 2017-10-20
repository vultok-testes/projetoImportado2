package br.sceweb.servico;

/**
 * Classe serve como um objeto de configura��o do banco de dados
 * @author Elton
 * @version 1
 *
 */
public class ConfiguraDB {
	String url = "";
	String driver = "";
	String usuario = "";
	String senha = "";
	
	/**
	 * Construtor da classe ConfiguraDB
	 * @param url
	 * @param driver
	 * @param usuario
	 * @param senha
	 */
	public ConfiguraDB(String url, String driver, String usuario, String senha) {
		this.url = url;
		this.driver = driver;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	/**
	 * Retorna a url
	 * @return Uma String da URL
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * M�todo retorna o driver
	 * @return Uma String com o driver
	 */
	public String getDriver() {
		return driver;
	}
	
	/**
	 * 
	 * @return O usu�rio
	 */
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * 
	 * @return Uma String com a senha
	 */
	public String getSenha() {
		return senha;
	}
}