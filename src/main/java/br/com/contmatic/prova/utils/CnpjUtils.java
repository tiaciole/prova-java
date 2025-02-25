package br.com.contmatic.prova.utils;


import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaCaracteresRepetidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoLimite;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.CnpjConstantes.PESO_INICIAL;
import static br.com.contmatic.prova.utils.constants.CnpjConstantes.PESO_LIMITE;
import static br.com.contmatic.prova.utils.constants.CnpjConstantes.POSICAO_0_TABELA_ASC;
import static br.com.contmatic.prova.utils.constants.CnpjConstantes.POSICAO_PRIMEIRO_DIGITO;
import static br.com.contmatic.prova.utils.constants.CnpjConstantes.POSICAO_SEGUNDO_DIGITO;

public final class CnpjUtils {	
	
	private CnpjUtils() { // Construtor private para ninguem conseguir instanciar essa classe 
	}
	
	public static void isCnpj(String cnpj) {
		verificaNulo(cnpj, "O campo cnpj é obrigatório");
		verificaValorVazio(cnpj, "O campo CNPJ não deve ser vazio");
		verificaTamanhoLimite(cnpj,14,"Cnpj Inválido");
		verificaCaracteresRepetidos(cnpj, "Cnpj inválido");
		validarDigitos(cnpj);
	}
	
	private static void validarDigitos(String cnpj) {
		char digitoUm = calcularDigitoVerificador(cnpj, PESO_INICIAL, POSICAO_PRIMEIRO_DIGITO);
		char digitoDois = calcularDigitoVerificador(cnpj, PESO_INICIAL, POSICAO_SEGUNDO_DIGITO);
		verificaCnpjValido(cnpj, digitoUm, digitoDois);
	}
	

	private static char calcularDigitoVerificador(String cnpj, int peso, int posicaoDigito) {
		int soma = obterSoma(cnpj, peso, posicaoDigito );
		int resultado = obterResultado(soma);
		return  extractedTeste(resultado);
	}

	private static char extractedTeste(int resultado) {
		return resultado == 0 ? '0' : (char) ((11 - resultado) + POSICAO_0_TABELA_ASC);
	}
	
	private static int obterSoma(String cnpj, int peso, int posicaoDigito) {
		int soma = 0;
		for (int i = posicaoDigito; i >= 0; i--) {
			int numeroInteiro = (cnpj.charAt(i) - POSICAO_0_TABELA_ASC);	
			soma += (numeroInteiro * peso); 
			peso ++;
			peso = definirValorPeso(peso);
		}
		return soma;
	}

	private static int definirValorPeso(int peso) {
		if (peso == PESO_LIMITE) {
			peso = PESO_INICIAL;
		}
		return peso;
	}

	private static int obterResultado(int soma) {
		int resultado = (soma % 11);
		if(resultado <= 1) {
			return 0;
		}
		return resultado;
	}

	private static void verificaCnpjValido(String cnpj, char digitoUm, char digitoDois) {
		if (digitoUm != cnpj.charAt(12) || digitoDois != cnpj.charAt(13)) {
			throw new IllegalArgumentException("Cnpj Inválido");
		}
	}
}
