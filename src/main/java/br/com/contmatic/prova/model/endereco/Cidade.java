package br.com.contmatic.prova.model.endereco;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.CidadeConstantes.CAMPO_NOME_MAXIMO_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.CidadeConstantes.CAMPO_NOME_MINIMO_2_CARACTERES;
import static br.com.contmatic.prova.utils.constants.CidadeConstantes.O_CAMPO_NOME_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.CidadeConstantes.O_CAMPO_NOME_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.CidadeConstantes.TAMANHO_2;
import static br.com.contmatic.prova.utils.constants.CidadeConstantes.TAMANHO_80;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.O_CAMPO_ESTADO_NAO_PODE_SER_NULO;

import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

public class Cidade extends Auditoria {

	private String nome;

	private Estado estado;

	public Cidade(String nomeCidade, Estado estado) {
		setNome(nomeCidade);
		setEstado(estado);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificaNulo(nome, O_CAMPO_NOME_NAO_PODE_SER_NULO);
		verificaValorVazio(nome, O_CAMPO_NOME_NAO_PODE_SER_VAZIO);
		verificaTamanhoMinimo(nome, TAMANHO_2, CAMPO_NOME_MINIMO_2_CARACTERES);
		verificaTamanhoMaximo(nome, TAMANHO_80, CAMPO_NOME_MAXIMO_80_CARACTERES);
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		verificaNulo(estado, O_CAMPO_ESTADO_NAO_PODE_SER_NULO);
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estado, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(estado, other.estado) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cidade [nome=");
		builder.append(nome);
		builder.append(", estado=");
		builder.append(estado);
		builder.append("]");
		return builder.toString();
	}
}
