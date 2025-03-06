package br.com.contmatic.prova.model.endereco;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaRegex;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.O_CAMPO_NOME_DO_ESTADO_E_OBRIGATORIO;

import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

public class Estado extends Auditoria {

	private static final int QUANTIDADE_MINIMA_80_CARACTERES = 80;

	private static final int QUANTIDADE_MINIMA_2 = 2;

	private String nome;

	private String uf;


	public Estado(String uf) {
		setUf(uf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificaNulo(nome, O_CAMPO_NOME_DO_ESTADO_E_OBRIGATORIO);
		verificaValorVazio(nome, O_CAMPO_NOME_DO_ESTADO_E_OBRIGATORIO);
		verificaTamanhoMinimo(nome, QUANTIDADE_MINIMA_2, "O tamanho minimo é de 2 caracteres");
		verificaTamanhoMaximo(nome, QUANTIDADE_MINIMA_80_CARACTERES, "O tamanho máximo é de 80 caracteres");
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		verificaNulo(uf, "O campo UF é obrigatório");
		verificaValorVazio(uf, "O campo UF é obrigatório");
		verificaTamanhoMinimo(uf, QUANTIDADE_MINIMA_2, "O tamanho minimo é de 2 caracteres");
		verificaTamanhoMaximo(uf, QUANTIDADE_MINIMA_2, "ufmanho máximo é de 2 caracteres");
		verificaRegex(uf, "[A-zà-ú\\s]+", "O campo Uf deve ser apenas letras");
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
