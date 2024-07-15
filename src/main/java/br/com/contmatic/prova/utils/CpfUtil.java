package br.com.contmatic.prova.utils;

public final class CpfUtil {

	private static final int ONZE = 11;
	private static final int VALOR_INICIAL_PESO_PRIMEIRO_DIGITO = 10;
	private static final int VALOR_INICIAL_PESO_SEGUNDO_DIGITO = 11;
	private static final int POSICAO_SEGUNDO_DIGITO_CPF = 10;
	private static final int POSICAO_PRIMEIRO_DIGITO_CPF = 9;
	private static final int ZERO = 0;
	private static final int NUMERO_0_TABELA_ASCII = 48;

	private CpfUtil() { // construtor private para ningeum instanciar essa classe 
	}

	public static void validaCpf(String cpf) {

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("O CPF deve ter 11 caracteres");
		}
		if (cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333")
				|| cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666")
				|| cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999")
				|| cpf.equals("00000000000")) {
			throw new IllegalArgumentException("O CPF não deve conter uma sequencia de número repetidos");
		}

		int numeroInteiro, peso, resultado, soma;
		char digitoUm;
		char digitoDois;

		peso = VALOR_INICIAL_PESO_PRIMEIRO_DIGITO;
		soma = ZERO;

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
