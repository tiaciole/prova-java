package br.com.contmatic.prova.utils;

import static java.time.ZonedDateTime.now;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

import br.com.contmatic.prova.model.empresa.Funcionario;

public final class ValidacaoUtils {

	private static final int SEGUNDO_CARACTER = 1;
	private static final int PRIMEIRO_CARACTER = 0;
	private static final LocalDate DATA_MAXIMA = LocalDate.now();
	private static final LocalDate DATA_MINIMA = LocalDate.of(1446, 1, 1);

	private ValidacaoUtils() {
	}

	public static void verificaNulo(Object valor, String mensagemErro) {
		if (valor == null) {
			throw new IllegalArgumentException(mensagemErro);
		}
	}

	public static void verificaValorMinimo(BigDecimal valor, BigDecimal valorMinimo, String mensagem) {
		if (valor.compareTo(valorMinimo) <= 0) {
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
		verificaNulo(valor, mensagemErro);
		if (valor.length() < tamanho) {
			throw new IllegalArgumentException(mensagemErro);
		}
	}

	public static void verificaTamanhoMaximo(String valor, int tamanho, String mensagemErro) {
		verificaNulo(valor, mensagemErro);
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
		char primeiroChar = valor.charAt(PRIMEIRO_CARACTER);
		for (int index = SEGUNDO_CARACTER; index < valor.length(); index++) {
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

	public static void verificaTamanoMinimoLista(List<Funcionario> collection, int tamanho, String mensagemErro) {
		if (collection.size() < tamanho) {
			throw new IllegalArgumentException(mensagemErro);

		}
	}

	public static void verificaTamanoMaximoLista(List<Funcionario> collection, int tamanho, String mensagemErro) {
		if (collection.size() > tamanho) {
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

	public static void verificaValorMinimo(Integer valor, int valorMinimo, String mensagem) {
		if (valor < valorMinimo) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void verificaValorMaximo(Integer valor, int valorMaximo, String mensagem) {
		if (valor > valorMaximo) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void verificaDataAuditoria(ZonedDateTime data, String mensagem) {
		if (data.isAfter(now().plusSeconds(3L))|| data.isBefore(now().minusSeconds(3L))){
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void verificaTamanhoLimite(String valor, int tamanhoLimite, String mensagem) {
		verificaNulo(valor, mensagem);
		if (valor.length() != tamanhoLimite) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
}
