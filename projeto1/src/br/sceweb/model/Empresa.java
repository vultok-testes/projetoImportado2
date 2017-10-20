package br.sceweb.model;

import java.util.InputMismatchException;
/**
 * Esta classe registra as informações das empresas que estao autorizadas
 * a oferecer estagio para alunos
 * @author professor
 * @version 1.0
 *
 */
public class Empresa {
	String cnpj;
	String nomeDaEmpresa;
	String nomeFantasia;
	String endereco;
	String telefone;

	/**
	 * Método retorna o CNPJ da empresa
	 * @return O CNPJ da empresa
	 */
	public String getCnpj() {
		return cnpj;
	}
	
	/**
	 * Método udado para atribuir o CNPJ da empresa, antes validando-o
	 * @param cnpj
	 * @return Uma string informando o status da operação
	 */
	public String setCnpj(String cnpj) {
		String msg="";
		if(isValido(cnpj)){
			this.cnpj = cnpj;
		}else{
			msg = "CNPJ invalido.";
		}
		return msg;
	}

	/**
	 * Método retorna o nome da empresa
	 * @return O nome da empresa
	 */
	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	/**
	 * Método atribui o nome da empresa
	 * @param nomeDaEmpresa
	 */
	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		this.nomeDaEmpresa = nomeDaEmpresa;
	}

	/**
	 * Método retorna o nome da empresa
	 * @return O nome fantasia da empresa
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * Método atribui o nome fantasia da empresa, antes velidando-o para não permitir nomes em branco
	 * @param nomeFantasia
	 * @return Uma String informando o status da operação
	 */
	public String setNomeFantasia(String nomeFantasia) {
		String msg = "0";
		
		if(nomeFantasia.length() == 0) {
			msg = "Nome fantasia não pode estar em branco!";
		} else {
			this.nomeFantasia = nomeFantasia;
		}
		
		return msg;
	}

	/**
	 * Método retorna o endereço da empresa
	 * @return O endereço
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Atribui o endereço da empresa
	 * @param endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Método retorna o telefone da empresa
	 * @return O telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Método atribui o telefone da empresa, validando-o para não permitir números em branco
	 * @param telefone
	 * @return Uma string com 0, caso válido; caso contrário uma mensagem informando o ocorrido
	 */
	public String setTelefone(String telefone) {
		String msg = "0";
		
		if(telefone.length() == 0) {
			msg = "Telefone não pode estar em branco!";
		} else {
			this.telefone = telefone;
		}
		
		return msg;
	}
	
	/**
	 * Método usado para validar o CNPJ inserido
	 * <br>O método verifica se o CNPJ não está em branco, se não foram inseridos apenas 
	 * <br>números iguais e verifica se os digitos verificadores estão corretos.
	 * @param cnpj - O CNPJ a ser validado
	 * @return <b><code>false</code></b> se for inválido <br><b><code>true</code></b> se for válido
	 */
	public boolean isValido(String cnpj) {
		char dig13, dig14; 
		int sm, i, r, num, peso;
		if (cnpj.equals("00000000000000") || 
				cnpj.equals("11111111111111") || 
				cnpj.equals("22222222222222") || 
				cnpj.equals("33333333333333") || 
				cnpj.equals("44444444444444") || 
				cnpj.equals("55555555555555") ||
				cnpj.equals("66666666666666") || 
				cnpj.equals("77777777777777") || 
				cnpj.equals("88888888888888") || 
				cnpj.equals("99999999999999") || 
				(cnpj.length() != 14)) {
			return(false); 
		}
		// "try" - protege o código para eventuais erros de conversao de tipo (int) 
		try { // Calculo do 1o. Digito Verificador 
			sm = 0; 
			peso = 2; 
			for (i=11; i>=0; i--) { 
				// converte o i-ésimo caractere do CNPJ em um número: 
				// por exemplo, transforma o caractere '0' no inteiro 0 
				// (48 eh a posição de '0' na tabela ASCII) 
				num = (int)(cnpj.charAt(i) - 48); 
				sm = sm + (num * peso); 
				peso = peso + 1; if (peso == 10) 
					peso = 2; 
			} 
			r = sm % 11; 
			if ((r == 0) || (r == 1)) 
				dig13 = '0'; 
			else 
				dig13 = (char)((11-r) + 48);
		
		// Calculo do 2o. Digito Verificador 
		sm = 0; peso = 2; 
		for (i=12; i>=0; i--) { 
			num = (int)(cnpj.charAt(i)- 48); 
			sm = sm + (num * peso); peso = peso + 1; 
			if (peso == 10) peso = 2; 
			} 
		r = sm % 11; 
		if ((r == 0) || (r == 1)) dig14 = '0';
		else dig14 = (char)((11-r) + 48); 
		// Verifica se os dígitos calculados conferem com os dígitos informados. 
		if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) 
			return(true); else return(false);
		}
		
		catch (InputMismatchException erro) {
			erro.printStackTrace();
	        return(false);
	    }
	}

}
