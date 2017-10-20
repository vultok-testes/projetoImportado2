package br.sceweb.teste_unitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;
import br.sceweb.servico.ConfiguraDB;

/**
 * Este script de teste verifica o comportamento do caso de uso UC01CadastrarEmpresa
 * @author professor
 * @version 1.1
 */
public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	static ConfiguraDB configuraDB;
	static ConfiguraDB configuraDB1;
	
	/**
	 * Objetivo - prepara a execução dos testes
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String url = "jdbc:mysql://localhost/sceweb";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "alunofatec";
		configuraDB = new ConfiguraDB(url, driver,usuario,senha);
		empresaDAO = new EmpresaDAO(configuraDB);
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	
	/**
	 * ID - CT01UC01FBCadastra_com_sucesso
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa com 
	 * sucesso
	 * Pré-condiçao - O cnpj 89424232000180 nao esta cadastrado.
	 */
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		String url = "jdbc:mysql://localhost/sceweb";
		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	
	/**
	 * ID - CT02UC01FBCadastra_cnpj_invalido
	 * Objetivo - verificar o comportamento do sistema na inclusao de um cnpj 
	 * <br> inválido para empresa
	 */
	@Test
	public void CT02UC01FBCadastra_cnpj_invalido() {
		assertEquals("CNPJ invalido.", empresa.setCnpj("89424"));
	}
	
	/**
	 * ID - CT03UC01FBCadastra_cnpj_ja_cadastrado
	 * Objetivo - verificar o comportamento do sistema na inclusao de uma empresa com  
	 * <br> cnpj já cadastrado
	 */
	@Test
	public void CT03UC01FBCadastra_cnpj_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0, empresaDAO.adiciona(empresa));
	}
	
	/**
	 * ID - CT04UC01FBCadastra_db_invalido
	 * Objetivo - verificar o comportamento do sistema quando não é possível 
	 * <br> obter conexão com o bando de dados
	 */
	@Test
	public void CT04UC01FBCadastra_db_invalido() {
		String url = "jdbc:mysql://localhost/sceweb1";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "";
		configuraDB1 = new ConfiguraDB(url, driver,usuario,senha);
		empresaDAO = new EmpresaDAO(configuraDB);
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		empresaDAO.adiciona(empresa);
		
	}
	
	/**
	 * ID - CT05UC01FBCadastrar_nomeFantasia_invalido
	 * Objetivo - verificar o comportamento do sistema na inclusao de um nome fantasia 
	 * <br> em branco para empresa
	 */
	@Test
	public void CT05UC01FBCadastrar_nomeFantasia_invalido() {
		assertEquals("Nome fantasia não pode estar em branco!",
				empresa.setNomeFantasia(""));
	}
	
	/**
	 * ID - CT06UC01FBCadastrar_telefone_invalido
	 * Objetivo - verificar o comportamento do sistema na inclusao de um telefone 
	 * <br> inválido para empresa
	 */
	@Test
	public void CT06UC01FBCadastrar_telefone_invalido() {
		assertEquals("Telefone não pode estar em branco!",
				empresa.setTelefone(""));
	}
	
	/**
	 * Objetivo - Método exclui do banco de dados as inserções feitas para 
	 * <br> que os próximos testes possam ser feitos.
	 * @throws 
	 */
	@After
	public void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
}



