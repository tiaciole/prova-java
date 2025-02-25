package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanoMaximoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanoMinimoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.O_CAMPO_FUNCIONARIO_DO_SETOR_E_OBRIGATORIO;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

public class Setor extends Auditoria {

	private String nome;

	private Funcionario chefe;

	private List<Funcionario> funcionarios;

	public Setor(String nome, Funcionario chefe) {
		setNome(nome);
		setChefe(chefe);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificaNulo(nome, "Campo Nome do Setor é obrigatório");
		verificaTamanhoMinimo(nome, 3, "O tamanho minimo do campo nome é de 3 caracteres");
		verificaTamanhoMaximo(nome, 80, "O tamanho maximo é de 80 caracteres" );
		verificaValorVazio(nome, "O campo Nome do Setor não pode contes espaços em branco");
		this.nome = nome;
	}

	public Funcionario getChefe() {
		return chefe;
	}

	public void setChefe(Funcionario chefe) {
		verificaNulo(chefe, "O campo Chefe do Setor é obrigatório");
		this.chefe = chefe;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		verificaNulo(funcionarios,O_CAMPO_FUNCIONARIO_DO_SETOR_E_OBRIGATORIO);
		verificaTamanoMinimoLista(funcionarios, 1, "É obrigatório o cadastro de no mínimo 1 funcionário");
		verificaTamanoMaximoLista(funcionarios, 10, "Nao é permitido uma lista com mais de 10 funcionarios");
		this.funcionarios = funcionarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chefe, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		return Objects.equals(chefe, other.chefe) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Setor [nome=");
		builder.append(nome);
		builder.append(", chefe=");
		builder.append(chefe);
		builder.append(", funcionarios=");
		builder.append(funcionarios);
		builder.append("]");
		return builder.toString();
	}
}
