package br.com.contmatic.prova.utils;

public final class CnpjUtil {	
	
	private CnpjUtil() { // Construtor private para ninguem conseguir instanciar essa classe 
	}

	public static void validaCnpj(String cnpj) {
		ValidacaoUtil.verificaNulo(cnpj, "O campo cnpj é obrigatório");
		if (cnpj.length() != 14) {
			throw new IllegalArgumentException("O CNPJ deve conter 14 caracteres");
		}
		if (cnpj.equals("1111111111111") || cnpj.equals("22222222222222") || cnpj.equals("33333333333333")
				|| cnpj.equals("44444444444444") || cnpj.equals("55555555555555") || cnpj.equals("66666666666666")
				|| cnpj.equals("77777777777777") || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")
				|| cnpj.equals("00000000000000")) {
			throw new IllegalArgumentException("CNPJ Inválido");
		}

		int numeroInteiro, peso, resultado, soma;
		char digitoUm;
		char digitoDois;

		peso = 2;
		soma = 0;

		for (int i = 11; i >= 0; i--) {
			numeroInteiro = (int) (cnpj.charAt(i) - 48);
			soma = soma + (numeroInteiro * peso);
			peso = peso + 1;
			if (peso == 10) {
				peso = 2;
			}

		}
		// primeiro digito
		resultado = (soma % 11);
		if (resultado == 0 || resultado == 1) {
			digitoUm = '0';
		} else
			digitoUm = (char) ((11 - resultado) + 48);

		peso = 2;
		soma = 0;
		// segundo digito
		for (int i = 12; i >= 0; i--) {
			numeroInteiro = (int) (cnpj.charAt(i) - 48);
			soma = soma + (numeroInteiro * peso);
			peso = peso + 1;
			if (peso == 10) {
				peso = 2;
			}
		}
		resultado = (soma % 11);
		if (resultado == 0 || resultado == 1) {
			digitoDois = '0';
		} else {
			digitoDois = (char) ((11 - resultado) + 48);
		}

		if (digitoUm != cnpj.charAt(12) || digitoDois != cnpj.charAt(13)) {
			throw new IllegalArgumentException("Cnpj Inválido");
		}
	}
}
