package br.com.contmatic.prova.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import br.com.contmatic.prova.model.empresa.Funcionario;

public final class ValidacaoUtil {

	private static final LocalDate DATA_MAXIMA = LocalDate.now();
	private static final LocalDate DATA_MINIMA = LocalDate.of(1446, 1, 1);

	private ValidacaoUtil() {
	}

	public static void verificaNulo(Object valor, String mensagemErro) {
		if (valor == null) {
			throw new IllegalArgumentException(mensagemErro);
		}
	}

	public static void verificaValorMinimo(BigDecimal valor, BigDecimal valorMinimo, String mensagem) {
		if (valor.compareTo(valorMinimo) < 0) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void verificaValorMaximo(BigDecimal valor, BigDecimal valorMaximo, String mensagem) {
		if (valor.compareTo(valorMaximo) > 0) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void verificaValorVazio(String vazio, String mensagemErro) {
		if (vazio.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagemErro);
		}
	}

	public static void verificaTamanhoMinimo(String valor, int tamanho, String mensagemErro) {
		if (valor.length() < tamanho) {
			throw new IllegalArgumentException(mensagemErro);
		}
	}

	public static void verificaTamanhoMaximo(String valor, int tamanho, String mensagemErro) {
		if (valor.length() > tamanho) {
			throw new IllegalArgumentException(mensagemErro);
		}
	}

	public static void verificaRegex(String valor, String regex, String mensagem) {
		if (!valor.matches(regex)) {
			throw new IllegalArgumentException(mensagem);

		}
	}

	public static void verificaCaracteresRepetidos(String valor, String mensagem) {
		char primeiroChar = valor.charAt(0);
		for (int index = 1; index < valor.length(); index++) {
			char atual = valor.charAt(index);
			if (atual != primeiroChar) {
				return;
			}
		}
		throw new IllegalArgumentException(mensagem);
	}

	public static void verificaListaVazia(Set<?> collection, String mensagem) {
		if (collection.isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void verificaTamanoMinimoLista(Set<?> collection, int tamanho, String mensagemErro) {
		if (collection.size() < tamanho) {
			throw new IllegalArgumentException(mensagemErro);

		}
	}

	public static void verificaTamanoMaximoLista(Set<?> collection, int tamanho, String mensagemErro) {
		if (collection.size() > tamanho) {
			throw new IllegalArgumentException(mensagemErro);
		}
	}

	// validação Funcionario como List devido poder existir funcionario com o mesmo
	// nome (Ver com Guilherme)

	public static void verificaListaVazia(List<Funcionario> collection, String mensagem) {
		if (collection.isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void verificaTamanoMinimoLista(List<Funcionario> collection, int tamanho, String mensagemErro) {
		if (collection.size() < tamanho) {
			throw new IllegalArgumentException(mensagemErro);

		}
	}

	public static void verificaDataMinima(LocalDate data, String mensagem) {
		if (data.isBefore(DATA_MINIMA)) {
			throw new IllegalArgumentException(mensagem);
		}

	}

	public static void verificaDataMaxima(LocalDate data, String mensagem) {
		if (data.isAfter(DATA_MAXIMA)) {
			throw new IllegalArgumentException(mensagem);
		}
	}

}
