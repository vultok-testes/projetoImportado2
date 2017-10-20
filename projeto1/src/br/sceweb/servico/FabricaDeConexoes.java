package br.sceweb.servico;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

/**
 * Classe serve para gerar conexões com banco de dados, usando - para tanto - 
 * <br>a classe ConfiguraDB como objeto de configuração
 * @author Elton
 * @version 1
 *
 */
public class FabricaDeConexoes {

	String url = "jdbc:mysql://localhost/sceweb";
	String driver = "com.mysql.jdbc.Driver";
	String usuario = "root";
	String senha = "";

	/**
	 * Construtor da classe FabricaDeConexões
	 * @param configura
	 */
	public FabricaDeConexoes(ConfiguraDB configura) {
		this.url = configura.getUrl();
		this.driver = configura.getDriver();
		this.usuario = configura.getUsuario();
		this.senha = configura.getSenha();
	}

	/**
	 * Construtor sem parâmetros da classe FabricaDeConexoes
	 */
	public FabricaDeConexoes() {}

	/**
	 * 
	 * @return Uma conexão com o banco de dados
	 */
	public Connection getConnection() {
		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, usuario, senha);
		} catch (CommunicationsException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}
}
