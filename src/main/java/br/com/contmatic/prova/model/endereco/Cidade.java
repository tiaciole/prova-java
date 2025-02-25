package br.com.contmatic.prova.model.endereco;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.CidadeConstantes.O_CAMPO_NOME_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.CidadeConstantes.O_CAMPO_NOME_NAO_PODE_SER_VAZIO;

import java.util.Objects;

public class Cidade {

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
		verificaTamanhoMinimo(nome, 2, "O tamanho minimo é de 2 caracteres");
		verificaTamanhoMaximo(nome, 80, "O tamanho máximo é de 80 caracteres");
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		verificaNulo(estado, "O preenchimento do Estado é obrigatório");
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
