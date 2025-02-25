package br.com.contmatic.prova.utils;

public final class CpfUtils {

	private static final int ONZE = 11;
	private static final int VALOR_INICIAL_PESO_PRIMEIRO_DIGITO = 10;
	private static final int VALOR_INICIAL_PESO_SEGUNDO_DIGITO = 11;
	private static final int POSICAO_SEGUNDO_DIGITO_CPF = 10;
	private static final int POSICAO_PRIMEIRO_DIGITO_CPF = 9;
	private static final int ZERO = 0;
	private static final int NUMERO_0_TABELA_ASCII = 48;

	private CpfUtils() { // construtor private para ningeum instanciar essa classe 
	}

	public static void validaCpf(String cpf) {
		ValidacaoUtils.verificaNulo(cpf, "O campo Cpf é obrigatório");
		ValidacaoUtils.verificaValorVazio(cpf, "O campo CPF não deve ser vazio");
		ValidacaoUtils.verificaTamanhoLimite(cpf, 11, "O CPF deve ter 11 caracteres");
		ValidacaoUtils.verificaCaracteresRepetidos(cpf, "O CPF não deve conter uma sequencia de número repetidos");

		
		int numeroInteiro;
		int peso = VALOR_INICIAL_PESO_PRIMEIRO_DIGITO;
		int resultado;
		int soma = ZERO;
		char digitoUm;
		char digitoDois;
		
		for (int indice = ZERO; indice < POSICAO_PRIMEIRO_DIGITO_CPF; indice++) {
			numeroInteiro = (int) (cpf.charAt(indice) - NUMERO_0_TABELA_ASCII);
			soma = soma + (numeroInteiro * peso);
			peso = peso - 1;
		}

		resultado = 11 - (soma % 11);
		if (resultado == 10 || resultado == ONZE) {
			digitoUm = '0';
		} else {
			digitoUm = (char) (resultado + NUMERO_0_TABELA_ASCII);
		}

		// calculo do digito 2

		soma = ZERO;
		peso = VALOR_INICIAL_PESO_SEGUNDO_DIGITO;
		for (int indice = ZERO; indice < POSICAO_SEGUNDO_DIGITO_CPF; indice++) {
			numeroInteiro = (int) (cpf.charAt(indice) - NUMERO_0_TABELA_ASCII);
			soma = soma + (numeroInteiro * peso);
			peso = peso - 1;
		}

		resultado = 11 - (soma % 11);
		if (resultado == 10 || resultado == 11) {
			digitoDois = '0';
		} else {
			digitoDois = (char) (resultado + NUMERO_0_TABELA_ASCII);
		}

		if (digitoUm != cpf.charAt(POSICAO_PRIMEIRO_DIGITO_CPF)
				|| digitoDois != cpf.charAt(POSICAO_SEGUNDO_DIGITO_CPF)) {
			throw new IllegalArgumentException("CPF Inválido");
		}
	}
}
