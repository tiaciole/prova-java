package br.com.contmatic.prova.utils;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaCaracteresRepetidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoLimite;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.CpfConstantes.CPF_INVALIDO;
import static br.com.contmatic.prova.utils.constants.CpfConstantes.O_CPF_DEVE_TER_11_CARACTERES;
import static br.com.contmatic.prova.utils.constants.CpfConstantes.O_CPF_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.CpfConstantes.O_CPF_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.CpfConstantes.TAMANHO_11;

import br.com.contmatic.prova.utils.constants.CpfConstantes;

public final class CpfUtils {

	private static final int UM = 1;
	private static final int NOVE = 9;
	private static final int ONZE = 11;
	private static final int VALOR_INICIAL_PESO_PRIMEIRO_DIGITO = 10;
	private static final int VALOR_INICIAL_PESO_SEGUNDO_DIGITO = 11;
	private static final int POSICAO_SEGUNDO_DIGITO_CPF = 10;
	private static final int POSICAO_PRIMEIRO_DIGITO_CPF = 9;
	private static final int ZERO = 0;
	private static final int NUMERO_0_TABELA_ASCII = 48;

	private CpfUtils() { 
	}
	
	public static void isCPF(String cpf) {
		verificaNulo(cpf, O_CPF_NAO_PODE_SER_NULO);
		verificaValorVazio(cpf, O_CPF_NAO_PODE_SER_VAZIO);
		verificaTamanhoLimite(cpf, TAMANHO_11, O_CPF_DEVE_TER_11_CARACTERES);
		verificaCaracteresRepetidos(cpf, CPF_INVALIDO );
		validaDigitos(cpf);
	}
	
	private static void validaDigitos(String cpf) {
		char digitoUm = obterDigitoVerificador(cpf, VALOR_INICIAL_PESO_PRIMEIRO_DIGITO, POSICAO_PRIMEIRO_DIGITO_CPF);
		char digitoDois = obterDigitoVerificador(cpf, VALOR_INICIAL_PESO_SEGUNDO_DIGITO, POSICAO_SEGUNDO_DIGITO_CPF);
		verificarCpfValido(cpf, digitoUm, digitoDois);
	}
	
	private static char obterDigitoVerificador(String cpf, int peso, int posicaoDigito) {
		int soma = obterValorSoma(cpf, peso, posicaoDigito);
		int resultado = ONZE - (soma % ONZE);
		if (resultado > NOVE) {
		return '0';
		} 
		return (char) (resultado + NUMERO_0_TABELA_ASCII);
	}
	
	private static int obterValorSoma(String cpf, int peso, int posicaoDigito) {
		int soma = ZERO;
		for (int indice = ZERO; indice < posicaoDigito; indice++) {
			int numeroInteiro = (cpf.charAt(indice) - NUMERO_0_TABELA_ASCII);
			soma = soma + (numeroInteiro * peso);
			peso = peso - UM;
		}
		return soma;
	}

	private static void verificarCpfValido(String cpf, char digitoUm, char digitoDois) {
		if (digitoUm != cpf.charAt(POSICAO_PRIMEIRO_DIGITO_CPF)
				|| digitoDois != cpf.charAt(POSICAO_SEGUNDO_DIGITO_CPF)) {
			throw new IllegalArgumentException(CPF_INVALIDO);
		}
	}	
}
