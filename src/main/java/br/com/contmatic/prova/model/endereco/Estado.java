package br.com.contmatic.prova.model.endereco;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaRegex;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.CAMPO_UF_MAXIMO_E_MAXIMO_DE_2_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.CAMPO_UF_MINIMO_2_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.NOME_DO_ESTADO_O_MINIMO_E_2_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.O_CAMPO_ESTADO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.O_CAMPO_ESTADO_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.O_CAMPO_UF_DEVE_SER_APENAS_LETRAS;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.O_CAMPO_UF_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.O_CAMPO_UF_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.O_TAMANHO_MAXIMO_NO_CAMPO_NOME_ESTADO_E_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.REGEX_UF;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.TAMANHO_2;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.TAMANHO_80;

import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

public class Estado extends Auditoria {

	private String nome;

	private String uf;


	public Estado(String uf) {
		setUf(uf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificaNulo(nome, O_CAMPO_ESTADO_NAO_PODE_SER_NULO);
		verificaValorVazio(nome, O_CAMPO_ESTADO_NAO_PODE_SER_VAZIO);
		verificaTamanhoMinimo(nome, TAMANHO_2, NOME_DO_ESTADO_O_MINIMO_E_2_CARACTERES);
		verificaTamanhoMaximo(nome, TAMANHO_80, O_TAMANHO_MAXIMO_NO_CAMPO_NOME_ESTADO_E_80_CARACTERES);
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		verificaNulo(uf, O_CAMPO_UF_NAO_PODE_SER_NULO );
		verificaValorVazio(uf,O_CAMPO_UF_NAO_PODE_SER_VAZIO );
		verificaTamanhoMinimo(uf, TAMANHO_2, CAMPO_UF_MINIMO_2_CARACTERES);
		verificaTamanhoMaximo(uf, TAMANHO_2, CAMPO_UF_MAXIMO_E_MAXIMO_DE_2_CARACTERES);
		verificaRegex(uf, REGEX_UF , O_CAMPO_UF_DEVE_SER_APENAS_LETRAS);
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (null == obj)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(uf, other.uf);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Estado [nome=");
		builder.append(nome);
		builder.append(", uf=");
		builder.append(uf);
		builder.append("]");
		return builder.toString();
	}
}
